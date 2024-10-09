import React from "react";
import Select from "../components/common/Select";
import { useForm } from "react-hook-form";
import Input from "../components/common/Input";

function NewOfficialRegister() {
  const {
    register,
    handleSubmit,
    watch,
    formState: { errors },
    setValue,
  } = useForm();
  return (
    <form className=" h-full bg-transparent flex flex-col gap-y-10 mx-5 my-5 rounded-md p-5 lg:p-10 bg-[whitesmoke]">
      <h1>New User Registeration</h1>

      <div className="grid lg:grid-cols-2 gap-10 grid-rows-[masonry]">
        {/* Applicant's Personal Details */}
        <section className="card h-fit">
          <h2>Applicant's Personal Details</h2>

          <div className="w-full gap-10 mt-8">
            <div className="grid lg:grid-cols-2 gap-x-10 gap-y-4 my-4  ">
              <Input
                errors={errors?.personalDetails?.userName}
                required="true"
                label="User Name (In English)"
                placeholder="User Name (In English)"
                {...register("personalDetails.userName", {
                  required: "Mother's Name (In English) required",
                })}
              />
              <Input
                label="User Name (In Local Language)"
                placeholder="User Name (In Local Language)"
                {...register("personalDetails.userNameLocal")}
              />
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
                {...register("personalDetails.motherNameLocal")}
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
                {...register("personalDetails.fatherNameLocal")}
              />
            </div>

            <div className="grid grid-cols-2  gap-x-10">
              <Input
                errors={errors?.personalDetails?.dob}
                label="Date of Birth"
                type="date"
                required="true"
                {...register("personalDetails.dob", {
                  required: " Date of Birth required",
                })}
              />
              <Select
                errors={errors?.personalDetails?.gender}
                options={[{name : "Male"} , {name :"Female"}]}
                label="Gender"
                required="true"
                {...register("personalDetails.gender", {
                  required: "Gender required",
                })}
              />
            </div>

            <div className="grid grid-cols-2  gap-x-10">
              <Input
                label="Email"
                required="true"
                errors={errors?.personalDetails?.email}
                placeholder="Email Address"
                {...register("personalDetails.email")}
              />

              <Input
                label="UIDAI/Aadhar No./VID"
                placeholder="UIDAI/Aadhar No./VID"
                required="true"
                errors={errors?.personalDetails?.aadharNo}
                {...register("personalDetails.aadharNo")}
              />
            </div>
          </div>

          <div className="grid lg:grid-cols-2 gap-x-10 gap-y-4 my-4 "></div>

          <div className="grid lg:grid-cols-2 gap-x-10 gap-y-4"></div>

          <div className="grid lg:grid-cols-2 gap-x-10 gap-y-4 my-4 "></div>
        </section>

       
          {/* General Details */}
          <section className="card h-fit">
            <h2>Office Details</h2>
            <Input
              label="Invitation Code"
              placeholder="Invitation Code"
              disabled
              // {...register("generalDetails.epic")}
            />

            <div className="grid lg:grid-cols-2 gap-x-6 my-4">
              <p className="font-bold">
                Department : <span className="font-normal">Department</span>
              </p>
              <p className="font-bold">
                User Role : <span className="font-normal">User</span>
              </p>
            </div>
            <div className="grid lg:grid-cols-2 gap-x-6 my-4 ">
              <p className="font-bold">
                Invitation Remarks : <span className="font-normal"></span>
              </p>

              <Input
                label="Remarks"
                className="150px"
                placeholder="Remarks"
                {...register("generalDetails.npr")}
              />
            </div>
          </section>

          <section className="card">
            <div className="flex ">
                <Input className="mt-2" type="checkbox" name="consent" $id="consent"></Input>
                <label className="ml-2" id="consent">I agree to the Terms & Conditions and give my consent to store my Aadhaar number in encrypted format to use various authentication services provided in the PDS application softwares.</label>
            </div>
          </section>
                
            <section className="card">
                <Input label="Preferred LoginId"></Input>
            </section>
      </div>

      <div className="flex gap-2 justify-center">
        <button type="button">Reset</button>
        <button type="submit">Submit</button>
        <button type="button">Save</button>
      </div>
    </form>
  );
}

export default NewOfficialRegister;
