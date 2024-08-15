import React, { useEffect } from 'react';
import Select from '../common/Select';
import Input from '../common/Input';
import {  useWatch  } from 'react-hook-form';


const states= ["Punjab"]
const districts = ["Barnala"]
const tahsil=["Punjab"]
const towns= ["Baluchi"]

function Form2({methods}) {
  const { register, handleSubmit, formState: { errors }, watch  , getValues , setValue ,control  } =methods;
  const isSame =watch('isSame');
  const presentAddress =useWatch({ control , name: 'presentAddress' });
  useEffect(()=>{
    
    
        // Set permanent address to be the same as present address
        if (isSame) {
            Object.keys(presentAddress).forEach(key => {
              if (presentAddress[key] && presentAddress[key] !== getValues(`permanentAddress.${key}`)) {
                setValue(`permanentAddress.${key}`, presentAddress[key]);
              }
            });
          }
      
    
  } , [presentAddress , isSame ])
  
  // Common configuration for Select and Input components
  const commonProps = {
    required: true,
    
  };


 

  // Function to determine registration name based on address match

  return (


    <div className=" h-full bg-transparent  grid lg:grid-cols-2 gap-10 px-5 ">
      <section className='card'>
        <h2>Present Address</h2>
        <Select 
            options={states}
          label="Present State" 
          {...commonProps}
          errors={errors?.presentAddress?.state}
          {...register("presentAddress.state", { required: "State is required" })} 
        />

        <Select 
        options={districts}
        errors={errors?.presentAddress?.district}

          label="Present District" 
          {...commonProps}
          {...register("presentAddress.district", { required: "District is required" })} 
        />

        <Select 
          errors={errors?.presentAddress?.tahsil}

        options={tahsil}
          label="Present Tahsil" 
          {...commonProps}
          {...register("presentAddress.tahsil", { required: "Tahsil is required" })} 
        />
        
        <Select 
        options={towns}
        errors={errors?.presentAddress?.town}

          label="Present Village or Town" 
          {...commonProps}
          {...register("presentAddress.town", { required: "Town is required" })} 
        />
        <Input 
          label="Present Address (House No./House Name, etc.)" 
          errors={errors?.presentAddress?.address}

          {...commonProps}
          {...register("presentAddress.address", { required: "Address is required" })} 
        />
        <Input 
          label="Present Landmark or Locality" 
          {...commonProps}
          errors={errors?.presentAddress?.landmark}

          {...register("presentAddress.landmark", { required: "Landmark is required" })} 
        />
        <Input 
          label="PIN No."           errors={errors?.presentAddress?.pin}

          {...commonProps}
          {...register("presentAddress.pin", { required: "PIN is required" })} 
        />
      </section>

      <section className='card'>
        <div className='grid grid-cols-[30%_70%]'>
          <h2>Permanent Address</h2>
          <div className='flex gap-2 items-start'>
            <Input 
              type="checkbox" 
              className="!w-fit mt-2" 
              id="isSame" 
              {...register("isSame")} 
            />
            <label 
              htmlFor="isSame" 
              className='!w-fit mt-1 text-sm font-bold'
            >
              Yes, My permanent Address is same as presentAddress. address
            </label>
          </div>
        </div>

        <Select 
          label="Permanent State" 
          required ="true"
          errors={errors?.permanentAddress?.state}

          disabled={isSame} 
          options={states}
          {...register("permanentAddress.state" , {required : "Permanent Address Is required"})} 
        />
        
        <Select 
          label="Permanent District" 
          required ="true"
          errors={errors?.permanentAddress?.district}

          options={districts}
          disabled={isSame} 
          {...register("permanentAddress.district", {required : "District is requried"})} 
        />

<Select 
          label="Permanent Tahsil" 
          required ="true"
          errors={errors?.permanentAddress?.tahsil}
          options={tahsil}
          disabled={isSame} 
          {...register("permanentAddress.tahsil" , {required : "Tahsil is required"})} 
        />
        <Select 
          errors={errors?.permanentAddress?.town}
          label="Permanent Village or Town" 
          required = "true"
          options={towns}
          disabled={isSame} 
          {...register("permanentAddress.town")} 
        />
        <Input 
          label="Permanent Address (House No./House Name, etc.)" 
          errors={errors?.permanentAddress?.address}
          required 
          disabled={isSame} 
          {...register("permanentAddress.address")} 
        />
        <Input 
          label="Landmark or Locality" 
          errors={errors?.permanentAddress?.landmark}
          required 
          disabled={isSame} 
          {...register("permanentAddress.landmark")} 
        />
        <Input 
          errors={errors?.permanentAddress?.pin}

          label="PIN No." 
          required 
          disabled={isSame} 
          {...register("permanentAddress.pin")} 
        />
      </section>
      
    {/* <Button type="submit" className='lg:col-span-2  justify-self-end'>Save and Continue</Button> */}

    </div>
 
  );
}

export default Form2;
