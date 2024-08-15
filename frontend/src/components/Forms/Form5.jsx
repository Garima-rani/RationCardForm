import React from "react";
import Select from "../common/Select";
import Input from "../common/Input";

function Form5({ methods }) {
  const {
    register,
    formState: { errors },
    watch,
  } = methods;
  return (
    <div className="px-5 ">
      <section className="card">
        <h2>Attached Enclosures Details</h2>
        <div className="overflow-x-auto">
          <table className="w-full border p-2 border-collapse min-w-[900px] mb-5">
            <thead>
              <tr className="mb-[5]">
                <th>Sl No.</th>
                <th>Document Required</th>
                <th>Enclosure Type</th>
                <th>Enclosed Document No.</th>
                <th>Document Issue Date</th>
                <th>Files to be Uploaded</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td>1</td>
                <td>Identity Proof</td>
                <td>
                  <Select {...register("identity.enclosureType")} />
                </td>
                <td>
                  <Input
                    disabled={!watch("identity.enclosureType")}
                    placeholder="documentNo."
                    required={watch("identity.enclosureType")}
                    {...register("identity.enclosureNo")}
                  />
                </td>
                <td>
                  <Input
                    type="date"
                    disabled={!watch("identity.enclosureNo")}
                    placeholder="documentNo."
                    required={watch("identity.enclosureNo")}
                    {...register("identity.issueDate")}
                  />
                </td>
                <td>
                  {" "}
                  <Input
                    type="file"
                    disabled={!watch("identity.issueDate")}
                    placeholder="documentNo."
                    required={watch("identity.issueDate")}
                    // {...register("identity.file")}
                  />
                </td>
              </tr>

              <tr>
                <td>2</td>
                <td>Address Proof</td>
                <td>
                  <Select {...register("address.enclosureType")} />
                </td>
                <td>
                  <Input
                    disabled={!watch("address.enclosureType")}
                    placeholder="documentNo."
                    required={watch("address.enclosureType")}
                    {...register("address.enclosureNo")}
                  />
                </td>
                <td>
                  <Input
                    type="date"
                    disabled={!watch("address.enclosureNo")}
                    placeholder="documentNo."
                    required={watch("address.enclosureNo")}
                    {...register("address.issueDate")}
                  />
                </td>
                <td>
                  {" "}
                  <Input
                    type="file"
                    disabled={!watch("address.issueDate")}
                    placeholder="documentNo."
                    required={watch("address.issueDate")}
                    // {...register("address.file")}
                  />
                </td>
              </tr>
            </tbody>
          </table>
        </div>
      </section>
    </div>
  );
}

export default Form5;
