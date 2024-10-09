import React, { useState, useEffect } from 'react';
import { useForm } from 'react-hook-form';
import Input from '../../components/common/Input';
import Select from '../../components/common/Select';
import Button from "../../components/common/Button"
import { handleImageChange } from '../../utils/handleImageChange';
import axios from 'axios';

// Dynamic data fetch hooks
const useFetchOptions = (endpoint) => {
  const [options, setOptions] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const fetchOptions = async () => {
      try {
        const response = await axios.get(endpoint);
        setOptions(response.data);
      } catch (error) {
        console.error("Error fetching options:", error);
      } finally {
        setLoading(false);
      }
    };

    fetchOptions();
  }, [endpoint]);
  return { options : [" "] , loading:false  };
};

function AddForm({ addMember, setLoading, onClose }) {
  const methods = useForm() ;
  const { handleSubmit, register, formState: { errors }, watch } = methods;
  
  // Fetch options dynamically
  const { options: states } = useFetchOptions('/api/options/states');
  const { options: schemes } = useFetchOptions('/api/options/schemes');
  const { options: beneficiaryType } = useFetchOptions('/api/options/beneficiaryType');
  const { options: genders } = useFetchOptions('/api/options/genders');
  const { options: maritalStatuses } = useFetchOptions('/api/options/maritalStatuses');
  const { options: nationalities } = useFetchOptions('/api/options/nationalities');
  const { options: occupations } = useFetchOptions('/api/options/occupations');

  return (
    <form
      className="h-[90vh] bg-transparent flex flex-col gap-y-10 m-5 card !bg-[lightgray] !p-10 overflow-auto lg:max-w-[1000px] mx-auto"
    >
      <h2>Add Member</h2>
      <div className="grid lg:grid-cols-2 gap-10">
        {/* Applicant's Personal Details */}
        <section className="card h-fit">
          <h2>Applicant's Personal Details</h2>

          <div className="w-full grid lg:grid-cols-2 gap-10 mt-8">
            <div className="w-full flex justify-center">
              <div className="text-center">
                <Input
                  type="file"
                  errors={errors?.personalDetails?.profilePicture}
                  $id="pic"
                  className="h-[200px] w-[200px]"
                  onChange={(e) => handleImageChange(e, methods, "personalDetails.profilePicture", setLoading)}
                />
                <label className="text-sm text-blue-700 cursor-pointer" htmlFor="pic">
                  Change/Upload Photo
                </label>
              </div>
            </div>
            <div className="flex flex-col gap-4">
              <Input
                required="true"
                errors={errors?.personalDetails?.name}
                label="Name (Preferably as in Aadhar)"
                placeholder="Name (Preferably as in Aadhar)"
                {...register("personalDetails.name", {
                  required: "Name (Preferably as in Aadhar) required",
                  pattern: {
                    value: /^[A-Za-z\s]+$/,
                    message: "Name must contain only alphabets and spaces"
                  }
                })}
              />
              <Input
                label="Name in Local Language (Preferably as in Aadhar)"
                placeholder="Name in Local Language (Preferably as in Aadhar)"
                {...register("personalDetails.localName")}
              />
              <Select
                errors={errors?.personalDetails?.gender}
                options={genders}
                label="Gender"
                required="true"
                {...register("personalDetails.gender", { required: "Gender required" })}
              />
              <div className="grid grid-cols-2 gap-x-2">
                <Input
                  errors={errors?.personalDetails?.dob}
                  label="Date of Birth"
                  type="date"
                  required="true"
                  {...register("personalDetails.dob", { required: "Date of Birth required" })}
                />
                <Input placeholder="0" disabled className="mt-7" />
              </div>
            </div>
          </div>

          <div className="grid lg:grid-cols-2 gap-x-10 gap-y-4 my-4">
            <Input
              errors={errors?.personalDetails?.motherName}
              required="true"
              label="Mother's Name (In English)"
              placeholder="Mother's Name (In English)"
              {...register("personalDetails.motherName", {
                required: "Mother's Name (In English) required",
                pattern: {
                  value: /^[A-Za-z\s]+$/,
                  message: "Mother's Name must contain only alphabets and spaces"
                }
              })}
            />
            <Input
              label="Mother's Name (In Local Language)"
              placeholder="Mother's Name (In Local Language)"
              {...register("personalDetails.localMotherName")}
            />
          </div>

          <div className="grid lg:grid-cols-2 gap-x-10 gap-y-4">
            <Input
              required="true"
              errors={errors?.personalDetails?.fatherName}
              label="Father's Name (In English)"
              placeholder="Father's Name (In English)"
              {...register("personalDetails.fatherName", {
                required: "Father's Name (In English) required",
                pattern: {
                  value: /^[A-Za-z\s]+$/,
                  message: "Father's Name must contain only alphabets and spaces"
                }
              })}
            />
            <Input
              label="Father's Name (In Local Language)"
              placeholder="Father's Name (In Local Language)"
              {...register("personalDetails.localFatherName")}
            />
          </div>

          <div className="grid lg:grid-cols-2 gap-x-10 gap-y-4 my-4">
            <Select
              options={maritalStatuses}
              required="true"
              errors={errors?.personalDetails?.maritalStatus}
              label="Marital Status"
              {...register("personalDetails.maritalStatus", {
                required: "Marital Status is required"
              })}
            />
          </div>

          <div className="grid lg:grid-cols-2 gap-x-10 gap-y-4">
            <Select
              options={nationalities}
              errors={errors?.personalDetails?.nationality}
              label="Nationality"
              required="true"
              {...register("personalDetails.nationality", { required: "Nationality Required" })}
            />
          </div>

          <div className="grid lg:grid-cols-2 gap-x-10 gap-y-4 my-4">
            <Input
              label="Mobile No."
              placeholder="Mobile No."
              {...register("personalDetails.mobileNo", {
                pattern: {
                  value: /^[0-9]{10,11}$/,
                  message: "Mobile No. must be 10 or 11 digits"
                }
              })}
            />
            <Input
              label="Email"
              placeholder="Email Address"
              {...register("personalDetails.email", {
                pattern: {
                  value: /^[^\s@]+@[^\s@]+\.[^\s@]+$/,
                  message: "Invalid email address"
                }
              })}
            />
          </div>
        </section>

        <div className="flex flex-col gap-10">
          {/* General Details */}
          <section className="card">
            <h2>General Details</h2>

            <div className="grid lg:grid-cols-2 gap-x-6">
              <Input
                label="Electoral Photo Identity Cards(EPIC) No."
                placeholder="Old RC No. (If Any)"
                {...register("generalDetails.epic")}
              />
              <Input
                label="National Population Register(NPR) No."
                placeholder="BPL Number (If Any)"
                {...register("generalDetails.npr")}
              />
            </div>

            <div className="grid grid-cols-2 gap-x-8 my-4">
              <Input
                type="checkbox"
                label="Is Beneficiary has MNREGA Card"
                className="!w-fit"
                {...register("generalDetails.hasMNREGA")}
              />
              {watch("generalDetails.hasMNREGA") && (
                <Input
                  required={watch("generalDetails.hasMNREGA") ? "true" : ""}
                  label="MNREGA No."
                  errors={errors?.generalDetails?.MNREGA}
                  placeholder="MNREGA No."
                  {...register("generalDetails.MNREGA", {
                    required: watch("generalDetails.hasMNREGA") ? "MNREGA No. required" : false
                  })}
                />
              )}
            </div>

            <div className="grid grid-cols-2 gap-x-8 my-4">
              <Input
                type="checkbox"
                label="Is Beneficiary has Aadhaar Card"
                className="!w-fit"
                {...register("generalDetails.hasAadhaar")}
              />
              {watch("generalDetails.hasAadhaar") && (
                <Input
                  required={watch("generalDetails.hasAadhaar") ? "true" : ""}
                  label="Aadhaar No."
                  errors={errors?.generalDetails?.aadhaar}
                  placeholder="Aadhaar No."
                  {...register("generalDetails.aadhaar", {
                    required: watch("generalDetails.hasAadhaar") ? "Aadhaar No. required" : false
                  })}
                />
              )}
            </div>
          </section>

          {/* Professional Details */}
          <section className="card">
            <h2>Professional Details</h2>

            <div className="grid lg:grid-cols-2 gap-x-6">
              <Input
                label="Occupation"
                placeholder="Occupation"
                {...register("professionalDetails.occupation")}
              />
              <Input
                label="Employer Name (If Employed)"
                placeholder="Employer Name (If Employed)"
                {...register("professionalDetails.employer")}
              />
            </div>

            <div className="grid lg:grid-cols-2 gap-x-6 my-4">
              <Input
                label="Monthly Income"
                type="number"
                placeholder="Monthly Income"
                {...register("professionalDetails.income")}
              />
              <Input
                label="Annual Income"
                type="number"
                placeholder="Annual Income"
                {...register("professionalDetails.annualIncome")}
              />
            </div>
          </section>

          {/* Additional Details */}
          <section className="card">
            <h2>Additional Details</h2>

            <div className="grid lg:grid-cols-2 gap-x-6">
              <Select
                label="Scheme"
                options={schemes}
                {...register("additionalDetails.scheme")}
              />
              <Input
                label="Scheme Registration No."
                placeholder="Scheme Registration No."
                {...register("additionalDetails.schemeRegistrationNo")}
              />
            </div>

            <div className="grid lg:grid-cols-2 gap-x-6 my-4">
              <Input
                label="Registration Date"
                type="date"
                {...register("additionalDetails.registrationDate")}
              />
              <Select
                label="Beneficiary Type"
                options={beneficiaryType}
                {...register("additionalDetails.beneficiaryType")}
              />
            </div>
          </section>
        </div>
      </div>

      <div className="flex justify-end mt-10 gap-4">
        <Button
          type="button"
          onClick={() => onClose()}
        >
          Close
        </Button>
        <Button
          type="submit"
          onClick={handleSubmit(addMember)}
          // disabled={loading}
        >
          {/* {loading ? "Submitting..." : "Submit"} */}
        </Button>
      </div>
    </form>
  );
}

export default AddForm;
 