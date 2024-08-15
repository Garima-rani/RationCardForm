import React, { useState } from 'react'
import Button from '../common/Button'
import {useForm , useFieldArray} from "react-hook-form"
import {Modal} from "@mui/material"
import AddForm from './AddForm';
function Form4({methods}) {
    const { control, handleSubmit, register, reset, getValues, setValue  } = methods ; 

      const { fields, append } = useFieldArray({
        control,
        name: 'members'
      });
      
      const [isModalOpen, setModalOpen] = useState(false);    
      const onSubmit = (data) => {
        console.log('Form data:', data);
      };

      const openModal = () =>{console.log("opening"); setModalOpen(true);}
      const closeModal = () => setModalOpen(false);
      
      const addMember = async(data) => {
        
        console.log(data)
        append(data);
        closeModal();
      };
      
  return (
    <div className='w-full h-full bg-transparent   grid  gap-10 px-5'>
    <form>

    <section className='card'>
        <div className='flex justify-between'>
        <h2>Ration Card Memeber(s) Details</h2>
        <button className='bg-gray-300 px-5 rounded-[3px]' type="button" onClick={openModal}>Add Member</button>


        

        </div>
        <div className='flex flex-col gap-5 mt-10 '>
        {fields.map((field, index) => (
          <div key={field.id} className="flex justify-between">
            <h3>{getValues(`members[${index}].personalDetails.name`)}</h3>
                
            {/* Add more fields as needed */}
          </div>
        ))}
        </div>
    </section>
      
    </form>

    <Modal open={isModalOpen} onClose={closeModal}>
        <div className="modal-content">
          <h2>Add New Member</h2>
          <AddForm addMember={addMember} methods={methods} onClose={closeModal}/>
        </div>
      </Modal>
    </div>
  )
}

export default Form4
