import axios from "axios";
import React, { useState } from "react";
import DeleteIcon from "@mui/icons-material/Delete";
import CreateSharpIcon from "@mui/icons-material/CreateSharp";
import { useForm } from "react-hook-form";
import Input from "../common/Input";
import Select from "../common/Select";
import CheckCircleRoundedIcon from "@mui/icons-material/CheckCircleRounded";
import NorthEastIcon from "@mui/icons-material/NorthEast";
import CloseRoundedIcon from "@mui/icons-material/CloseRounded";
import { useDispatch } from "react-redux";
import { setData } from "../../redux/slices/masterSlice";
import { Box, Modal } from "@mui/material";

function MeasurementUnit({ setTableData, master, headers = [], data = [], role }) {
  const [editId, setEditId] = useState(null);
  const [editedData, setEditedData] = useState(null);
  const [loading, setLoading] = useState(false);
  const [selectedData, setSelectedData] = useState(null);
  const [commodityForms , setCommodityForms] = useState([]);
  const [isOpen, setIsOpen] = useState(false);
  const { register, handleSubmit, reset } = useForm();
  const dispatch = useDispatch();

  const getCommodityForms = async(item)=>{
    const response = await axios.get("http://localhost:8080/api/measurement-units/commodity-forms" , item) ; 
    const options = response.data.map((item , index)  =>({id:index , name : item}))
    setCommodityForms(options);

  }

  const editHandler = async (formData) => {
    try {
      setLoading(true);

      // Send PUT request to update the record
      await axios.put(`http://localhost:8080/api/${master}/${editId}`, {
        commodityFormName: formData.commodityFormName,
        commodityFormCode: formData.commodityFormCode,
        commodityFormLocalName: formData.commodityFormLocalName,
        commodityFormShortName: formData.commodityFormShortName,
        feedBy: formData.feedBy,
        feedDate: formData.feedDate,
        remarks: formData.remarks,
        status: formData.status,
      });

      // Fetch updated data
      const response = await axios.get(`http://localhost:8080/api/${master}`);
      dispatch(setData(response.data));
      setEditId(null);
      setEditedData(null);
      reset();
    } catch (error) {
      console.error("Error updating record:", error);
      setEditId(null);
      setEditedData(null);
    } finally {
      setLoading(false);
    }
  };

  const deleteHandler = async (e, id) => {
    e.preventDefault();
    try {
      setLoading(true);

      // Send DELETE request
      await axios.delete(`http://localhost:8080/api/${master}/delete/${id}`);

      // Fetch updated data
      const response = await axios.get(`http://localhost:8080/api/${master}`);
      dispatch(setData(response.data));
    } catch (error) {
      console.error("Error deleting record:", error);
    } finally {
      setLoading(false);
    }
  };

  return (
    <form onSubmit={handleSubmit(editHandler)} className="w-full overflow-auto">
      <table className="text-sm w-full overflow-auto text-nowrap">
        <thead>
          <tr>
            {headers.map((header, index) => (
              <th key={index}>{header}</th>
            ))}
          </tr>
        </thead>
        <tbody>
          {data.map((item, index) => (
            <tr key={item.id}>
              <td>{index + 1}</td>
              {editId !== item.id ? (
                <>
                  <td>{index+1 < 10 ? "0" + (index+1) : index+1}</td>
                  <td>{item.measurementUnitName}</td>
                  <td>{item.measurementUnitLocalName}</td>
                  <td>{item.measurementUnitShortName}</td>
                  <td>{item.commodityFormName}</td>
                  <td>{item.decimalPrecision}</td>
                  <td>{item.feedBy}</td>
                  <td>{item.feedDate}</td>
                  {/* <td><Select readOnly="true" placeholder="Measurements" readOn options={commodityForms}  onClick={()=>getCommodityForms(item)} /></td> */}
                  <td className='capitalize'>{item.status || 'Inactive'}</td>
                  <td className="flex justify-center gap-3 border-none">
                    {(role === "ROLE_ADMIN" || role === "ROLE_EDITOR") && (
                      <CreateSharpIcon
                        onClick={() => {
                          reset();
                          setEditedData(item);
                          setEditId(item.id);
                        }}
                        className="cursor-pointer"
                      />
                    )}
                    {role === "ROLE_ADMIN" && (
                      <DeleteIcon
                        className="text-red-500 cursor-pointer"
                        onClick={(e) => deleteHandler(e, item.id)}
                      />
                    )}
                    <NorthEastIcon
                      onClick={() => {
                        setSelectedData(item);
                        setIsOpen(true);
                      }}
                    />
                  </td>
                </>
              ) : (
                <>
                  <td>
                    <Input
                      placeholder={item.measurementUnitName || "Measurement Unit Name"}
                      defaultValue={item.measurementUnitName}
                      {...register("measurementUnitName", { required: true })}
                    />
                    <td>
                    <Input
                      placeholder={item.measurementUnitLocalName || "Measurement Unit Local Language"}
                      defaultValue={item.measurementUnitLocalName}
                      {...register("measurementUnitLocalName", { required: true })}
                    />
                  </td>
                    <Input
                      placeholder={item.measurementUnitShortName || "Measurement Unit Short Name"}
                      defaultValue={item.measurementUnitShortName}
                      {...register("measurementUnitShortName", { required: true })}
                    />
                  </td>

                  <td>
                    <Input
                      placeholder={item.commodityFormName || "Commodity Form Name"}
                      defaultValue={item.commodityFormName}
                      {...register("commodityFormName", { required: true })}
                    />
                  </td>
                  <td>
                    <Input
                      placeholder={item.decimalPrecision || "Decimal Precision"}
                      defaultValue={item.decimalPrecision}
                      {...register("decimalPrecision", { required: true })}
                    />
                  </td>
                  <td>
                    <Input
                      placeholder={item.feedBy || "Feed By"}
                      defaultValue={item.feedBy}
                      {...register("feedBy", { required: true })}
                    />
                  </td>
                  <td>
                    <Input
                      placeholder={item.feedDate || "Feed Date"}
                      defaultValue={item.feedDate}
                      {...register("feedDate", { required: true })}
                    />
                  </td>

                  <td className="w-fit">
                    <Select options={[{name:"Active"}, {name:"Inactive"}]} {...register("status")} />
                  </td>
                  <td className="border-none flex gap-4 justify-center items-center mt-2 h-full">
                    <button type="submit" disabled={loading}>
                      {loading ? "Saving..." : <CheckCircleRoundedIcon />}
                    </button>
                    <CloseRoundedIcon
                      onClick={() => {
                        reset();
                        setEditId(null);
                        setEditedData(null);
                      }}
                    />
                  </td>
                </>
              )}
            </tr>
          ))}
        </tbody>
      </table>

      {isOpen && (
        <Modal
          open={isOpen}
          onClose={() => setIsOpen(false)}
          aria-labelledby="modal-title"
          aria-describedby="modal-description"
        >
          <Box
            sx={{
              position: "absolute",
              top: "50%",
              left: "50%",
              transform: "translate(-50%, -50%)",
              boxShadow: 24,
            }}
          >
            <div className="bg-white max-h-[80vh] overflow-auto min-w-[400px] md:min-w-[60vw] md:min-h-[60vh] flex flex-col gap-5 bg-[whitesmoke] rounded-md p-4">
              <h1>Commodity Details</h1>
              <hr />
              <div className="grid grid-cols-[40%_60%]">
                <p className="font-bold">Commodity Form Name</p>
                <p>{selectedData?.commodityFormName}</p>
              </div>
              <div className="grid grid-cols-[40%_60%]">
                <p className="font-bold">Commodity Form Code</p>
                <p>{selectedData?.commodityFormCode}</p>
              </div>
              <div className="grid grid-cols-[40%_60%]">
                <p className="font-bold">Commodity Form Short Name</p>
                <p>{selectedData?.commodityFormShortName}</p>
              </div>
              <div className="grid grid-cols-[40%_60%]">
                <p className="font-bold">Status</p>
                <p>{selectedData?.status || "Inactive"}</p>
              </div>
            </div>
          </Box>
        </Modal>
      )}
    </form>
  );
}

export default MeasurementUnit;
