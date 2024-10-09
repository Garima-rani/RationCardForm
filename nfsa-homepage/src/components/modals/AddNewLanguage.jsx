// import React, { useDebugValue, useEffect } from "react";
// import Input from "../common/Input";
// import { useForm } from "react-hook-form";
// import { Box } from "@mui/material";
// import axios from "axios";
// import Select from "../common/Select";
// import { WithContext as ReactTagInput } from "react-tag-input";
// import { useDispatch } from "react-redux";
// import { setData } from "../../redux/slices/masterSlice";

  

// function AddNewLanguage({ master, setOpen, setTableData }) {
//     const [tags, setTags] = React.useState([]);
//     const [suggestions, setSuggestions] = React.useState([]);
//     const dispatch = useDispatch();


//     const KeyCodes = {
//         comma: 188,
//         enter: 13,
//       };
//       useEffect(() => {
//         const fetchData = async () => {
//           try {
//             const response = await axios.get("http://localhost:8080/api/state-s");
//             const fetchedStates = response.data;
    
//             // Transform the data to { id, text } format for ReactTagInput
//             const transformedData = fetchedStates.map((state) => ({
//               id: state.id.toString(), // Convert id to string
//               text: state.stateName,    // Map stateName to text
//             }));
    
//             setSuggestions(transformedData);
//           } catch (error) {
//             console.error("Error fetching states:", error);
//           }
//         };
    
//         fetchData();
//       }, []);
//       const delimiters = [KeyCodes.comma, KeyCodes.enter];
//       const handleDelete = (i) => {
//         setTags(tags.filter((tag, index) => index !== i));
//       };
    
//       const handleAddition = (tag) => {
//         console.log(tag)
//         if (suggestions.some((suggestion) => suggestion.text === tag.text)) {
//           setTags([...tags, tag]);
//         } else {
//           alert("Please select from the available suggestions.");
//         }
//       };
//   const { register, handleSubmit , reset , formState : {errors}} = useForm();
//   console.log(errors)
//   const submitHandler = async (data) => {
//     try {
//         const formObj = {...data , states: tags}
//         console.log(formObj) ; 
//      let response   =  await axios.post(`http://localhost:8080/api/languages`, 
//         formObj
        
//       );
//        response = await axios.get(`http://localhost:8080/api/${master}`);
//       console.log(response);
//       dispatch(setData(response.data));
//       console.log(response)
//     //   const response = await axios.get(
//     //     `http://localhost:8080/api/masters/${master}`
//     //   );
//     //   console.log(response.data);
//     //   setTableData(response.data);
//     reset()
//       setOpen(false);

   


//     } catch (error) {
//       console.log(error);
//     }
//   };
//   return (
//     <Box
//       sx={{
//         position: "absolute",
//         top: "50%",
//         left: "50%",
//         transform: "translate(-50%, -50%)",
//         bgcolor: "gray",
//         boxShadow: 24,
//         // borderRadius : "20px" ,
//       }}
//     >
//       <div className="bg-[whitesmoke] w-full p-5 flex flex-col gap-10 rounded-md max-h-[80vh] overflow-auto ">
//         <h1 className="capitalize">Add {master}</h1>
//         <form
//           onSubmit={handleSubmit(submitHandler)}
//           className="border  border-black min-w-[500px] card flex flex-col gap-4"
//         >
//           {/* <Input label="Master Id" placeholder="10000" required={true} {...register("id" , {required:"ID is required"})} /> */}
//           <Input
//             label="Language Name"
//             placeholder="Language Name"
//             required={true}
//             {...register("languageName", {
//               required: "Language Name is required",
//             })}
//           />
//            <Input
//             label="Local Name"
//             placeholder="Local Name"
//             required={true}
//             {...register("languageLocalName", { required: "Name is required" })}
//           />
//           <Input
//             label="Language Code"
//             placeholder="Language code"
//             required={true}
//             {...register("languageCode", {
//               required: "Language Code is required",
//             })}
//           />
//           <Input
//             label="Short Name"
//             placeholder="Short Name"
//             required={true}
//             {...register("shortName", { required: "Name is required" })}
//           />
//           <ReactTagInput
//           tags={tags}
//           delimiters={delimiters}
//           suggestions={suggestions}
//         //   separators={[SEPARATORS.ENTER, SEPARATORS.COMMA]}
//           handleDelete={handleDelete}
//           handleAddition={handleAddition}
//           allowDragDrop={false}
//           placeholder="Enter States"
//         //   handleDrag={handleDrag}
//         //   handleTagClick={handleTagClick}
//         //   onTagUpdate={onTagUpdate}
//           autocomplete
//           inputFieldPosition="bottom"
//          {...register("states" , {required: false})}
          
//           maxTags={36}
//         />
           
