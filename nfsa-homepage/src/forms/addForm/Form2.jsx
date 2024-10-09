import React, { useEffect } from 'react';
import Select from '../../components/common/Select';
import Input from '../../components/common/Input';
import { useWatch } from 'react-hook-form';

const states = ["Punjab"];
const districts = ["Barnala"];
const tahsil = ["Punjab"];
const towns = ["Baluchi"];

function Form2({ methods }) {
  const { register, formState: { errors }, watch, getValues, setValue, control, trigger } = methods;
  const isSame = watch('isSame');
  const presentAddress = useWatch({ control, name: 'presentAddress' }) || {};

  useEffect(() => {
    if (isSame) {
      Object.keys(presentAddress).forEach(key => {
        // Only set the value if it's different and not empty
        if (presentAddress[key] && presentAddress[key] !== getValues(`permanentAddress.${key}`)) {
          setValue(`permanentAddress.${key}`, presentAddress[key]);
        }
      });
    }
  }, [presentAddress, isSame, getValues, setValue]);

  

  const commonInputProps = {
    onChange: () => trigger(), // Trigger validation onChange for real-time feedback
    onBlur: () => trigger() // Trigger validation onBlur for immediate feedback
  };

  return (
    <div className="h-full bg-transparent grid lg:grid-cols-2 gap-10 px-5">
      <section className='card'>
        <h2>Present Address</h2>
        <Select
          options={states}
          label="Present State"
          errors ={errors?.presentAddress?.state}

          {...register("presentAddress.state", { required: "State is required",
            onChange : ()=>trigger("presentAddress.state") ,

           })}
        />
     
        <Select
          options={districts}
          errors ={errors?.presentAddress?.district}

          label="Present District"
          {...register("presentAddress.district", { required: "District is required" ,
            onChange : ()=>trigger("presentAddress.district") ,
          })}
        />
        
        <Select
          options={tahsil}
          label="Present Tahsil"
          errors ={errors?.presentAddress?.tahsil}

          {...register("presentAddress.tahsil", { required: "Tahsil is required",
            onChange : ()=>trigger("presentAddress.tahsil") ,
           })}
        />
        
        <Select
          options={towns}
          label="Present Village or Town"
          errors ={errors?.presentAddress?.town}

          {...register("presentAddress.town", { required: "Town is required",
            onChange : ()=>trigger("presentAddress.town") ,
           })}
        />
       
        <Input
          label="Present Address (House No./House Name, etc.)"
          errors ={errors?.presentAddress?.address}

          {...register("presentAddress.address", { required: "Address is required",
            onChange : ()=>trigger("presentAddress.address") ,

            minLength: {
              value: 10,
              message: "Address must be at least 10 characters long"
            },
            maxLength: {
              value: 100,
              message: "Address must be less than 100 characters long"
            }

           })}
        />
   
        <Input
          {...commonInputProps}
          errors ={errors?.presentAddress?.landmark}

          label="Present Landmark or Locality"
          {...register("presentAddress.landmark", { 
            required: "Landmark is required", 
            onChange : ()=>trigger("presentAddress.landmark") ,
           
          })}
        
        />
       
        <Input
          label="PIN No."
          {...commonInputProps}
          errors ={errors?.presentAddress?.pin}
          {...register("presentAddress.pin", { 
            required: "PIN is required", 
            onChange : ()=>trigger("presentAddress.pin") ,
          
          })}
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
              Yes, My permanent address is the same as present address.
            </label>
          </div>
        </div>

        <Select
          label="Permanent State"
          errors={errors?.permanentAddress?.state}
          disabled={isSame}
          options={states}
          {...register("permanentAddress.state", { required: "State is required",
            onChange : ()=>trigger("permanentAddress.state") ,
           })}
        />
        
        <Select
          label="Permanent District"
          errors={errors?.permanentAddress?.district}
          disabled={isSame}
          options={districts}
          {...register("permanentAddress.district", { required: "District is required",
            onChange : ()=>trigger("permanentAddress.district") ,
           })}
        />
        
        <Select
          label="Permanent Tahsil"
          errors={errors?.permanentAddress?.tahsil}
          disabled={isSame}
          options={tahsil}
          {...register("permanentAddress.tahsil", { required: "Tahsil is required",
            onChange : ()=>trigger("permanentAddress.tahsil") ,
           })}
        />
        
        <Select
          label="Permanent Village or Town"
          errors={errors?.permanentAddress?.town}
          disabled={isSame}
          options={towns}
          {...register("permanentAddress.town", { required: "Town is required" ,
            onChange : ()=>trigger("permanentAddress.town") ,
           })}
        />
        
        <Input
          label="Permanent Address (House No./House Name, etc.)"
          errors={errors?.permanentAddress?.address}
          disabled={isSame}
          {...register("permanentAddress.address", { required: "Address is required",
            onChange : ()=>trigger("permanentAddress.address") ,
           })}
        />
        
        <Input
          {...commonInputProps}
          errors= {errors?.permanentAddress?.landmark }
          label="Landmark or Locality"
          disabled={isSame}
          {...register("permanentAddress.landmark", { 
            required: "Landmark is required", 
            onChange : ()=>trigger("permanentAddress.landmark") ,
            
          })}
        />
        
        <Input
          {...commonInputProps}

          label="PIN No."
          errors={errors?.permanentAddress?.pin }
          disabled={isSame}
          {...register("permanentAddress.pin", { 
            required: "PIN is required", 
            onChange : ()=>trigger("permanentAddress.pin") ,
           
          })}
        />
        
      </section>
    </div>
  );
}

export default Form2;
