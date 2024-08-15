import React from "react";
import Select from "../common/Select";
import Input from "../common/Input";
import { useWatch } from "react-hook-form";
const categories = ["General", "SC/BC", "OBC"];
const houseType = ["Kucha House", "Pucca House"];
const bankNames = ["PNB" , "SBI" , "Axis"];
const bankBranches =  ["Bhiwani Stand" , "Rohini"]
const gasStatuses = ["active" , "inactive"]
function Form3({ methods }) {
  const {
    register,
    formState: { errors },
  
    watch,
  } = methods;

  console.log(watch("illnessDetails.since"))
  return (
    <div className=" h-full bg-transparent  grid lg:grid-cols-2 gap-10 px-5 ">
      {/* Other Details */}
      <section className="card h-fit">
        <h2>Other Details</h2>

        <div className=" grid md:grid-cols-2 gap-x-6 gap-y-4 ">
          <Select
            label="Caste Category"
            options={categories}
            required="true"
            errors={errors?.otherDetails?.casteCategory}
            {...register("otherDetails.casteCategory", {
              required: "Caste category is required",
            })}
          />
          <Input
            type="file"
            disabled={watch("otherDetails.casteCategory") == "general" || !watch("otherDetails.casteCategory") ? true : false}
            required={!(watch("otherDetails.casteCategory") == "general" || !watch("otherDetails.casteCategory")) ? "true" : false}
            label="Caste Category Certificate"
            className="p-[5px]"
            errors={errors?.otherDetails?.casteCategoryCertificate}
            {...register("otherDetails.casteCategoryCertificate", {
              required:
                watch("otherDetails.casteCategory") == "general" || !watch("otherDetails.casteCategory")
                  ? false
                  : "Caste Category Certificate is required",
            })}
          />
          <Select
            errors={errors?.otherDetails?.houseType}
            label="House Type"
            options={houseType}
            required="true"
            {...register("otherDetails.houseType", { required: "House Type is required" })}
          />
        </div>
      </section>

      {/* Bank Details */}
      <section className="card h-fit">
        <div className="grid grid-cols-[30%_70%] gap-7 ">
          <h2>Bank Details</h2>
          <div className="flex gap-2 items-start">
            <Input
              type="checkbox"
              className="!w-fit mt-2"
              $id="hasBankAccount"
              {...register("hasBankAccount")}
            />
            <label
              htmlFor="hasBankAccount"
              className="!w-fit mt-1 text-sm font-bold"
            >
              Yes,applicant has bank account.
            </label>
          </div>
        </div>

        <div className=" grid md:grid-cols-2 gap-x-6 gap-y-4 ">
          <Input
            label="Bank Account No."
            disabled={!watch("hasBankAccount")}
            required={watch("hasBankAccount") ? "true" : false}
            placeholder="Bank Account No."
            errors={errors?.bankDetails?.bankAccountNo}
            {...register("bankDetails.bankAccountNo", {
              required: watch("hasBankAccount")
                ? "Bank Account No. is required"
                : false,
            })}
          />
          <Select
            label="Bank Name"
            disabled={!watch("hasBankAccount")}
            options = {bankNames}
            required={watch("hasBankAccount") ? "true" : false}
            errors={errors?.bankDetails?.bankName}
            {...register("bankDetails.bankName", {
              required: watch("hasBankAccount")
                ? "Bank Name is required"
                : false,
            })}
          />
          <Select
            label="Branch Name"
            options = {bankBranches}
            disabled={!watch("hasBankAccount")}
            required={watch("hasBankAccount") ? "true" : false}
            errors={errors?.bankDetails?.branchName}
            {...register("bankDetails.branchName", {
              required: watch("hasBankAccount")
                ? "Bank Name is required"
                : false,
            })}
          />
          <Input
            label="Bank branch IFSC Code"
            disabled={!watch("hasBankAccount")}
            required={watch("hasBankAccount") ? "true" : false}
            errors={errors?.bankDetails?.ifscCode}
            placeholder="IFSC Code"
            {...register("bankDetails.ifscCode", {
              required: watch("hasBankAccount")
                ? "Bank Name is required"
                : false,
            })}
          />
        </div>
      </section>

      {/* Gas Details */}
      <section className="card">
        <div className="grid grid-cols-[30%_70%] gap-7 ">
          <h2>Gas Connection Details</h2>
          <div className="flex gap-2 items-start">
            <Input
              type="checkbox"
              className="!w-fit mt-2"
              $id="hasGasConnection"
              {...register("hasGasConnection")}
            />
            <label
              htmlFor="hasGasConnection"
              className="!w-fit mt-1 text-sm font-bold"
            >
              Yes,applicant has gas connection.
            </label>
          </div>
        </div>

        <div className=" grid md:grid-cols-2 gap-x-6 gap-y-4 ">
          <Select
          options = {gasStatuses}
            label="Gas Connection Status"
            disabled={!watch("hasGasConnection")}
            required={watch("hasGasConnection") ? "true" : false}
            errors={errors?.gasDetails?.gasConnectionStatus}
            {...register("gasDetails.gasConnectionStatus", {
              required: watch("hasGasConnection")
                ? "Gas Connection Status required"
                : false,
            })}
          />
          <Select
            label="Gas Company Name"
            options = {["HP" , "Indane"]}
            disabled={!watch("hasGasConnection")}
            required={watch("hasGasConnection") ? "true" : false}
            errors={errors?.gasDetails?.company}
            {...register("gasDetails.company", {
              required: watch("hasGasConnection")
                ? "Gas Connection Company required"
                : false,
            })}
          />
          <Select
            label="Gas Agency Name"
            options = {["Rohini" , "Sunny"]}
            disabled={!watch("hasGasConnection")}
            required={watch("hasGasConnection") ? "true" : false}
            errors={errors?.gasDetails?.agency}
            {...register("gasDetails.agency", {
              required: watch("hasGasConnection")
                ? "Gas Connection Agency required"
                : false,
            })}
          />
          <Input
            label="Consumer No."
            disabled={!watch("hasGasConnection")}
            required={watch("hasGasConnection") ? "true" : false}
            errors={errors?.gasDetails?.consumer}
            {...register("gasDetails.consumer", {
              required: watch("hasGasConnection")
                ? "Consumer No. required"
                : false,
            })}
          />
        </div>
      </section>
     
     
     {/* Electric Connection Details */}
      <section className="card h-fit">
        <div className="grid grid-cols-[30%_70%] gap-7 ">
          <h2>Electric Connection Details</h2>
          <div className="flex gap-2 items-start">
            <Input
              type="checkbox"
              className="!w-fit mt-2"
              $id="hasElectricityConnection"
              {...register("hasElectricityConnection")}
            />
            <label
              htmlFor="hasElectricityConnection"
              className="!w-fit mt-1 text-sm font-bold"
            >
              Yes,applicant has electric connection.
            </label>
          </div>
        </div>
        <div className=" grid md:grid-cols-2 gap-x-6 gap-y-4 ">
          <Select
            label="Electric Company Name"
            options = {["UHBVNL"]}
            required={watch("hasElectricityConnection")}
            disabled={!watch("hasElectricityConnection")}
            errors={errors?.electricityDetails?.companyName}
            {...register("electricityDetails.companyName", {
              required: watch("hasElectricityConnection")
                ? "Electric Company Name required"
                : false,
            })}
          />
          <Input
            label="Consumer No."
            required={watch("hasElectricityConnection")}
            disabled={!watch("hasElectricityConnection")}
            errors={errors?.electricityDetails?.consumerNo}
            placeholder="Consumer No."
            {...register("electricityDetails.consumerNo", {
              required: watch("hasElectricityConnection")
                ? "Consumer No. required"
                : false,
            })}
          />
        </div>
      </section>

      {/* PhysicalDetails */}
      <section className="card">
        <div className="grid grid-cols-[30%_70%] gap-7 ">
          <h2>Physical Details</h2>
          <div className="flex gap-2 items-start">
            <Input
              type="checkbox"
              className="!w-fit mt-2"
              $id="isPhysicallyAble"
              {...register("isPhysicallyAble")}
            />
            <label
              htmlFor="isPhysicallyAble"
              className="!w-fit mt-1 text-sm font-bold"
            >
              Yes,applicant is differently abled.
            </label>
          </div>
        </div>
        <div className=" grid md:grid-cols-2  gap-x-6 gap-y-4 ">
          <div className="row-span-2 border p-2 ">
            <div className="flex gap-2 items-start">
              <Input
                type="checkbox"
                disabled={!watch("isPhysicallyAble")}
                className="!w-fit mt-2"
                $id="ortho"
                {...register("physicalDetails.orthoAbled")}
              />
              <label htmlFor="ortho" className="!w-fit mt-1 text-sm font-bold">
                Ortho Differently Abled
              </label>
            </div>{" "}
            <div className="flex gap-2 items-start">
              <Input
                type="checkbox"
                disabled={!watch("isPhysicallyAble")}
                className="!w-fit mt-2"
                $id="visuallyAbled"
                {...register("physicalDetails.visuallyAbled")}
              />
              <label
                htmlFor="visuallyAbled"
                className="!w-fit mt-1 text-sm font-bold"
              >
                Visually differently abled.
              </label>
            </div>{" "}
            <div className="flex gap-2 items-start">
              <Input
                type="checkbox"
                className="!w-fit mt-2"
                $id="hearingImpaired"
                disabled={!watch("isPhysicallyAble")}
                {...register("physicalDetails.hearingImpaired")}
              />
              <label
                htmlFor="hearingImpaired"
                className="!w-fit mt-1 text-sm font-bold"
              >
                Hearing Impaired
              </label>
            </div>{" "}
            <div className="flex gap-2 items-start">
              <Input
                type="checkbox"
                className="!w-fit mt-2"
                $id="multipleAbled"
                disabled={!watch("isPhysicallyAble")}
                {...register("physicalDetails.multipleAbled")}
              />
              <label
                htmlFor="multipleAbled"
                className="!w-fit mt-1 text-sm font-bold"
              >
                Multiple Differently Abled
              </label>
            </div>
          </div>

          <Input
            required={watch("isPhysicallyAble")}
            disabled={!watch("isPhysicallyAble")}
            label="Percentage (if Physically Disable)"
            errors={errors?.physicalDetails?.percentage}
            {...register("physicalDetails.percentage", {
              required: watch("isPhysicallyAble")
                ? "Percentage required"
                : false,
            })}
          />
          <Select
            options ={ ["Accident"]}
            required={watch("isPhysicallyAble")}
            disabled={!watch("isPhysicallyAble")}
            label="Differently abled due to"
            errors={errors?.physicalDetails?.dueTo}
            {...register("physicalDetails.dueTo", {
              required: watch("isPhysicallyAble") ? "Field required" : false,
            })}
          />

          <div className="flex flex-wrap items-baseline gap-2 ">
            <p className="mr-3">Disability since</p>
            <div className="flex gap-2 items-start">
              <Input
                type="radio"
                className="!w-fit mt-2"
                $id="birth"
                name="since"
                value="birth"
                
                disabled={!watch("isPhysicallyAble")}
                {...register("physicalDetails.since")}
              />
              <label htmlFor="birth" className="!w-fit mt-1 text-sm font-bold">
                Birth
              </label>
            </div>

            <div className="flex gap-2 items-start">
              <Input
                type="radio"
                className="!w-fit mt-2"
                $id="year"
                value="year"
                name="since"
                options = {["1995" , "1996"]}
                disabled={!watch("isPhysicallyAble")}
                {...register("physicalDetails.since")}
              />
              <label htmlFor="year" className="!w-fit mt-1 text-sm font-bold">
                Year
              </label>
            </div>
          </div>

          <Select
            label="Disability Since Year"
            options={["1996" , "1997"]}
            required={(watch("physicalDetails.since") == "year")}
            disabled={!(watch("physicalDetails.since") == "year")}
            errors={errors?.physicalDetails?.year}
            {...register("physicalDetails.year", {
              required: watch("physicalDetails.since") == "year" ? "Year required" : false,
            })}
          />
          <Input
            label="Physical Disability Certificates"
            type="file"
            required={watch("isPhysicallyAble")}
            disabled={!watch("isPhysicallyAble")}
            errors={errors?.physicalDetails?.certificate}
            {...register("physicalDetails.certificate", {
              required: watch("isPhysicallyAble")
                ? "Certificate required"
                : false,
            })}
          />
        </div>
      </section>

      <section className="card h-fit">
        <div className="grid grid-cols-[30%_70%] gap-7 ">
          <h2>Critical Illness Details</h2>
          <div className="flex gap-2 items-start">
            <Input
              type="checkbox"
              className="!w-fit mt-2"
              $id="isCritical"
              {...register("isCritical")}
            />
            <label
              htmlFor="isCritical"
              className="!w-fit mt-1 text-sm font-bold"
            >
              Yes,applicant is critical ill.
            </label>
          </div>
        </div>
        <div className=" grid md:grid-cols-2 gap-x-6 gap-y-4 ">
          <Select
            label="Critical Illness Status"
            disabled={!watch("isCritical")}
            required={watch("isCritical")}
            {...register("illnessDetails.status" , {required :watch("isCritical") ? "Status Required" : false })}

          />
          <Input
            label="Percentage (if critically ill)"
            disabled={!watch("isCritical")}
            required={watch("isCritical")}

            {...register("illnessDetails.percentage" , {required :watch("isCritical") ? "Percentage Required" : false })}


          />
          <div className="flex flex-wrap items-baseline gap-2 ">
            <p className="mr-3">Critical Ill since</p>
            <div className="flex gap-2 items-start">
              <Input
                type="radio"
                className="!w-fit mt-2"
                disabled={!watch("isCritical")}
                $id="criticalBirth"
                name="criticalSince"
                value="birth"
                {...register("illnessDetails.since")}
              />
              <label
                htmlFor="criticalBirth"
                className="!w-fit mt-1 text-sm font-bold"
              >
                Birth
              </label>
            </div>

            <div className="flex gap-2 items-start">
              <Input
                type="radio"
                className="!w-fit mt-2"
                $id="criticalYear"
                value="year"
                name="criticalSince"
                disabled={!watch("isCritical")}
                {...register("illnessDetails.since")}

              />
              <label
                htmlFor="criticalYear"
                className="!w-fit mt-1 text-sm font-bold"
              >
                Year
              </label>
            </div>
          </div>

          <Select
            label="Critical illness since year"
            disabled={!watch("isCritical")  }
            required={!watch("isCritical") }
            {...register("illnessDetails.year" , {required :watch("isCritical") ? "Year Required" : false })}


          />

          <Input
            type="file"
            label="Critical Illness Certificates"
            disabled={!watch("isCritical")}
            required={!watch("isCritical")}
            {...register("illnessDetails.certificate" ,{required : watch("isCritical") ?  "Certificate Required" : false })}

          />
        </div>
      </section>
    </div>
  );
}

export default Form3;