//           <Input
//             label="Script"
//             placeholder="Script"
//             required={true}
//             {...register("script", { required: "Name is required" })}
//           />
//           <Input
//             label="Remarks"
//             placeholder="Remarks"
//             required={true}
//             {...register("remarks", { required: "Reamrks are required" })}
//           />
         
//           <Select
//             options={[{ name: "Active" }, { name: "Inactive" }]}
//             label="Is Active"
//             placeholder="Select"
//             required={true}
//             {...register("status", { required: "Name is required" })}
//           />
//           <button className="" type="submit">
//             Submit
//           </button>
//         </form>
//       </div>
//     </Box>
//   );
// }

// export default AddNewLanguage;
import React, { useEffect, useState } from "react";
import Input from "../common/Input";
import { useForm } from "react-hook-form";
import { Box } from "@mui/material";
import axios from "axios";
import { useDispatch } from "react-redux";
import { setData } from "../../redux/slices/masterSlice";
import Select from "../common/Select";

function AddNewLanguage({ master, setOpen }) {
    const [tags, setTags] = useState([]);
    const [suggestions, setSuggestions] = useState([]);
    const [allStates, setAllStates] = useState([]); // For the dropdown
    const dispatch = useDispatch();
    
    const { register, handleSubmit, reset, formState: { errors } } = useForm();
    
    useEffect(() => {
        const fetchData = async () => {
            try {
                const response = await axios.get("http://localhost:8080/api/states");
                const fetchedStates = response.data;
                console.log(response.data)

                // Store all states for dropdown
                setAllStates(fetchedStates);
                setSuggestions(fetchedStates); // Initialize suggestions with all states
            } catch (error) {
                console.error("Error fetching states:", error);
            }
        };

        fetchData();
    }, []);
    
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
            const formObj = { ...data, states: tags };
            await axios.post(`http://localhost:8080/api/languages`, formObj);
            const response = await axios.get(`http://localhost:8080/api/${master}`);
            dispatch(setData(response.data));
            reset();
            setOpen(false);
        } catch (error) {
            console.log(error);
        }
    };

    // Handle input change to filter suggestions
    const handleSearchChange = (event) => {
        const value = event.target.value;
        // console.log(allStates)

        const filteredStates = allStates.filter(state => 
            state.stateName.toLowerCase().includes(value.toLowerCase())
        );
        console.log(filteredStates)
        setSuggestions(filteredStates);
    };

    const handleSelectState = (state) => {
        handleAddition({ stateName: state.stateName });
        setSuggestions([]); // Clear suggestions after selection
    };

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
                        label="Language Name"
                        placeholder="Language Name"
                        required={true}
                        {...register("languageName", {
                            required: "Language Name is required",
                        })}
                    />
                    <Input
                        label="Local Name"
                        placeholder="Local Name"
                        required={true}
                        {...register("languageLocalName", { required: "Name is required" })}
                    />
                    <Input
                        label="Language Code"
                        placeholder="Language code"
                        required={true}
                        {...register("languageCode", {
                            required: "Language Code is required",
                        })}
                    />
                    <Input
                        label="Short Name"
                        placeholder="Short Name"
                        required={true}
                        {...register("shortName", { required: "Name is required" })}
                    />

                    {/* Search Input for States with Suggestions */}
                    <div>
                        <input
                            type="text"
                            placeholder="Type to search states..."
                            onChange={handleSearchChange}
                            className="border border-gray-300 rounded p-2 w-full"
                        />

                        {/* Suggestions Dropdown */}
                        {suggestions && (
                            <div className=" max-h-[150px] overflow-auto bg-gray-300 ">
                                {suggestions.map((state) => (
                                    <div
                                        key={state.id}
                                        className="p-2 hover:bg-gray-200 cursor-pointer "
                                        onClick={() => handleSelectState(state)}
                                    >
                                        {state.stateName}
                                        {console.log(state) }
                                    </div>
                                ))}
                            </div>
                        )}
                    </div>

                    <div>
                        <h3>Selected States:</h3>
                        {tags.map((tag, index) => (
                            <span key={index} className="border border-gray-300 p-1 m-1">
                                {tag.stateName}
                                <button type="button" onClick={() => handleDelete(index)}>x</button>
                            </span>
                        ))}
                    </div>

                    <Input
                        label="Script"
                        placeholder="Script"
                        required={true}
                        {...register("script", { required: "Script is required" })}
                    />
                    <Input
                        label="Remarks"
                        placeholder="Remarks"
                        required={true}
                        {...register("remarks", { required: "Remarks are required" })}
                    />

                    <Select
                        options={[{ name: "Active" }, { name: "Inactive" }]}
                        label="Is Active"
                        placeholder="Select"
                        required={true}
                        {...register("status", { required: "Status is required" })}
                    />
                    <button type="submit">Submit</button>
                </form>
            </div>
        </Box>
    );
}

export default AddNewLanguage;
