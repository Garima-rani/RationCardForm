import React, { useEffect, useState } from 'react';
import useAuth from '../../hook/useAuth';
import Select from "../common/Select";
import MastersTable from '../common/MastersTable';
import { useDispatch, useSelector } from 'react-redux';
import axios from 'axios';
import { Modal } from '@mui/material';
import AddNewLanguage from '../modals/AddNewLanguage';
import { setData } from '../../redux/slices/masterSlice';
import { useNavigate } from 'react-router-dom';
import { getTableHeaders } from '../../utils/getTableHeaders';
import CommodityTable from '../tables/CommodityTable';
import StatesTable from '../tables/StatesTable';
import AddNewState from '../modals/AddNewState';
import AddNewCommodity from '../modals/AddNewCommodity';
import AddNewProcurementType from '../modals/AddNewProcurementType';
import AddNewOwnershipType from '../modals/AddNewOwnershipType';
import AddNewCategoryType from '../modals/AddNewCategoryType';
//import AddNewColor from '../modals/AddNewColor'; // Import the new modal for colors
import jsPDF from 'jspdf';
import 'jspdf-autotable';
import * as XLSX from 'xlsx';
import ColorsTable from '../tables/ColorsTable';
import AddNewColors from '../modals/AddNewColors';
import AddNewCommodityForm from '../modals/AddNewCommodityForm';
import CommodityForm from '../tables/CommodityForm';
import ProcurementType from '../tables/ProcurementType';
import OwnershipType from '../tables/OwnershipType';
import CategoryType from "../tables/CategoryType"
import MeasurementUnit from '../tables/MeasurementUnit';
import AddNewMeasurementUnit from '../modals/AddNewMeasurementUnit';
import CropSeasonMaster from '../tables/CropSeasonMaster';
import ModuleMaster from '../tables/ModuleMaster';
import AddNewCropSeason from '../modals/AddNewCropSeason';
import AddNewModule from '../modals/AddNewModule';
import CommodityMaster from '../tables/CommodityMaster';
import AddNewCommodityMaster from '../modals/AddNewCommodityMaster';

