import React, { useState, useEffect } from "react";
import Input from "../common/Input";
import { useForm } from "react-hook-form";
import { Box } from "@mui/material";
import axios from "axios";
import { useDispatch } from "react-redux";
import { setData } from "../../redux/slices/masterSlice";
import Select from "../common/Select";
import { useFetchOptions } from "../../hook/useFetchOption";
import { handleDocumentChange } from "../../utils/handleImageChange";

function AddNewState({ master, setOpen }) {
    const [loading , setLoading] = useState(false) ;
    const [tags, setTags] = useState([]);
    const { options: procurementOptions } = useFetchOptions("/api/procurement-types");
    const { options: ownershipOptions } = useFetchOptions("/api/ownership-types");
    const { options: categoryOptions } = useFetchOptions("/api/categories");
    const [suggestions, setSuggestions] = useState([]);
    const [allStates, setAllStates] = useState([]);
    const dispatch = useDispatch();

    // State variables to track the selected options
    const [selectedProcurementType, setSelectedProcurementType] = useState(null);
    const [selectedCategory, setSelectedCategory] = useState(null);
    const [selectedOwnershipType, setSelectedOwnershipType] = useState(null);

    const methods = useForm();
    const { register, handleSubmit, reset, formState: { errors } } = methods ; 

    const handleDelete = (i) => {
        setTags(tags.filter((tag, index) => index !== i));
    };

    const handleAddition = (tag) => {
        if (suggestions.some((suggestion) => suggestion.stateName === tag.stateName)) {
            setTags([...tags, tag]);
        } else {
            alert("Please select from the available suggestions.");
        }
    };

    const submitHandler = async (data) => {
        try {
            // Create a FormData object to handle file upload
            const formObj = {
                
            }
            const formData = new FormData();
            formData.append("stateName", data.stateName);
            formData.append("localName", data.localName);
            formData.append("shortName", data.shortName);
            formData.append("description", data.description);
            formData.append("code", data.code);
            formData.append("status", data.status);
            formData.append("procurementType", selectedProcurementType);
            formData.append("category", selectedCategory);
            formData.append("ownershipType", selectedOwnershipType);

            // Append the file if it's present
        //   console.log("Sel" , selectedProcurementType)
                // formData.append("document", data.document);
            console.log(data) ; 

            const res = await axios.post(`http://localhost:8080/api/states`, data);
            console.log(res) ; 

            const response = await axios.get(`http://localhost:8080/api/states`);
            dispatch(setData(response.data));
            reset();
            setOpen(false);
        } catch (error) {
            console.log(error)
            if (error.response) {
                alert(error.response.data.message || "An error occurred. Please try again.");
            } else {
                alert("An unexpected error occurred. Please try again.");
            }
            console.log(error);
        }
    };

    const handleSearchChange = (event) => {
        const value = event.target.value;
        const filteredStates = allStates.filter(state =>
            state.stateName.toLowerCase().includes(value.toLowerCase())
        );
        setSuggestions(filteredStates);
    };

    const handleSelectState = (state) => {
        handleAddition({ stateName: state.stateName });
        setSuggestions([]);
    };

    useEffect(() => {
        const fetchAllStates = async () => {
            try {
                const response = await axios.get('http://localhost:8080/api/states');
                setAllStates(response.data);
            } catch (error) {
                console.error("Failed to fetch states:", error);
            }
        };
        fetchAllStates();
    }, []);

    return (
        <Box
            sx={{
                position: "absolute",
                top: "50%",
                left: "50%",
                transform: "translate(-50%, -50%)",
                bgcolor: "gray",
                boxShadow: 24,
            }}
        >
            <div className="bg-[whitesmoke] w-full p-5 flex flex-col gap-10 rounded-md max-h-[80vh] overflow-auto">
                <h1 className="capitalize">Add {master}</h1>
                <form
                    onSubmit={handleSubmit(submitHandler)}
                    className="border border-black min-w-[500px] card flex flex-col gap-4"
                >
                    <Input
                        label="State Name"
                        placeholder="State Name"
                        required={true}
                        {...register("stateName", { required: "State Name is required" })}
                    />
                    <Input
                        label="State Name Local Language"
                        placeholder="Local Name"
                        required={true}
                        {...register("localName", { required: "Local Name is required" })}
                    />
                    <Input
                        label="Short Name"
                        placeholder="Short Name"
                        required={true}
                        {...register("shortName", { required: "Short Name is required" })}
                    />
                    {/* File Input for Document Upload */}
                    <Input
                        type="file"
                        onChange ={(event)=>{handleDocumentChange(event, methods , "document" , setLoading)}}
                        label="Upload Document"
                        // {...register("document", { required: "Document is required" })}
                    />
                    {/* Select inputs for dynamic options */}
                    <Select 
                        label="Procurement Type" 
                        options={procurementOptions} 
                        onChange={(e) => setSelectedProcurementType(e.target.value)}
                        {...register("procurementType", { required: "Procurement Type is required" })} 
                    />
                    <Select 
                        label="Category of States and UTs" 
                        options={categoryOptions} 
                        onChange={(e) => setSelectedCategory(e.target.value)}
                        {...register("category", { required: "Category is required" })} 
                    />
                    <Select 
                        label="PDS Ownership Type" 
                        options={ownershipOptions} 
                        onChange={(e) => setSelectedOwnershipType(e.target.value)}
                        {...register("ownershipType", { required: "Ownership Type is required" })} 
                    />
                    <Input label="Description" {...register("description")} />
                    <Input label="Code" {...register("code")} />
                    <Select 
                        label="Status" 
                        options={[{ id: 1, name: "Active" }, { id: 2, name: "Inactive" }]} 
                        {...register("status", { required: "Status is required" })} 
                    />
                    <button type="submit">Submit</button>
                </form>
            </div>
        </Box>
    );
}

export default AddNewState;
