// import axios from 'axios';
// import React, { useState } from 'react'
// import DeleteIcon from '@mui/icons-material/Delete';
// import CreateSharpIcon from '@mui/icons-material/CreateSharp';
// import { useForm } from 'react-hook-form';
// import Input from './Input';
// import Select from './Select';

// function MastersTable({setTableData , master , headers = [] , data= []}) {
//   const [editId , setEditId] = useState(null) ;
//   const { register , handleSubmit } = useForm();

//   const editHandler = async(data)=>{
//     console.log(data , editId)
//     await axios.put(`http://localhost:8080/api/${master}/${editId}` , {date : Date.now() , ...data})
//     const response = await axios.get(`http://localhost:8080/api/masters/${master}`);
//     console.log(response.data);
//     setTableData(response.data);
//     setEditId(null)
//   }
//   const deleteHandler = async(e , id)=>{
//     e.preventDefault() ;
//     await axios.delete(`http://localhost:8080/api/${master}/${id}`)
//     const response = await axios.get(`http://localhost:8080/api/masters/${master}`);
//     console.log(response.data);
//     setTableData(response.data)

//   }
//   return (
//     <form onSubmit={handleSubmit(editHandler)} className='w-full overflow-auto '>
//    <table className='text-sm w-full text-nowrap  '>
//     <thead>
//         <tr>
//             {headers?.map((item,index) => <th>{item}</th>)}
//         </tr>
//     </thead>
//     <tbody>
//       { data.sort((item) => item.id).map((item,index)=><tr key={item.id}>
//         <td>{index}</td>
//         <td>{item.id}</td>
//         { ( editId != item.id) ? <>
//         <td>{item.name}</td>
//         <td>{item?.shortName || "-"}</td>
//         <td>{item?.nameLocal|| "-"}</td>
//         <td>{item?.feedBy || "Garima"}</td>
//         <td>{item?.date}</td>
//         <td className='capitalize'>{item?.status || "Inactive"}</td>
//         <td className=' border-none flex gap-3'>
//         <CreateSharpIcon onClick={(e)=> {setEditId(item.id)}} className='cursor-pointer' />

// <DeleteIcon className='text-red-500 cursor-pointer' onClick={(e)=>deleteHandler(e,item.id)} />
//         </td>
//         </> :
//         <>
//           <td><Input placeholder={item?.name || "Name"} defaultValue={item.name} {...register("name" , {required : true})}/></td>
//           <td><Input placeholder={item?.nameLocal || "Name Local"} defaultValue={item.nameLocal} {...register("nameLocal")}/></td>
//           <td><Input placeholder={item?.shortName || "Name Short"} defaulValue={item.shortName} {...register("shortName")}/></td>
//           <td><Input placeholder={item?.feedBy || "Feed By"} defaultValue={item.feedBy} {...register("feedBy")}/></td>
//           <td>{item?.date}</td>
//           <td className='capitalize'><Select value={item?.status} placeholder="Select" options = {[{name:"Active"} , {name : "Inactive"}]} {...register("status" ,{required: true})} /></td>
//           <td><button type="submit">Save</button></td>

//         </>
//         }

//       </tr>)}
//     </tbody>
//    </table>
//    </form>
//   )
// }

// export default MastersTable
import axios from "axios";
import React, { useState } from "react";
import DeleteIcon from "@mui/icons-material/Delete";
import CreateSharpIcon from "@mui/icons-material/CreateSharp";
import { useForm } from "react-hook-form";
import Input from "./Input";
import Select from "./Select";
import CheckCircleRoundedIcon from "@mui/icons-material/CheckCircleRounded";
import NorthEastIcon from "@mui/icons-material/NorthEast";
import CloseRoundedIcon from "@mui/icons-material/CloseRounded";
import { Box, Modal } from "@mui/material";
import { useDispatch } from "react-redux";
import { setData } from "../../redux/slices/masterSlice";
import Loader from "../modals/Loader";

