import React, { useEffect, useState } from "react";
import Input from "../common/Input";
import { useForm } from "react-hook-form";
import { Box } from "@mui/material";
import axios from "axios";
import { useDispatch } from "react-redux";
import { setData } from "../../redux/slices/masterSlice";
import Select from "../common/Select";
import { useFetchOptions } from "../../hook/useFetchOption";

function AddNewCommodityMaster({ master, setOpen }) {
  const dispatch = useDispatch();

  const {
    register,
    watch,
    handleSubmit,
    reset,
    formState: { errors },
  } = useForm({
    mode: "onBlur",
  });

  const [commodityFormOp, setCommodityFormOp] = useState([]);
  const [languageOptions, setLanguageOptions] = useState([]);
  const [stateId, setStateId] = useState(null);
  const [languageId, setLanguageId] = useState(null);
  const { options: commodityFormOptions } = useFetchOptions(
    "/api/commodity-forms/names"
  );
  const { options: commodityGroupOptions } = useFetchOptions(
    "/api/commodity-group/names"
  );
  const {options : cropSeasonOptions} = useFetchOptions("/api/cropseasons/names") ; 
  const {options : measurementUnitOptions} = useFetchOptions("/api/measurement-units/names") ; 
  const {options : colorOptions} = useFetchOptions("/api/colors/names") ; 

  //     useEffect(()=>{
  //         const getLanguages =  async()=>{
  //          const state = stateOptions.filter(state => state.stateName == watch("stateName")) ;
  //          try{
  //            setStateId(state[0].id) ;
  //          const response = await axios.get(` http://localhost:8080/api/measurement-units/languages/${state[0].id}`)
  //          setLanguageOptions(response.data) ;
  //         console.log(response.data)

  //  }catch(err){
  //    console.log(err) ;
  //    setLanguageOptions([])
  //  }
  //        }

  //        if(watch("stateName")){
  //          getLanguages() ;
  //        }

  //      } , [watch("stateName")])

  //      useEffect(()=>{

  //         if(watch("languageName")){
  //             const language = languageOptions.filter((item) => item.languageName == watch("languageName") )
  //             if(language.length > 0 ){
  //                 console.log(language)
  //                 setLanguageId(language[0].id) ;
  //             }
  //           }

  //      } , [watch("languageName")])
  const submitHandler = async (data) => {
    try {
      const measurementUnitIndex = measurementUnitOptions.indexOf(m => m.measurementUnitName == data.measurmentUnit) ; 
      console.log(measurementUnitOptions[measurementUnitIndex]) ; 
      const formObj = {
        ...data,
        document : null , 
        moduleMaster: {id : 1 }, 
        feedDate: new Date(Date.now()),
       
      };
      console.log(formObj);

      // POST request to add new commodity group
    //   await axios.post(
    //     `http://localhost:8080/api/commodity-group/add`,
    //     formObj
    //   );

    //   // Fetch updated data
    //   const response = await axios.get(
    //     `http://localhost:8080/api/commodity-group`
    //   );

    //   // Update Redux state
    //   dispatch(setData(response.data));

    //   // Reset the form
    //   reset();

    //   // Close the modal
    //   setOpen(false);
    } catch (error) {
      console.error("Error during form submission:", error);
      alert("There was an error submitting the form.");
    }
  };

  return (
    <Box
      sx={{
        position: "absolute",
        width: "80vw",
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
          <div className="grid md:grid-cols-2 gap-9">
            <Select
              label="Commodity Form"
              k="commodityFormName"
              options={commodityFormOptions}
              placeholder="Select"
              {...register("commodityFormName")}
            />
            <Input
              label="Commodity Name"
              {...register("commodityName", {
                required: "Group Name is required",
              })}
            />
            {errors.groupName && <p>{errors.groupName.message}</p>}
          </div>

          <div className="grid md:grid-cols-2 gap-9">
            <Input
              label="Commodity  Name In Local Language"
              {...register("commodityLocalName", {
                required: "Local Name is required",
              })}
            />

            <Input
              label="Commodity Group Short Name"
              {...register("commodityShortName", {
                required: "Short Name is required",
              })}
            />
          </div>
            
            <div className="grid md:grid-cols-2 gap-9">
          <Input
            type="checkbox"
            className="w-fit "
            label="Is Under Major Commodity"
            {...register("isMajor", {
              required: "Short Name is required",
            })}
          />

          <Select
            options={commodityGroupOptions}
            label="Commodity Group"
            k="groupName"
            placeholder="Select"
            {...register("commodityGroup")}
          />
          </div>

            <Select options={cropSeasonOptions} label="Crop Season" k="cropSeasonName" {...register("cropSeason")}/>
            <Select options={measurementUnitOptions} k="measurementUnitName" label="Measurement Unit" {...register("measurmentUnit")}/>
            <Select options={colorOptions} k="colorName" label="Color" {...register("color")}/>


          <Input
            label="Feed By"
            {...register("feedBy", { required: "Feed By is required" })}
          />
    
          <Input label="Remarks" {...register("remarks")} />
          <Select
            label="Status"
            options={[{ name: "active" }, { name: "inactive" }]}
            {...register("status")}
          />

          <button type="submit">Submit</button>
        </form>
      </div>
    </Box>
  );
}

export default AddNewCommodityMaster;
