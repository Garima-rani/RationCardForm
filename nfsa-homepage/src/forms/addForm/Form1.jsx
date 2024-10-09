
import React, { useEffect , useState } from "react";
import axios from "axios";
import Input from "../../components/common/Input";
import Select from "../../components/common/Select";
import {useFetchOptions} from "../../hook/useFetchOption"
import { handleImageChange } from "../../utils/handleImageChange";

function Form1({methods , setLoading }) {

   const { options: states } = useFetchOptions('/api/masters/states');
   console.log(states , "states") ; 
   const { options: schemes } = useFetchOptions('/api/masters/schemes');
  const { options: beneficiaryType } = useFetchOptions('/api/masters/beneficiary-types');
  const { options: genders } = useFetchOptions('/api/masters/genders');
  const { options: maritalStatuses } = useFetchOptions('/api/masters/marital-statuses');
  console.log(maritalStatuses) ;
 const { options: nationality } = useFetchOptions('/api/masters/nationalities');
  const { options: occupations } = useFetchOptions('/api/masters/occupations');
  
  
  const { register, trigger , formState, watch , setValue} = methods;
  const { errors} = formState;

  const getDOB = (e)=>{
    const { value } = e.target; // Get the value from the input field
    const birthDate = new Date(value);
    const today = new Date();
    let age = today.getFullYear() - birthDate.getFullYear();
    const monthDiff = today.getMonth() - birthDate.getMonth();
  
    // Adjust age if the birthday hasn't occurred yet this year
    if (monthDiff < 0 || (monthDiff === 0 && today.getDate() < birthDate.getDate())) {
      age--;
    }
    console.log(age) ; 
    setValue("personalDetails.age" , age)
    // Add any additional logic you need for handling the date of birth
  }

  watch() ; 


  

  return (
    <div
      // onSubmit={handleSubmit(submitHandler)}
      className=" h-full bg-transparent flex flex-col gap-y-10 mx-5"
    >
      {/* Card Type */}
      <section className="card">
        <h2>Card Type</h2>
        <div className="grid md:grid-cols-2 gap-x-10 gap-y-4 place-items-start">
          <Select
            errors={errors?.cardType?.state}
            options={states}
            label="State"
            required="true"
            placeholder="State"
            {...register("cardType.state", { required: "State is required",
              onChange : (e)=> trigger("cardType.state")
             })}
          />
          <div className="hidden md:block"></div>

          <Select
            errors={errors?.cardType?.scheme}
            options={schemes}
            label="Select scheme under which you want apply ration card"
            required="true"
            placeholder="Select one"
            {...register("cardType.scheme", { required: "Scheme is required",
              onChange : (e)=> trigger("cardType.scheme")
             })}
          />
          <Select
            errors={errors?.cardType?.beneficiaryType}
            options={beneficiaryType}
            label="Select beneficiary type"
            required="true"
            placeholder="Select one"
            {...register("cardType.beneficiaryType", {
              required: "Beneficiary Type is required",
              onChange : (e)=> trigger("cardType.beneficiaryType")
            })}
          />
        </div>
      </section>

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
                 
                  className="h-[200px] w-[200px]  "
                  onChange = {(e) =>handleImageChange(e,methods , "personalDetails.profilePicture" , setLoading)}
                />
                {/* <Input className="hidden" {...register("personalDetails.profilePicture")} /> */}
                <label
                  className="text-sm text-blue-700 cursor-pointer"
                  htmlFor="pic"
                >
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
                  onChange : (e)=> trigger("personalDetails.name"),
                                    pattern: {
                    value: /^[A-Za-z\s]+$/,
                    message: "Name must contain only alphabets and spaces"
                  }
                })}
              />
              <Input
                label="Name in Local Language (Preferably as in Aadhar)"
                placeholder="Name in Local Language (Preferably as in Aadhar)"
                {...register("personalDetails.localName",{
                  onChange : (e)=> trigger("personalDetails.loacalName"),
                   pattern: {
                  value: /^[A-Za-z\s]+$/,
                  message: "Name must contain only alphabets and spaces"
                }})}
              />
              <Select
                errors={errors?.personalDetails?.gender}
                options={genders}
                label="Gender"
                required="true"
                {...register("personalDetails.gender", { required: "Gender required",
                  onChange : (e)=> trigger("personalDetails.gender"),

                 })}
              />
              <div className="grid grid-cols-2  gap-x-2">
                <Input
                  errors={errors?.personalDetails?.dob}
                  label="Date of Birth"
                  type="date"
                
                  required="true"
                  {...register("personalDetails.dob", { 
                    required: "Date of Birth is required",
                    onChange: (e) => {
                      trigger("personalDetails.dob");
                      getDOB(e);
                    }
                  })}
                />
                <Input placeholder="0" disabled className="mt-7" {...register("personalDetails.age")} />
              </div>
            </div>
          </div>

          <div className="grid lg:grid-cols-2 gap-x-10 gap-y-4 my-4 ">
            <Input
              errors={errors?.personalDetails?.motherName}
              required="true"
              label="Mother's Name (In English)"
              placeholder="Mother's Name (In English)"
              {...register("personalDetails.motherName", {
                required: "Mother's Name (In English) required",
                onChange : ()=>trigger("personalDetails.motherName") ,
                                pattern: {
                  value: /^[A-Za-z\s]+$/,
                  message: "Name must contain only alphabets and spaces"
                }
              })}
            />
            <Input
              label="Mother's Name (In Local Language)"
              placeholder="Mother's Name (In Local Language)"
              {...register("personalDetails.localMotherName",{
                onChange : ()=>trigger("personalDetails.localMotherName") ,
                
                pattern: {
                  value: /^[A-Za-z\s]+$/,
                  message: "Name must contain only alphabets and spaces"
                }
              })}
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
                onChange : ()=>trigger("personalDetails.fatherName") ,
                pattern: {
                  value: /^[A-Za-z\s]+$/,
                  message: "Name must contain only alphabets and spaces"
                }
              })}
            />
            <Input
              label="Father's Name (In Local Language)"
              placeholder="Father's Name (In Local Language)"
              {...register("personalDetails.localFatherName",{ 
                onChange : ()=>trigger("personalDetails.localFatherName") ,
                
                pattern: {
                value: /^[A-Za-z\s]+$/,
                message: "Name must contain only alphabets and spaces"
              }})}
            />
          </div>

          <div className="grid lg:grid-cols-2 gap-x-10 gap-y-4 my-4 ">
            <Select
              options={maritalStatuses}
              required="true"
              errors={errors?.personalDetails?.maritalStatus}

              label="Marital Status"
              {...register("personalDetails.maritalStatus", {
                required: "Marital Status is required",
                onChange : ()=>trigger("personalDetails.maritalStatus") ,
              })}
            />
          </div>

          <div className="grid lg:grid-cols-2 gap-x-10 gap-y-4">
            <Select
              options={nationality}
              errors={errors?.personalDetails?.nationality}

              label="Nationality"
              required="true"
              {...register("personalDetails.nationality", { required: "Nationality Required",
                onChange : ()=>trigger("personalDetails.nationality") ,
               })}
            />
          </div>

          <div className="grid lg:grid-cols-2 gap-x-10 gap-y-4 my-4 ">
            <Input
              label="Mobile No."
              errors = {errors?.personalDetails?.mobileNo}
              placeholder="Mobile No."
              required ={true}
              {...register("personalDetails.mobileNo",{
                required : "Mobile Number is required",
                onChange : (e)=> trigger("personalDetails.mobileNo") ,
                pattern: {
                  value: /^[0-9]{10}$/,
                  message: "Mobile number must be exactly 10 digits"
                }
              })}
            />
            <Input
              label="Email"
              placeholder="Email Address"
              errors = {errors?.personalDetails?.email}

              {...register("personalDetails.email",{
                required : "Email is required",
                onChange : (e)=> trigger("personalDetails.email") ,
                pattern: {
                  value: /^[^\s@]+@[^\s@]+\.[^\s@]+$/,
                  message: "Please enter a valid email address"
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

            <div className="grid grid-cols-2  gap-x-8 my-4 ">
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
                    required: watch("generalDetails.hasMNREGA")
                      ? "MNREGA No. required"
                      : false,
                  })}
                />
              )}
            </div>

            <div className="grid grid-cols-2  gap-x-8 my-4 ">
              <Input
                type="checkbox"
                label="Is Beneficiary has unique Identification (UIDAI/AAdhar) No."
                className="!w-fit"
                // defaultChecked
                {...register("generalDetails.hasAadhar")}
              />
              {watch("generalDetails.hasAadhar") && (
                <Input
                  required={watch("generalDetails.hasAadhar") ? "true" : ""}
                  label="Unique Identification (UIDAI/Aadhar) No."
                  errors={errors?.generalDetails?.aadharNo}
                  placeholder="Unique Identification (UIDAI/Aadhar) No."
                  {...register("generalDetails.aadharNo", {
                    required: watch("generalDetails.hasAadhar")
                      ? "Unique Identification (UIDAI/Aadhar) No. is required"
                      : false,
                  })}
                />
              )}
            </div>
            {!watch("generalDetails.hasAadhar") && (
              <div>
                <p className="font-bold">
                  Though, Aadhaar/UID number is not mandatory for applying
                  through CRP. But for making ration card, it is mandatory in
                  the ration card management system of the states. The Aadhaar
                  number provided by you gives ease to the food inspectors in
                  physical verification of your application and will help in the
                  process of making the ration card at a faster pace. Therefore,
                  if you have a valid Aadhaar number available with you, then
                  definitely provide it. Also, aadhaar empowers you to collect
                  the ration from Fair Price Shop after biometric authentication
                  only.
                  <br />
                  <br /> हालांकि, सीआरएफ के माध्यम से आवेदन करने के लिए आधार /
                  यूआईडी संख्या अनिवार्य नहीं है। लेकिन राशन कार्ड बनाने के लिए
                  राज्यों के राशन कार्ड प्रबंधन प्रणाली में यह अनिवार्य है। आपके
                  द्वारा प्रदान किया गया आधार नंबर खाद्य निरीक्षकों को आपके
                  आवेदन के भौतिक सत्यापन में आसानी देता है और तेज गति से राशन
                  कार्ड बनाने की प्रक्रिया में मदद करेगा। इसलिए, यदि आपके पास एक
                  वैध आधार संख्या उपलब्ध है, तो उसे अवश्य प्रदान करें। साथ ही,
                  आधार आपको बायोमेट्रिक प्रमाणीकरण के बाद ही उचित मूल्य की दुकान
                  से राशन लेने का अधिकार देता है।
                </p>

                <div className="grid grid-cols-2 place-items-end gap-x-8 my-4 ">
                  <Input
                    type="checkbox"
                    label="Is Beneficiary has unique Identification (UIDAI/AAdhar) No."
                    className="!w-fit"
                    {...register("generalDetails.hasAadharEnrollment")}
                  />
                  {watch("generalDetails.hasAadharEnrollment") && (
                    <Input
                      required={watch("generalDetails.hasAadharEnrollment") ? "true" : ""}
                      label="Unique Identification (UIDAI/Aadhar) No."
                      placeholder="Unique Identification (UIDAI/Aadhar) No."
                      errors={errors?.generalDetails?.aadharEnrollmentNo}
                      {...register("generalDetails.aadharEnrollmentNo", {
                        required: watch("generalDetails.hasAadharEnrollment")
                          ? "Unique Identification (UIDAI/Aadhar) No. required"
                          : false,
                      })}
                    />
                  )}
                </div>
              </div>
            )}
          </section>

          {/* Professional Details */}
          <section className="card">
            <h2>Professional Details</h2>

            <div className="grid lg:grid-cols-2  gap-x-8">
              <Select
                errors={errors?.professionalDetails?.occupation}
                options={occupations}
                label="Occupation"
                required="true"
                {...register("professionalDetails.occupation", {
                  required: "Occupation is required",
                onChange : ()=>trigger("professionalDetails.occupation") ,
                
                })}
              />
              <Input
                label="Annual Income (In Rs.) "
                placeholder="Annual Income (In Rs.) "
                errors={errors?.professionalDetails?.income}
                required="true"
                {...register("professionalDetails.income", { required: "Annual Income required" ,
                  onChange : ()=>trigger("professionalDetails.income") ,
                  min: {
                    value: 0,
                    message: "Income must be a positive number"
                  },
                  validate: {
                    isNumber: value => !isNaN(Number(value)) || "Income must be a valid number"
                  }
                })}
              />
            </div>
          </section>

          {/* Additional Details */}
          <section className="card">
            <h2>Additional Details</h2>

            <div className="grid lg:grid-cols-2 gap-x-8">
              <Input
                label="Old RC No. (If Any)"
                placeholder="Old RC No. (If Any)"
                {...register("additionalDetails.oldRc")}
              />
              <Input
                label="BPL Number (If Any)"
                placeholder="BPL Number (If Any)"
                {...register("additionalDetails.bplNo")}
              />
            </div>
          </section>

          <section className="card">
            <h2>Consent of data use</h2>

            <Input
              type="checkbox"
              checked
              disabled
              className="w-fit"
              {...register("permission")}
            />
            <p>
              By clicking on "Save and Continue" button you are in agreement
              with the concern department that you have no objection to
              authenticate above details with adhaar based system and consent to
              providing your aadhar number, biometric, and/or, OTP data for
              aadhar based authentication for the purpose of availing subsidy
              benefits from NFSA.
            </p>
            <p>Administered by AAHAR.</p>
          </section>

        </div>
      </div>
    </div>
  );
}

export default Form1;