function MastersTable({ setTableData, master, page ,  headers = [], data = [] , role }) {
  const [editId, setEditId] = useState(null);
  const [loading, setLoading] = useState(false);
  const [selectedData, setSelectedData] = useState(null);
  const dispatch = useDispatch() ; 
  const { register, handleSubmit, reset } = useForm();
  const [isOpen, setIsOpen] = useState(false);
  
  const [stateOptions , setStateOptions] = useState([]) ;
  // Edit Handler
  console.log(data)
  
  const editHandler = async(data) => {
    try {
      setLoading(true);
      const formData = {script: selectedData.script ,languageCode : selectedData?.languageCode , ...data}
      console.log("Editing record", formData, editId);

      // Send PUT request to update the record
      await axios.put(`http://localhost:8080/api/${master}/${editId}`, {
        date: new Date(Date.now()),
        ...formData,
      });
      
      // Fetch updated data
      const response = await axios.get(
        `http://localhost:8080/api/${master}`
      );
      dispatch(setData(response.data))
      setEditId(null);
      setSelectedData(null) ; 
      reset(); // Reset the form state
    } catch (error) {
      console.error("Error updating record:", error);
    } finally {
      setLoading(false);
    }
  };

  // Delete Handler
  const deleteHandler = async (e, id) => {
    e.preventDefault();
    try {
      setLoading(true);

      // Send DELETE request
      await axios.delete(`http://localhost:8080/api/${master}/${id}`);

      // Fetch updated data
      const response = await axios.get(
        `http://localhost:8080/api/${master}`
      );
      dispatch(setData(response.data))
    } catch (error) {
      console.error("Error deleting record:", error);
    } finally {
      setLoading(false);
    }
  };

  const fetchStates = async (e, id)=>{
    try{
      setLoading(true )
      setStateOptions([])
      const response = await axios.get(`http://localhost:8080/api/languages/${id}/states`);
      const options = response.data.map((state , index) => ({id: index , name : state}) );
      console.log(options) ; 
      setStateOptions(options) ;
    }catch(err){
      console.log(err) ; 
    }finally{
      setLoading(false) ; 
    }
  }

  return (
    <form onSubmit={handleSubmit(editHandler)} className="w-full overflow-auto">
      <table className="text-sm w-full text-nowrap">
        <thead>
          <tr>
            {headers.map((header, index) => (
              <th key={index}>{header}</th>
            ))}
          </tr>
        </thead>
        <tbody>
          {data // Avoid mutating original data
            .map((item, index) => (
              <tr key={item.id}>
                <td>{(page-1)*10+(index + 1)}</td>
                <td>{item.languageCode}</td>
                {editId !== item.id ? (
                  <>
                    <td>{item?.languageName}</td>
                    <td>{item?.shortName || "-"}</td>
                    <td className="w-[300px]">
                      {
                        <Select
                          className="w-full  "
                          placeholder="States"
                          onClick = {(e)=>fetchStates(e , item.id)}
                          options={stateOptions}
                          
                          // disabled={true}
                        />
                      }
                    </td>
                    <td>{item.status || "Inactive"}</td>
                    {/* <td>{item?.date || '-'}</td>
                    <td className='capitalize'>{item.status || 'Inactive'}</td> */}
                    <td className="flex justify-center gap-3 border-none">
                     {( role == "ROLE_ADMIN" || role=="ROLE_EDITOR") && <CreateSharpIcon
                        onClick={() => {
                          reset();
                          setSelectedData(item) ;
                          setEditId(item.id);
                        }}
                        className="cursor-pointer"
                      />}
                   {(role == "ROLE_ADMIN" ) &&   <DeleteIcon
                        className="text-red-500 cursor-pointer"
                        onClick={(e) => deleteHandler(e, item.id)}
                      />}
                      <NorthEastIcon
                        onClick={() => {
                          setSelectedData(item);
                          setIsOpen(true);
                        }}
                      />
                    </td>
                  </>
                ) : (
                  <>
                    <td>
                      <Input
                        placeholder={item?.name || "Name"}
                        defaultValue={item?.languageName}
                        {...register("languageName", { required: true })}
                      />
                    </td>
                    
                    <td>
                      <Input
                        placeholder={item?.shortName || "Short Name"}
                        defaultValue={item?.shortName}
                        {...register("shortName")}
                      />
                    </td>
                    <td className="w-fit">
                      {
                        <Select
                          className="max-w-[300px] w-fit"
                          placeholder="States"
                          options={item?.states}
                          
                          // disabled={true}
                        />
                      }</td>
                    <td><Select placeholder="Status" options={[{name : "Active"} , {name : "Inactive"}]} {...register("status")}/></td>
                    <td className="border-none flex gap-4 justify-center items-center mt-2 h-full ">
                      <>
                        <button
                          className=" !text-black !p-0 !m-0 !bg-transparent"
                          disabled={loading}
                          type="submit"
                        >
                          {loading ? (
                            "Saving..."
                          ) : (
                            <CheckCircleRoundedIcon
                              type="submit"
                              disabled={loading}
                            />
                          )}
                        </button>
                        <CloseRoundedIcon
                          className="cursor-pointer"
                          onClick={() => {
                            reset();
                            setEditId(null);
                          }}
                        />
                      </>
                    </td>
                  </>
                )}
              </tr>
            ))}
        </tbody>
      </table>

      {isOpen && (
        <Modal
          open={isOpen}
          onClose={() => setIsOpen(false)}
          aria-labelledby="modal-title"
          aria-describedby="modal-description"
        
        >
          <Box
            sx={{
              position: "absolute",
              top: "50%",
              left: "50%",
              transform: "translate(-50%, -50%)",
              // bgcolor: 'black',
              boxShadow: 24,
              // borderRadius : "20px" ,
            }}
          >
            <div className="bg-white max-h-[80vh] overflow-auto  min-w-[400px] md:min-w-[60vw]  md:min-h-[60vh] flex flex-col gap-5 bg-[whitesmoke] rounded-md p-4 flex flex-col gap-2 w-full max-w-lg">
              <h1>Language Details</h1>
              <hr></hr>
              <div className="grid grid-cols-[40%_60%]">
                <p className="font-bold">Language</p>
                <p>{selectedData?.languageName}</p>
              </div>
              <div className="grid grid-cols-[40%_60%]">
                <p className="font-bold">Language Code</p>
                <p>{selectedData?.languageCode}</p>
              </div>
              <div className="grid grid-cols-[40%_60%]">
                <p className="font-bold">Language Short Name</p>
                <p>{selectedData?.shortName}</p>
              </div>
              <div className="grid grid-cols-[40%_60%]">
                <p className="font-bold">States</p>
                <p className="flex gap-2 flex-wrap ">{selectedData?.states?.map(item => <p>{item.stateName}</p>)}</p>
              </div>
              <div className="grid grid-cols-[40%_60%]">
                <p className="font-bold">Remarks</p>
                <p>{selectedData?.remarks}</p>
              </div>
              <div className="grid grid-cols-[40%_60%]">
                <p className="font-bold">Scrip/Writing system</p>
                <p>{selectedData?.script}</p>
              </div>

            </div>
          </Box>
        </Modal>
      )}
      {/* {loading && (<Modal
          open={loading}
          onClose={() => setIsOpen(setLoading)}
          aria-labelledby="modal-title"
          aria-describedby="modal-description"
        
        >
          <Loader />
        </Modal>)} */}
    </form>
  );
}

export default MastersTable;