const MasterData = () => {
  const { token, role } = useSelector(state => state.auth);
  const navigate = useNavigate();
  const { name: masterName, data: tableData , setData : setTableData } = useSelector(state => state.master);
  const dispatch = useDispatch();
  const [addNew, setAddNew] = useState(false);
  const [headers, setHeaders] = useState([]);
  const [currentPage, setCurrentPage] = useState(1);
  const [rowsPerPage] = useState(10);
  const [paginatedData, setPaginatedData] = useState([]);
  const [downloadFormat, setDownloadFormat] = useState("");
  const [masters, setMasters] = useState([]);

  const truncateText = (text, limit = 32767) => {
    return text.length > limit ? text.substring(0, limit - 3) + '...' : text;
  };



  useEffect(() => {
    const fetchData = async () => {
      if (!masterName) {
        navigate('/');
        return;
      }
      try {
        setHeaders(getTableHeaders(masterName));
        const response = await axios.get(`http://localhost:8080/api/${masterName}`);
        console.log(response.data);
        dispatch(setData(response.data));
      } catch (error) {
        console.error("Error fetching master data:", error);
      }
    };

    fetchData();
  }, [masterName, navigate, dispatch]);

  useEffect(() => {
    if (tableData.length > 0) {
      const indexOfLastRow = currentPage * rowsPerPage;
      const indexOfFirstRow = indexOfLastRow - rowsPerPage;
      setPaginatedData(tableData.slice(indexOfFirstRow, indexOfLastRow));
    }
  }, [currentPage, tableData, rowsPerPage]);

  const totalPages = Math.ceil(tableData.length / rowsPerPage);
  
  const changeHandler = async (e) => {
    const selectedMaster = e.target.value;
    try {
      const response = await axios.get(`http://localhost:8080/api/masters/${selectedMaster}`);
      console.log(response.data);
      dispatch(setData(response.data));
    } catch (error) {
      console.error("Error fetching selected master data:", error);
    }
  };

  const downloadHandler = () => {
    if (downloadFormat === 'PDF') {
      exportToPDF();
    } else if (downloadFormat === 'Excel') {
      exportToExcel();
    } else if (downloadFormat === 'Word') {
      exportToWord();
    }
  };

  const exportToPDF = () => {
    const doc = new jsPDF();
    doc.text('Master Data Table', 14, 16);
    if (!tableData || tableData.length === 0) {
      doc.text('No data available to display', 14, 30);
    } else {
      const dataRows = tableData.map(row => Object.values(row));
      doc.autoTable({
        head: [headers],
        body: dataRows,
        startY: 20,
        theme: 'grid',
      });
    }
    doc.save('master-data-table.pdf');
  };

  const exportToExcel = () => {
    const truncatedData = tableData.map(row => {
      return Object.fromEntries(
        Object.entries(row).map(([key, value]) => {
          return [key, typeof value === 'string' ? truncateText(value) : value];
        })
      );
    });

    const worksheet = XLSX.utils.json_to_sheet(truncatedData);
    const workbook = XLSX.utils.book_new();
    XLSX.utils.book_append_sheet(workbook, worksheet, masterName);
    XLSX.writeFile(workbook, `${masterName}.xlsx`);
  };

  const exportToWord = () => {
    const blob = new Blob([JSON.stringify(tableData, null, 2)], {
      type: "application/msword;charset=utf-8"
    });
    const link = document.createElement("a");
    link.href = URL.createObjectURL(blob);
    link.download = `${masterName}.doc`;
    link.click();
  };

  if (!token) {
    return null; // Or a loading spinner or fallback UI
  }

  return (
    <div className="w-full overflow-auto h-full flex justify-center bg-gray-100">
      <div className="w-full h-full bg-white rounded-lg shadow-lg p-6 flex flex-col gap-5 m-5">
        <h1 className="text-center text-3xl font-semibold text-gray-800 capitalize"> {masterName} Master</h1>

        <div className='flex justify-between items-center gap-10'>
          <Select
            label="Search By Name"
            options={masters.map(master => ({ id: master.id, name: master.name }))}
            className="max-w-2xl"
            onChange={changeHandler}
          />
          {masterName && (
            <button
              className='text-nowrap !h-fit'
              onClick={(e) => { e.preventDefault(); setAddNew(true); }}
            >
              Add New
            </button>
          )}
        </div>

        {masterName && masterName === "languages" && <MastersTable role={role} master={masterName} headers={headers} data={paginatedData} page={currentPage} setTableData={setTableData}/>}
        {masterName && masterName === "commodity-group" && <CommodityTable role={role} master={masterName} headers={headers} data={paginatedData} page={currentPage} />}
        {masterName && masterName === "states" && <StatesTable role={role} master={masterName} headers={headers} data={paginatedData} page={currentPage} />}
        {masterName && masterName === "colors" && <ColorsTable role={role} master={masterName} headers={headers} data={paginatedData} page={currentPage} />} 
        {masterName && masterName === "commodity-forms" && <CommodityForm role={role} master={masterName} headers={headers} data={paginatedData} page={currentPage} />} 
        {masterName && masterName === "procurement-types" && <ProcurementType role={role} master={masterName} headers={headers} data={paginatedData} page={currentPage} />} 
        {masterName && masterName === "ownership-types" && <OwnershipType role={role} master={masterName} headers={headers} data={paginatedData} page={currentPage} />}
        {masterName && masterName === "categories" && <CategoryType role={role} master={masterName} headers={headers} data={paginatedData} page={currentPage} />}
        {masterName && masterName === "measurement-units" && <MeasurementUnit role={role} master={masterName} headers={headers} data={paginatedData} page={currentPage} />}
        {masterName && masterName === "cropseasons" && <CropSeasonMaster role={role} master={masterName} headers={headers} data={paginatedData} page={currentPage} />}
        {masterName && masterName === "modules" && <ModuleMaster role={role} master={masterName} headers={headers} data={paginatedData} page={currentPage} />}
        {masterName && masterName === "commodities" && <CommodityMaster role={role} master={masterName} headers={headers} data={paginatedData} page={currentPage} />}
        
        
        <div className="flex justify-between items-center mt-4">
          <button
            className="px-3 py-1 bg-gray-300 rounded"
            onClick={() => setCurrentPage(prev => Math.max(prev - 1, 1))}
            disabled={currentPage === 1}
          >
            Previous
          </button>
          <span>Page {currentPage} of {totalPages}</span>
          <button
            className="px-3 py-1 bg-gray-300 rounded"
            onClick={() => setCurrentPage(prev => Math.min(prev + 1, totalPages))}
            disabled={currentPage === totalPages}
          >
            Next
          </button>
        </div>

        {/* Dropdown for selecting file format */}
        <div className="flex gap-5 mt-5">
          <select
            className="border p-2 rounded-md"
            value={downloadFormat}
            onChange={(e) => setDownloadFormat(e.target.value)}
          >
            <option value="">Select Format</option>
            <option value="PDF">PDF</option>
            <option value="Excel">Excel</option>
            <option value="Word">Word</option>
          </select>

          <button
            className="bg-blue-500 text-white py-2 px-4 rounded"
            onClick={downloadHandler}
            disabled={!downloadFormat}
          >
            Download
          </button>
        </div>
      </div>

      {/* Modal for adding new items */}
      {masterName && masterName === "languages" && (
        <Modal
          open={addNew}
          onClose={() => setAddNew(false)}
          aria-labelledby="modal-title"
          aria-describedby="modal-description"
        >
          <AddNewLanguage master={masterName} setOpen={setAddNew} />
        </Modal>
      )}

      {masterName && masterName === "states" && (
        <Modal
          open={addNew}
          onClose={() => setAddNew(false)}
          aria-labelledby="modal-title"
          aria-describedby="modal-description"
        >
          <AddNewState master={masterName} setOpen={setAddNew} />
        </Modal>
      )}

      {masterName && masterName === "commodity-group" && (
        <Modal
          open={addNew}
          onClose={() => setAddNew(false)}
          aria-labelledby="modal-title"
          aria-describedby="modal-description"
        >
          <AddNewCommodity master={masterName} setOpen={setAddNew} />
        </Modal>
      )}

      {masterName && masterName === "colors" && (
        <Modal
          open={addNew}
          onClose={() => setAddNew(false)}
          aria-labelledby="modal-title"
          aria-describedby="modal-description"
        >
          <AddNewColors master={masterName} setOpen={setAddNew} />
        </Modal>
      )}

      {masterName && masterName === "commodity-forms" && (
        <Modal
          open={addNew}
          onClose={() => setAddNew(false)}
          aria-labelledby="modal-title"
          aria-describedby="modal-description"
        >
          <AddNewCommodityForm master={masterName} setOpen={setAddNew} />
        </Modal>
      )}
      {masterName && masterName === "procurement-types" && (
        <Modal
          open={addNew}
          onClose={() => setAddNew(false)}
          aria-labelledby="modal-title"
          aria-describedby="modal-description"
        >
          <AddNewProcurementType master={masterName} setOpen={setAddNew} />
        </Modal>
      )}
      {masterName && masterName === "categories" && (
        <Modal
          open={addNew}
          onClose={() => setAddNew(false)}
          aria-labelledby="modal-title"
          aria-describedby="modal-description"
        >
          <AddNewCategoryType master={masterName} setOpen={setAddNew} />
        </Modal>
      )}
      {masterName && masterName === "ownership-types" && (
        <Modal
          open={addNew}
          onClose={() => setAddNew(false)}
          aria-labelledby="modal-title"
          aria-describedby="modal-description"
        >
          <AddNewOwnershipType master={masterName} setOpen={setAddNew} />
        </Modal>
      )}
      {masterName && masterName === "measurement-units" && (
        <Modal
          open={addNew}
          onClose={() => setAddNew(false)}
          aria-labelledby="modal-title"
          aria-describedby="modal-description"
        >
          <AddNewMeasurementUnit master={masterName} setOpen={setAddNew} />
        </Modal>
      )}
      {masterName && masterName === "measurement-units" && (
        <Modal
          open={addNew}
          onClose={() => setAddNew(false)}
          aria-labelledby="modal-title"
          aria-describedby="modal-description"
        >
          <AddNewMeasurementUnit master={masterName} setOpen={setAddNew} />
        </Modal>
      )}
      {masterName && masterName === "cropseasons" && (
        <Modal
          open={addNew}
          onClose={() => setAddNew(false)}
          aria-labelledby="modal-title"
          aria-describedby="modal-description"
        >
          <AddNewCropSeason master={masterName} setOpen={setAddNew} />
        </Modal>
      )}
      {masterName && masterName === "modules" && (
        <Modal
          open={addNew}
          onClose={() => setAddNew(false)}
          aria-labelledby="modal-title"
          aria-describedby="modal-description"
        >
          <AddNewModule master={masterName} setOpen={setAddNew} />
        </Modal>
      )}
      {masterName && masterName === "commodities" && (
        <Modal
          open={addNew}
          onClose={() => setAddNew(false)}
          aria-labelledby="modal-title"
          aria-describedby="modal-description"
        >
          <AddNewCommodityMaster master={masterName} setOpen={setAddNew} />
        </Modal>
      )}

      
      
    </div>
  );
};

export default MasterData;
