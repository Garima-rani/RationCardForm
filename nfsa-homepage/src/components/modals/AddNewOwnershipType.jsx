import React from "react";
import Input from "../common/Input";
import { useForm } from "react-hook-form";
import { Box } from "@mui/material";
import axios from "axios";
import { useDispatch } from "react-redux";
import { setData } from "../../redux/slices/masterSlice";
import Select from "../common/Select";

function AddNewOwnershipType({ master, setOpen }) {
    const dispatch = useDispatch();
    
    const { register, handleSubmit, reset, formState: { errors } } = useForm({
        mode: "onBlur",
    });

    const submitHandler = async (data) => {
        try {
            const formObj = {
                name: data.name,
                status: data.status , 
                feedBy: data.feedBy,
                remarks: data.remarks || "",
                feedDate : new Date(Date.now())
            };

            // POST request to add new commodity group
            await axios.post(`http://localhost:8080/api/ownership-types`, formObj);

            // Fetch updated data
            const response = await axios.get(`http://localhost:8080/api/ownership-types`);

            // Update Redux state
            dispatch(setData(response.data));

            // Reset the form
            reset();

            // Close the modal
            setOpen(false);
        } catch (error) {
            console.error("Error during form submission:", error);
            alert("There was an error submitting the form.");
        }
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
                        label="Ownership Type Name"
                        {...register("name", { required: "Ownership Type Name is required" })}
                    />
                    {errors.name && <p>{errors.name.message}</p>}

            

                    <Input
                        label="Feed By"
                        {...register("feedBy", { required: "Feed By is required" })}
                    />
                    {errors.feedBy && <p>{errors.feedBy.message}</p>}

                    <Input label="Remarks" {...register("remarks")} />
                    <Select label="Status" options={[{name :"active"} , {name : "inactive"}]} {...register("status")}/>

                    <button type="submit">Submit</button>
                </form>
            </div>
        </Box>
    );
}

export default AddNewOwnershipType;
