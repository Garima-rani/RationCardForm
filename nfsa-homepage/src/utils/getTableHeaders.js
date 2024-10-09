export const getTableHeaders = (name) => {
    if (name === "languages") {
        return ["Sl.No.", "Language Code", "Language", "Short Name", "State", "Status" , "Action"];
    } else if (name === "commodity-group") {
        return ["Sl.No.", "Commodity Group Code", "Commodity Group Name", "Commodity Group Name Local Language", "Commodity Group Short Name", "Feed By", "Feed Date", "Status", "Action"];
    } else if (name === "states") {
        return ["Code", "State Name", "State Name in Local Language", "State Short Name", "State/Union Territory", "Status",  "Action"];
    }
    else if (name === "colors") {
        return ["Sl.No.", "Color Name", "Color Hex Code", "Remarks", "Status",  "Action"];
    }
    else if (name === "commodity-forms") {
        return ["Sl.No.", "Commodity Form Code", "Commodity Form Name","Commodity Form Local Name", "Commodity Form Short Name", "Feed By", "Feed Date", "Remarks", "Status",  "Action"];
    }
    else if (name === "procurement-types") {
        return ["Sl.No.", "Procurement Type Id", "Procurement Type Name", "Feed By", "Feed Date", "Remarks", "Status",  "Action"];
    }
    else if (name === "ownership-types") {
        return ["Sl.No.", "Ownership Type Id", "PDS Application Ownership Type Name", "Feed By", "Feed Date", "Remarks", "Status",  "Action"];
    }
    else if (name === "categories") {
        return ["Sl.No.", "Category Type Id", "Category Of States and UTs", "Feed By", "Feed Date", "Remarks", "Status",  "Action"];
    }
    else if (name === "measurement-units") {
        return ["Sl.No.", "Measurement Unit Code", "Measurement Unit Name", "Measurement Unit Local Language", "Measurement Unit Short Name","Commodity Form" ,"Decimal Precision" ,  "Feed By", "Feed Date", "Status",  "Action"];
    }
    else if (name === "cropseasons") {
        return ["Sl.No.", "Season Code", "Season Name", "Season Name Local Language", "Season Short Name","Major Season Name" ,  "Feed By", "Feed Date", "Status",  "Action"];
    }
    else if (name === "modules") {
        return ["Sl.No.", "Module Id", "Module Name", "Feed By", "Feed Date", "Status", "Remarks" , "Action"];
    }
    else if (name === "commodities") {
        return ["Sl.No.", "Commodity code", "Commodity Name","Commodity Name Local Language" , "Commodity Short Name","Commodity Group","Measurement Unit", "Feed By", "Feed Date", "Status" , "Action"];
    }
    return []; // Return an empty array if no match is found
};
