// import React, { useState } from 'react';
// import axios from 'axios';
// import DeleteIcon from "@mui/icons-material/Delete";
// import CreateSharpIcon from "@mui/icons-material/CreateSharp";
// import NorthEastIcon from "@mui/icons-material/NorthEast";
// import CheckCircleRoundedIcon from "@mui/icons-material/CheckCircleRounded";
// import CloseRoundedIcon from "@mui/icons-material/CloseRounded";
// import { useForm } from "react-hook-form";
// import { Box, Modal } from '@mui/material';
// import Input from '../common/Input';
// import Select from '../common/Select';

// const StatesTable = ({ setTableData, master, headers = [], data = [], role , page }) => {
//     const [editId, setEditId] = useState(null);
//     const [editedData, setEditedData] = useState(null);
//     const [loading, setLoading] = useState(false);
//     const [selectedData, setSelectedData] = useState(null);
//     const [isOpen, setIsOpen] = useState(false);
//     const { register, handleSubmit, reset } = useForm();

//     // Edit Handler
//     const editHandler = async (formData) => {
//         try {
//             setLoading(true);
//             // PUT request to update state
//             await axios.put(`http://localhost:8080/api/${master}/${editId}`, {
//                 stateName: formData.stateName,
//                 localName: formData.localName,
//                 shortName: formData.shortName,
//                 status: formData.status,
//                 stateUnionTerritory: editedData.stateUnionTerritory,
//                 feedBy:editedData.feedBy
//             });
//             // Fetch updated data
//             const response = await axios.get(`http://localhost:8080/api/${master}/full`);
//             setTableData(response.data);
//             setEditId(null);
//             setEditedData(null);
//             reset();
//         } catch (error) {
//             console.error("Error updating state:", error);
//         } finally {
//             setLoading(false);
//         }
//     };

//     // Delete Handler
//     const deleteHandler = async (e, id) => {
//         e.preventDefault();
//         if (window.confirm("Are you sure you want to delete this state?")) {
//             try {
//                 setLoading(true);
//                 // DELETE request
//                 await axios.delete(`http://localhost:8080/api/${master}/${id}`);
//                 // Fetch updated data
//                 const response = await axios.get(`http://localhost:8080/api/${master}/full`);
//                 setTableData(response.data);
//             } catch (error) {
//                 console.error("Error deleting state:", error);
//             } finally {
//                 setLoading(false);
//             }
//         }
//     };

//     const renderStates = () => {
//         return data.map((state, index) => (
//             <React.Fragment key={state.id}>
//                 <tr>
//                     <td>{( (page-1)*10 )+index + 1}</td>
//                     <td>{state.stateCode}</td>
//                     <td>{state.stateName}</td>
//                     <td>{state.localName}</td>
//                     <td>{state.shortName}</td>
//                     <td>{state.stateUnionTerritory}</td>
//                     <td>{state.status}</td>
//                     <td className="flex justify-center gap-3 border-none">
//                         {(role === "ROLE_ADMIN" || role === "ROLE_EDITOR") && (
//                             <CreateSharpIcon
//                                 onClick={() => {
//                                     reset();
//                                     setEditedData(state);
//                                     setEditId(state.id);
//                                 }}
//                                 className="cursor-pointer"
//                             />
//                         )}
//                         {role === "ROLE_ADMIN" && (
//                             <DeleteIcon
//                                 className="text-red-500 cursor-pointer"
//                                 onClick={(e) => deleteHandler(e, state.id)}
//                             />
//                         )}
//                         <NorthEastIcon
//                             onClick={() => {
//                                 setSelectedData(state);
//                                 setIsOpen(true);
//                             }}
//                         />
//                     </td>
//                 </tr>
//                 {editId === state.id && (
//                     <tr>
//                         <td colSpan={headers.length}>
//                             <div className="bg-gray-100 p-4 rounded-md mt-2">
//                                 <h3>Edit State</h3>
//                                 <Input
//                                     placeholder="State Name"
//                                     defaultValue={editedData?.stateName}
//                                     {...register("stateName", { required: true })}
//                                 />
//                                 <Input
//                                     placeholder="Local Name"
//                                     defaultValue={editedData?.localName}
//                                     {...register("localName")}
//                                 />
//                                 <Input
//                                     placeholder="Short Name"
//                                     defaultValue={editedData?.shortName}
//                                     {...register("shortName")}
//                                 />
//                                 <Select
//                                     options={[{ name: "Active" }, { name: "Inactive" }]}
//                                     defaultValue={editedData?.status}
//                                     {...register("status")}
//                                 />
//                                 <button type="submit" onClick={handleSubmit(editHandler)} disabled={loading}>
//                                     {loading ? "Saving..." : <CheckCircleRoundedIcon />}
//                                 </button>
//                                 <CloseRoundedIcon
//                                     onClick={() => {
//                                         reset();
//                                         setEditId(null);
//                                         setEditedData(null);
//                                     }}
//                                     className="cursor-pointer"
//                                 />
//                             </div>
//                         </td>
//                     </tr>
//                 )}
//             </React.Fragment>
//         ));
//     };

