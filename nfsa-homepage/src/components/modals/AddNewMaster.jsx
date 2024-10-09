import React from "react";
import Input from "../common/Input";
import { useForm } from "react-hook-form";
import { Box } from "@mui/material";
import axios from "axios";
import Select from "../common/Select";

function AddNewMaster({ master , setOpen  , setTableData}) {
    const {register , handleSubmit} = useForm()
    const submitHandler =async(data)=>{
        try{
           await axios.post(`http://localhost:8080/api/${master}` , {date: new Date() ,  ...data})
          const response = await axios.get(`http://localhost:8080/api/masters/${master}`);
          console.log(response.data);
          setTableData(response.data)
          setOpen(false);
        
        }catch(error){
                    console.log(error)
        }
    }
  return (
    <Box
    sx={{
      position: 'absolute',
      top: '50%',
      left: '50%',
      transform: 'translate(-50%, -50%)',
      
      bgcolor: 'gray',
      boxShadow: 24,
      // borderRadius : "20px" , 
      
    }}
  >
    <div className="bg-[whitesmoke] w-full p-5 flex flex-col gap-10 rounded-md ">
      <h1 className="capitalize">Add {master}</h1>
      <form onSubmit={handleSubmit(submitHandler)} className="border  border-black min-w-[500px] card flex flex-col gap-4">
      {/* <Input label="Master Id" placeholder="10000" required={true} {...register("id" , {required:"ID is required"})} /> */}
      <Input label="Master Name" placeholder="MasterEntry" required={true} {...register("name" , {required:"Name is required"})} />
      <Input label="Local Name" placeholder="Local Name" required={true} {...register("nameLocal" , {required:"Name is required"})} />
      <Input label="Short Name" placeholder="Short Name" required={true} {...register("shortName" , {required:"Name is required"})} />
      <Input label="Feed By" placeholder="Garima Rani" required={true} {...register("feedBy" , {required:"Name is required"})} />
      <Select options={[{name : "Active"} , {name : "Inactive"}]} label="Is Active" placeholder="Select" required={true} {...register("status" , {required:"Name is required"})} />
        <button className="" type="submit">Submit</button>
      </form>
    </div>
    </Box>
  );
}

export default AddNewMaster;
