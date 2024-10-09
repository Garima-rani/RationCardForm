import React from "react";
import Input from "../common/Input";
import { useForm } from "react-hook-form"; 
import { Box } from "@mui/material";
import axios from "axios";
import { useDispatch } from "react-redux";
import { setData } from "../../redux/slices/masterSlice";
import Select from "../common/Select";
import { useFetchOptions } from "../../hook/useFetchOption";

function AddNewCommodityForm({ master, setOpen }) {
    const dispatch = useDispatch();
 
    const { register, handleSubmit, reset, formState: { errors } } = useForm({
        mode: "onBlur",
    });

    const submitHandler = async (data) => {
        try {
            const formObj = {
                commodityFormCode: data.commodityFormCode,
                commodityFormName: data.commodityFormName,
                commodityFormLocalName: data.commodityFormLocalName,
                commodityFormShortName: data.commodityFormShortName,
                feedBy: data.feedBy,
                feedDate : new Date(Date.now()),
                remarks: data.remarks || "",
                status: data.status                
            };

            // POST request to add new commodity group
            await axios.post(`http://localhost:8080/api/commodity-forms`, formObj);

            // Fetch updated data
            const response = await axios.get(`http://localhost:8080/api/commodity-group`);

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
                        label="Commodity Form Name"
                        {...register("commodityFormName", { required: "Group Name is required" })}
                    />
                    {errors.commodityFormName && <p>{errors.commodityFormName.message}</p>}

                    <Input
                        label="Commodity Form Name In Local Language"
                        {...register("commodityFormLocalName", { required: "Local Name is required" })}
                    />
                    {errors.commodityFormLocalName && <p>{errors.commodityFormLocalName.message}</p>}

                    <Input
                        label="Commodity Form Short Name"
                        {...register("commodityFormShortName", { required: "Short Name is required" })}
                    />
                    {errors.commodityFormShortName && <p>{errors.commodityFormShortName.message}</p>}

                    

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

export default AddNewCommodityForm;
