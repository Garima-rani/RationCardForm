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

function ProcurementType({ setTableData, master, headers = [], data = [], role }) {
  const [editId, setEditId] = useState(null);
  const [editedData, setEditedData] = useState(null);
  const [loading, setLoading] = useState(false);
  const [selectedData, setSelectedData] = useState(null);
  const [isOpen, setIsOpen] = useState(false);
  const { register, handleSubmit, reset } = useForm();
  const dispatch = useDispatch();
    console.log(data) ;
  const editHandler = async (formData) => {
    try {
      setLoading(true);

      // Send PUT request to update the record
      await axios.put(`http://localhost:8080/api/${master}`, {
        name: formData.name,
        remarks: formData.remarks,
        status: formData.status,
        feedBy: formData.feedBy,
        feedDate: formData.feedDate,
       
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
      await axios.delete(`http://localhost:8080/api/${master}/${id}`);

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
      <table className="text-sm w-full text-nowrap">
        <thead>
          <tr>
            {headers.map((header, index) => (
              <th key={index}>{header}</th>
            ))}
          </tr>
        </thead>
        <tbody>
          {data.map((item, index) => (
            <tr key={item?.id || index}>
              <td>{index + 1}</td>
              {editId !== item.id ? (
                <>
                  <td>{item?.id}</td>
                  <td>{item.name}</td>
                  <td>{item.feedBy || '-'}</td>
                  <td>{item.feedDate || '-'}</td>
                  <td>{item.remarks || "-"}</td>

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
                      placeholder={item.name || "Procurement Type Name"}
                      defaultValue={item.name}
                      {...register("name", { required: true })}
                    />
                    <Input
                      placeholder={item.remarks || "Remarks"}
                      defaultValue={item.remarks}
                      {...register("remarks", { required: true })}
                    />
                  </td>
                  <td>
                    <Input
                      placeholder={item.feedBy || "Feed By"}
                      defaultValue={item.feedBy}
                      {...register("feedBy", { required: true })}
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
              <h1>Procurement Details</h1>
              <hr />
              <div className="grid grid-cols-[40%_60%]">
                <p className="font-bold">Procurement Type Name</p>
                <p>{selectedData?.name}</p>
              </div>
              <div className="grid grid-cols-[40%_60%]">
                <p className="font-bold">Remarks</p>
                <p>{selectedData?.remarks}</p>
              </div>
              <div className="grid grid-cols-[40%_60%]">
                <p className="font-bold">Feed By</p>
                <p>{selectedData?.feedBy}</p>
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

export default ProcurementType;