//     return (
//         <form className="w-full h-full ">
//             <h2>States Table</h2>
//             {loading && <p>Loading...</p>}
//             {!loading && (
//                 <table className='h-full w-full'>
//                     <thead>
//                         <tr>
//                             <th>Si.No</th>
//                             <th>Code</th>
//                             <th>State Name</th>
//                             <th>State Name in Local Language</th>
//                             <th>Short Name</th>
//                             <th>State/Union Territory</th>
//                             <th>Status</th>
//                             <th>Action</th>
//                         </tr>
//                     </thead>
//                     <tbody>
//                         {renderStates()}
//                     </tbody>
//                 </table>
//             )}
            
//             {isOpen && (
//                 <Modal
//                     open={isOpen}
//                     onClose={() => setIsOpen(false)}
//                     aria-labelledby="modal-title"
//                     aria-describedby="modal-description"
//                 >
//                     <Box
//                         sx={{
//                             position: "absolute",
//                             top: "50%",
//                             left: "50%",
//                             transform: "translate(-50%, -50%)",
//                             boxShadow: 24,
//                             maxHeight: "80vh",
//                             overflow: "auto",
//                         }}
//                     >
//                               <div className="bg-white max-h-[80vh] overflow-auto  min-w-[400px] md:min-w-[60vw]  md:min-h-[60vh] flex flex-col hide-scrollbar gap-5 bg-[whitesmoke] relative rounded-md p-4 flex flex-col gap-2 w-full max-w-lg">
//                             <h1>State Details</h1>
//                             <CloseRoundedIcon
//                                 onClick={() => setIsOpen(false)}
//                                 className="absolute top-2 right-2 cursor-pointer"
//                             />
//                             <hr className="my-2" />
//                             <div className="border-b border-blue-500 mb-4" />
//                             <div className="grid grid-cols-[40%_60%] gap-2 mb-2">
//                                 <p className="font-bold">Code:</p>
//                                 <p>{selectedData?.stateCode}</p>
//                             </div>
//                             <div className="grid grid-cols-[40%_60%] gap-2 mb-2">
//                                 <p className="font-bold">State Name:</p>
//                                 <p>{selectedData?.stateName}</p>
//                             </div>
//                             <div className="grid grid-cols-[40%_60%] gap-2 mb-2">
//                                 <p className="font-bold">State Name in Local Language:</p>
//                                 <p>{selectedData?.localName}</p>
//                             </div>
//                             <div className="grid grid-cols-[40%_60%] gap-2 mb-2">
//                                 <p className="font-bold">State Short Name:</p>
//                                 <p>{selectedData?.shortName}</p>
//                             </div>
//                             <div className="grid grid-cols-[40%_60%] gap-2 mb-2">
//                                 <p className="font-bold">State/Union Territory:</p>
//                                 <p>{selectedData?.stateUnionTerritory}</p>
//                             </div>
//                             <div className="grid grid-cols-[40%_60%] gap-2 mb-2">
//                                 <p className="font-bold">DBT:</p>
//                                 <p>{selectedData?.dbt}</p>
//                             </div>
//                             <div className="grid grid-cols-[40%_60%] gap-2 mb-2">
//                                 <p className="font-bold">Central PGRMS State:</p>
//                                 <p>{selectedData?.centralProgramsStat}</p>
//                             </div>
//                             <div className="grid grid-cols-[40%_60%] gap-2 mb-2">
//                                 <p className="font-bold">Available On Mobile App:</p>
//                                 <p>{selectedData?.availableOnMobileApp}</p>
//                             </div>
//                             <div className="grid grid-cols-[40%_60%] gap-2 mb-2">
//                                 <p className="font-bold">RCMS Hosted on NFSA Portal:</p>
//                                 <p>{selectedData?.rcmsHostedOnNfsaPortal}</p>
//                             </div>
//                             <div className="grid grid-cols-[40%_60%] gap-2 mb-2">
//                                 <p className="font-bold">Common Registration Facility for RC Available:</p>
//                                 <p>{selectedData?.commonRegistrationFacility}</p>
//                             </div>
//                             <div className="grid grid-cols-[40%_60%] gap-2 mb-2">
//                                 <p className="font-bold">Status:</p>
//                                 <p>{selectedData?.status}</p>
//                             </div>
//                         </div>
//                     </Box>
//                 </Modal>
//             )}
//         </form>
//     );
// };

