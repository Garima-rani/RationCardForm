import React, { useState } from 'react';
import useAuth from '../hook/useAuth'; // Ensure this path is correct
import Select from "./common/Select"
import MastersTable from './common/MastersTable';
import { useSelector } from 'react-redux';
import axios from 'axios';
import { Modal } from '@mui/material';
import AddNewMaster from './modals/AddNewMaster';
const masters =[
  {id:1 , name : "occupations"} ,
  {id:2 , name : "schemes"} ,
  {id:3 , name : "genders"} ,
  {id : 4 , name : "states"},
  {id:5 , name : "beneficiary-types"},
  {id:6 , name : "marital-statuses"},
  {id:7 , name : "nationalities"}

]

const headers = ["Sl.No. " , " Group Code" , "Group Name" , "Group Name Local" , "Group Short Name" , "Feed By" , "Feed Date" , "Status" , "Action"]
const MasterData = () => {
  const  {token} = useSelector(state=>state.auth)
  const [masterName , setMasterName] = useState(null)
  const [addNew , setAddNew] = useState(false);
  const [tableData , setTableData] =useState([])
  const changeHandler = async(e)=>{
    const response = await axios.get(`http://localhost:8080/api/masters/${e.target.value}`);
    console.log(response.data);
    setTableData(response.data)
    setMasterName(e.target.value) ; 
  }

  if (!token) {
    return null; // Or a loading spinner
  }

  return (
    <div className="flex justify-center overflow-hidden min-h-screen bg-gray-100">
      <div className="w-full bg-white rounded-lg shadow-lg p-6 flex flex-col gap-5 m-5">
        <h1 className=" text-center text-3xl font-semibold text-gray-800">Master Data</h1>
        {/* Add content here for master data */}
        <div className='flex justify-beetween items-center gap-10'>
        <Select label="Search By Name" options={masters} className="max-w-2xl" onChange={changeHandler} />

         {masterName && <button className='text-nowrap !h-fit' onClick={(e)=>{e.preventDefault(); setAddNew(true)}} > Add New</button>}
        </div>


        <MastersTable setTableData={setTableData} master={masterName} headers={headers} data={tableData} />
      </div>

      <Modal open={addNew}
        onClose={()=> setAddNew(false)}
        aria-labelledby="modal-title"
        aria-describedby="modal-description">

          <AddNewMaster  master={masterName} setOpen ={setAddNew} setTableData={setTableData}/>
        </Modal>
    </div>
  );
};

export default MasterData;
