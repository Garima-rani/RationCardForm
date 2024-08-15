import React from 'react'
import { useForm } from 'react-hook-form';
import Input from '../common/Input';
import Select from '../common/Select';
import Button from '../common/Button';


const states = [
    "Assam",
    "Chandigarh",
    "Dadra and Nagar Haveli",
    "Goa",
    "Gujarat",
    "Jammu and Kashmir",
    "Lakshadweep",
    "Maharashtra",
    "Manipur",
    "Meghalya",
    "Mizoram",
    "Nagaland",
    "Punjab",
    "Tripura",
    "Uttarakhand",
  ];
  const schemes = ["Antyodaya Anna Yojana", "Priority Household"];
  const beneficiaryType = ["Ration"];
  const genders = ["Male", "Female", "Transgender", "Not Applicable"];
  const maritalStatuses = [
    "Never Married",
    "Currently Married",
    "Widowed",
    "Seperated",
    "Divorced",
  ];
  const nationality = ["Indian", "Non-Resident Indian", "Others"];
  const occupations = [
    "Agriculture Labour",
    "Barber",
    "Beggar",
    "BlackSmith",
    "Business",
  ];

  
function AddForm({ addMember , onClose}) {
    const { handleSubmit,  register , formState : {errors} , watch } = useForm() ; 
     
    return (
        <form
       
        className=" h-[90vh] bg-transparent flex flex-col gap-y-10 m-5  card !bg-[lightgray] !p-10  overflow-auto lg:max-w-[1000px] mx-auto"
      >
      <h2>Add Memeber</h2>
        {/* Card Type */}
        
  
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
                  // {...register("personalDetails.profilePicture")}
                />
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
              <div className="grid grid-cols-2  gap-x-2">
                <Input
                  errors={errors?.personalDetails?.dob}
                  label="Date of Birth"
                  type="date"
                  
                  required="true"
                  {...register("personalDetails.dob", { required: " Date of Birth required" })}
                />
                <Input placeholder="0" disabled className="mt-7" />
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
              })}
            />
            <Input
              label="Father's Name (In Local Language)"
              placeholder="Father's Name (In Local Language)"
              {...register("personalDetails.localFatherName")}
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
              })}
            />
          </div>

          <div className="grid lg:grid-cols-2 gap-x-10 gap-y-4">
            <Select
              options={nationality}
              errors={errors?.personalDetails?.nationality}

              label="Nationality"
              required="true"
              {...register("personalDetails.nationality", { required: "Nationality Required" })}
            />
          </div>

          <div className="grid lg:grid-cols-2 gap-x-10 gap-y-4 my-4 ">
            <Input
              label="Mobile No."
              placeholder="Mobile No."
              {...register("personalDetails.mobileNo")}
            />
            <Input
              label="Email"
              placeholder="Email Address"
              {...register("personalDetails.email")}
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
                })}
              />
              <Input
                label="Annual Income (In Rs.) "
                placeholder="Annual Income (In Rs.) "
                errors={errors?.professionalDetails?.income}
                required="true"
                {...register("professionalDetails.income", { required: "Annual Income required" })}
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

          {/* <div className="flex justify-end">
            <button type="submit" onClick={(e)=>submitHandler(e)}>Save and Continue</button>
          </div> */}
        </div>
          <div className="flex justify-end gap-5 ">
                <button type="button" onClick={onClose}>Close</button>
              <button  onClick={handleSubmit(addMember)} className='px-10 py-5 rounded-lg bg-blue-500' >Submit</button>
            </div>
        </div>
      </form>
  )
}

export default AddForm