// export default StatesTable;
import React, { useState } from 'react';
import axios from 'axios';
import DeleteIcon from "@mui/icons-material/Delete";
import CreateSharpIcon from "@mui/icons-material/CreateSharp";
import NorthEastIcon from "@mui/icons-material/NorthEast";
import CheckCircleRoundedIcon from "@mui/icons-material/CheckCircleRounded";
import CloseRoundedIcon from "@mui/icons-material/CloseRounded";
import { useForm } from "react-hook-form";
import { Box, Modal } from '@mui/material';
import Input from '../common/Input';
import Select from '../common/Select';

const StatesTable = ({ setTableData, master, headers = [], data = [], role, page }) => {
    const [editId, setEditId] = useState(null);
    const [editedData, setEditedData] = useState(null);
    const [loading, setLoading] = useState(false);
    const [selectedData, setSelectedData] = useState(null);
    const [isOpen, setIsOpen] = useState(false);
    const { register, handleSubmit, reset } = useForm();

    const editHandler = async (formData) => {
        setLoading(true);
        try {
            await axios.put(`http://localhost:8080/api/${master}/${editId}`, {
                stateName: formData.stateName,
                localName: formData.localName,
                shortName: formData.shortName,
                status: formData.status,
                stateUnionTerritory: editedData.stateUnionTerritory,
                feedBy: editedData.feedBy,
            });
            const response = await axios.get(`http://localhost:8080/api/${master}/full`);
            setTableData(response.data);
            reset();
        } catch (error) {
            console.error("Error updating state:", error);
        } finally {
            setLoading(false);
            setEditId(null);
            setEditedData(null);
        }
    };

    const deleteHandler = async (e, id) => {
        e.preventDefault();
        if (window.confirm("Are you sure you want to delete this state?")) {
            setLoading(true);
            try {
                await axios.delete(`http://localhost:8080/api/${master}/${id}`);
                const response = await axios.get(`http://localhost:8080/api/${master}/full`);
                setTableData(response.data);
            } catch (error) {
                console.error("Error deleting state:", error);
            } finally {
                setLoading(false);
            }
        }
    };

    const renderStates = () => {
        if (!Array.isArray(data)) {
            return <tr><td colSpan={headers.length}>No data available</td></tr>;
        }
        return data.map((state, index) => (
            <React.Fragment key={state.id}>
                <tr>
                    <td>{((page - 1) * 10) + index + 1}</td>
                    <td>{state.stateCode}</td>
                    <td>{state.stateName}</td>
                    <td>{state.localName}</td>
                    <td>{state.shortName}</td>
                    <td>{state.stateUnionTerritory}</td>
                    <td>{state.status}</td>
                    <td className="flex justify-center gap-3 border-none">
                        {(role === "ROLE_ADMIN" || role === "ROLE_EDITOR") && (
                            <CreateSharpIcon
                                onClick={() => {
                                    reset();
                                    setEditedData(state);
                                    setEditId(state.id);
                                }}
                                className="cursor-pointer"
                            />
                        )}
                        {role === "ROLE_ADMIN" && (
                            <DeleteIcon
                                className="text-red-500 cursor-pointer"
                                onClick={(e) => deleteHandler(e, state.id)}
                            />
                        )}
                        <NorthEastIcon
                            onClick={() => {
                                setSelectedData(state);
                                setIsOpen(true);
                            }}
                        />
                    </td>
                </tr>
                {editId === state.id && (
                    <tr>
                        <td colSpan={headers.length}>
                            <div className="bg-gray-100 p-4 rounded-md mt-2">
                                <h3>Edit State</h3>
                                <Input
                                    placeholder="State Name"
                                    defaultValue={editedData?.stateName}
                                    {...register("stateName", { required: true })}
                                />
                                <Input
                                    placeholder="Local Name"
                                    defaultValue={editedData?.localName}
                                    {...register("localName")}
                                />
                                <Input
                                    placeholder="Short Name"
                                    defaultValue={editedData?.shortName}
                                    {...register("shortName")}
                                />
                                <Select
                                    options={[{ name: "Active" }, { name: "Inactive" }]}
                                    defaultValue={editedData?.status}
                                    {...register("status")}
                                />
                                <button type="button" onClick={handleSubmit(editHandler)} disabled={loading}>
                                    {loading ? "Saving..." : <CheckCircleRoundedIcon />}
                                </button>
                                <CloseRoundedIcon
                                    onClick={() => {
                                        reset();
                                        setEditId(null);
                                        setEditedData(null);
                                    }}
                                    className="cursor-pointer"
                                />
                            </div>
                        </td>
                    </tr>
                )}
            </React.Fragment>
        ));
    };

    return (
        <form className="w-full h-full ">
            <h2>States Table</h2>
            {loading && <p>Loading...</p>}
            <table className='h-full w-full'>
                <thead>
                    <tr>
                        <th>Si.No</th>
                        <th>Code</th>
                        <th>State Name</th>
                        <th>Local Name</th>
                        <th>Short Name</th>
                        <th>State/Union Territory</th>
                        <th>Status</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    {renderStates()}
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
                            maxHeight: "80vh",
                            overflow: "auto",
                        }}
                    >
                        <div className="bg-white max-h-[80vh] overflow-auto min-w-[400px] md:min-w-[60vw] md:min-h-[60vh] flex flex-col hide-scrollbar gap-5 bg-[whitesmoke] relative rounded-md p-4 flex flex-col gap-2 w-full max-w-lg">
                            <h1>State Details</h1>
                            <CloseRoundedIcon
                                onClick={() => setIsOpen(false)}
                                className="absolute top-2 right-2 cursor-pointer"
                            />
                            <hr className="my-2" />
                            <div className="grid grid-cols-[40%_60%] gap-2 mb-2">
                                <p className="font-bold">Code:</p>
                                <p>{selectedData?.stateCode}</p>
                            </div>
                            <div className="grid grid-cols-[40%_60%] gap-2 mb-2">
                                <p className="font-bold">State Name:</p>
                                <p>{selectedData?.stateName}</p>
                            </div>
                            <div className="grid grid-cols-[40%_60%] gap-2 mb-2">
                                <p className="font-bold">Local Name:</p>
                                <p>{selectedData?.localName}</p>
                            </div>
                            <div className="grid grid-cols-[40%_60%] gap-2 mb-2">
                                <p className="font-bold">Short Name:</p>
                                <p>{selectedData?.shortName}</p>
                            </div>
                            <div className="grid grid-cols-[40%_60%] gap-2 mb-2">
                                <p className="font-bold">State/Union Territory:</p>
                                <p>{selectedData?.stateUnionTerritory}</p>
                            </div>
                            <div className="grid grid-cols-[40%_60%] gap-2 mb-2">
                                <p className="font-bold">Status:</p>
                                <p>{selectedData?.status}</p>
                            </div>
                        </div>
                    </Box>
                </Modal>
            )}
        </form>
    );
};

