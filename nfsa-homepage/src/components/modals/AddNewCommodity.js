import React, { useEffect, useState } from "react";
import Input from "../common/Input";
import { useForm } from "react-hook-form";
import { Box } from "@mui/material";
import axios from "axios";
import { useDispatch } from "react-redux";
import { setData } from "../../redux/slices/masterSlice";
import Select from "../common/Select";
import { useFetchOptions } from "../../hook/useFetchOption";

function AddNewCommodity({ master, setOpen }) {
    const dispatch = useDispatch();
    
    const { register,watch ,  handleSubmit, reset, formState: { errors } } = useForm({
        mode: "onBlur",
    });

    const [languageOptions , setLanguageOptions] = useState([]) ; 
    const [stateId , setStateId] = useState(null) ; 
    const [languageId , setLanguageId] = useState(null )
    const {options: stateOptions } = useFetchOptions("/api/measurement-units/states") ;
    useEffect(()=>{
        const getLanguages =  async()=>{
         const state = stateOptions.filter(state => state.stateName == watch("stateName")) ;
         try{
           setStateId(state[0].id) ; 
         const response = await axios.get(` http://localhost:8080/api/measurement-units/languages/${state[0].id}`)
         setLanguageOptions(response.data) ;
        console.log(response.data)
         
 }catch(err){
   console.log(err) ; 
   setLanguageOptions([])
 }
       }
        
       if(watch("stateName")){
         getLanguages() ; 
       }
        
     } , [watch("stateName")])

     useEffect(()=>{
        
 
        if(watch("languageName")){
            const language = languageOptions.filter((item) => item.languageName == watch("languageName") )
            if(language.length > 0 ){
                console.log(language)
                setLanguageId(language[0].id) ; 
            }
          }
        
      
        
     } , [watch("languageName")])
    const submitHandler = async (data) => {
        try {
            console.log(data) ; 
            const formObj = {
                ...data ,       
                groupName: data.groupName,
                nameLocal: data.nameLocal,
                shortName: data.shortName,
                groupCode: data.groupCode,
                status: data.status , 
                feedBy: data.feedBy,
                remarks: data.remarks || "",
                feedDate : new Date(Date.now()) ,
                state : {id : stateId} ,
                language : {id : languageId} 
                
            };
            console.log(formObj)

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
                    <Input
                        label="Commodity Group Name"
                        {...register("groupName", { required: "Group Name is required" })}
                    />
                    {errors.groupName && <p>{errors.groupName.message}</p>}

                    <Input
                        label="Commodity Group Name In Local Language"
                        {...register("nameLocal", { required: "Local Name is required" })}
                    />
                    {errors.nameLocal && <p>{errors.nameLocal.message}</p>}

                    <Input
                        label="Commodity Group Short Name"
                        {...register("shortName", { required: "Short Name is required" })}
                    />
                    {errors.shortName && <p>{errors.shortName.message}</p>}

                    <Input
                        label="Commodity Group Code"
                        {...register("groupCode", { required: "Group Code is required" })}
                    />
                    {errors.groupCode && <p>{errors.groupCode.message}</p>}

                    <Input
                        label="Feed By"
                        {...register("feedBy", { required: "Feed By is required" })}
                    />
                    {errors.feedBy && <p>{errors.feedBy.message}</p>}
                    <Select options= {stateOptions} label="Select State Name "  {...register("stateName" , {required : "Commodity Form Name"})} />
                    <Select label="Language" options={languageOptions} {...register("languageName")}/>
                    <Input label="Remarks" {...register("remarks")} />
                    <Select label="Status" options={[{name :"active"} , {name : "inactive"}]} {...register("status")}/>

                    <button type="submit">Submit</button>
                </form>
            </div>
        </Box>
    );
}

export default AddNewCommodity;
