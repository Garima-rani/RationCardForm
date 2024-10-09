import React, { useEffect, useState } from "react";
import Input from "../common/Input";
import { useForm } from "react-hook-form";
import { Box } from "@mui/material";
import axios from "axios";
import { useDispatch } from "react-redux";
import { setData } from "../../redux/slices/masterSlice";
import Select from "../common/Select";
import { useFetchOptions } from "../../hook/useFetchOption";

function AddNewMeasurementUnit({ master, setOpen }) {
    const dispatch = useDispatch();
    const [languageOptions , setLanguageOptions] = useState([]) ; 
    const {options: commodityFormOption } = useFetchOptions("/api/measurement-units/commodity-forms") ;
    const {options: stateOptions } = useFetchOptions("/api/measurement-units/states") ;
   
    
    const { register, handleSubmit, watch , reset, formState: { errors } } = useForm({
        mode: "onBlur",
    });


    useEffect(()=>{
       const getLanguages =  async()=>{
        const state = stateOptions.filter(state => state.stateName == watch("stateName")) ;
        try{
          console.log(state) ; 
        const response = await axios.get(` http://localhost:8080/api/measurement-units/languages/${state[0].id}`)
        setLanguageOptions(response.data) ;
        
}catch(err){
  console.log(err) ; 
  setLanguageOptions([])
}
      }
       
      if(watch("stateName")){
        getLanguages() ; 
      }
       
    } , [watch("stateName")])

    const submitHandler = async (data) => {
        try {
            const formObj = {
                measurementUnitName: data.measurementUnitName,
                measurementUnitShortName: data.measurementUnitShortName,
                measurementUnitLocalName: data.measurementUnitLocalName,
                decimalPrecision: data.decimalPrecision,
                status: data.status , 
                feedBy: data.feedBy,
                remarks: data.remarks || "",
                feedDate : new Date(Date.now())
            };

            // POST request to add new commodity group
            await axios.post(`http://localhost:8080/api/commodity-group/add`, formObj);

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
                 <Select label="Commodity Form Name" options={commodityFormOption} {...register("commodityFormName" , {required : "Commodity Form Name"})}/>
                    <Input
                        label="Measurement Unit Name"
                        {...register("measurementUnitName", { required: "Unit Name is required" })}
                    />
                    {errors.measurementUnitName && <p>{errors.measurementUnitName.message}</p>}

                    <Input
                        label="Measurement Unit Short Name"
                        {...register("measurementUnitShortName", { required: "Short Name is required" })}
                    />
                    {errors.measurementUnitShortName && <p>{errors.measurementUnitShortName.message}</p>}
 
                  
                    <Select options= {stateOptions} label="Select State Name " onChange={(e) => console.log(e.target.value)}  {...register("stateName" , {required : "Commodity Form Name"})} />
                    <Select label="Language" options={languageOptions} {...register("languageName")}/>

                    <Input
                        label="Measurement Unit Name In Local Language"
                        {...register("measurementUnitLocalName", { required: "Name in Local Language is required" })}
                    />
                    {errors.measurementUnitLocalName && <p>{errors.measurementUnitLocalName.message}</p>}

                    <Input
                        label="Feed By"
                        {...register("feedBy", { required: "Feed By is required" })}
                    />
                    {errors.feedBy && <p>{errors.feedBy.message}</p>}

                    <Input label="Remarks" {...register("remarks")} />
                    <Select label="Status" onChange={(e) => console.log(e.target.value)} options={[{name :"active"} , {name : "inactive"}]} {...register("status")}/>
                    <Select label="Decimal Precision" onChange={(e) => console.log(e.target.value)} options={[{name :"Zero(0)"} , {name : "One(1)"} , {name :"Two(2)"} , {name :"Three(3)"} , {name :"Four(4)"} , {name :"Five(5)"} , {name :"Six(6)"}]} {...register("decimalPrecision")}/>
                    
                    <button type="submit">Submit</button>
                </form>
            </div>
        </Box>
    );
}

export default AddNewMeasurementUnit;