// const AddNewState = ({ setTableData, master }) => {
//     const { register, handleSubmit, reset } = useForm();
//     const [loading, setLoading] = useState(false);

//     const onSubmit = async (formData) => {
//         setLoading(true);
//         try {
//             await axios.post(`http://localhost:8080/api/${master}`, {
//                 stateName: formData.stateName,
//                 localName: formData.localName,
//                 shortName: formData.shortName,
//                 status: formData.status,
//             });
//             const response = await axios.get(`http://localhost:8080/api/${master}/full`);
//             setTableData(response.data);
//             reset();
//         } catch (error) {
//             console.error("Error adding state:", error);
//         } finally {
//             setLoading(false);
//         }
//     };

//     return (
//         <form onSubmit={handleSubmit(onSubmit)} className="my-4">
//             <h3>Add New State</h3>
//             <Input placeholder="State Name" {...register("stateName", { required: true })} />
//             <Input placeholder="Local Name" {...register("localName")} />
//             <Input placeholder="Short Name" {...register("shortName")} />
//             <Select options={[{ name: "Active" }, { name: "Inactive" }]} {...register("status")} />
//             <button type="submit" disabled={loading}>
//                 {loading ? "Adding..." : "Add State"}
//             </button>
//         </form>
//     );
// };

export default StatesTable;

