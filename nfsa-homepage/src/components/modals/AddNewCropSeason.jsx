import React from "react";
import Input from "../common/Input";
import { useForm } from "react-hook-form";
import { Box } from "@mui/material";
import axios from "axios";
import { useDispatch } from "react-redux";
import { setData } from "../../redux/slices/masterSlice";
import Select from "../common/Select";

function AddNewCropSeason({ master, setOpen }) {
    const dispatch = useDispatch();
    
    const { register, handleSubmit, reset, formState: { errors } } = useForm({
        mode: "onBlur",
    });

    const submitHandler = async (data) => {
        try {
            const formObj = {
                cropSeasonCode: data.cropSeasonCode,
                cropSeasonName: data.cropSeasonName , 
                cropSeasonShortName: data.cropSeasonShortName,
                cropSeasonLocalName: data.cropSeasonLocalName,
                majorCropSeason: data.majorCropSeason,
                feedBy: data.feedBy,
                remarks:data.remarks,
                status:data.status,
                feedDate : new Date(Date.now())
            };

            // POST request to add new commodity group
            await axios.post(`http://localhost:8080/api/procurement-types`, formObj);

            // Fetch updated data
            const response = await axios.get(`http://localhost:8080/api/procurement-types`);

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
                        label="Crop Season Name"
                        {...register("cropSeasonName", { required: "Crop Season Name is required" })}
                    />
                    {errors.cropSeasonName && <p>{errors.cropSeasonName.message}</p>}

                    <Input
                        label="Crop Season Code"
                        {...register("cropSeasonCode", { required: "Crop Season Code is required" })}
                    />
                    {errors.cropSeasonCode && <p>{errors.cropSeasonCode.message}</p>}

                    <Input
                        label=" Crop Season Name In Local Language"
                        {...register("cropSeasonLocalName", { required: "Local Name is required" })}
                    />
                    {errors.cropSeasonLocalName && <p>{errors.cropSeasonLocalName.message}</p>}
                    <Input
                        label="Crop Season Short Name"
                        {...register("cropSeasonShortName", { required: "Short Name is required" })}
                    />
                    {errors.majorCropSeason && <p>{errors.majorCropSeason.message}</p>}

                  <Select label="Major Crop Season" options={[{name :"Kharif"} , {name :"Rabi"} , {name:"Zayad"} , {name : "Others"}]} {...register("majorCropSeason")}/>
                     
                      <Input label="Remarks" {...register("remarks")} />

                      
                    <Input
                        label="Feed By"
                        {...register("feedBy", { required: "Feed By is required" })}
                    />
                    {errors.feedBy && <p>{errors.feedBy.message}</p>}

                   
                    <Select label="Status" options={[{name :"active"} , {name : "inactive"}]} {...register("status")}/>

                    <button type="submit">Submit</button>
                </form>
            </div>
        </Box>
    );
}

export default AddNewCropSeason;
