import React, { useState, useEffect, useRef } from "react";
import axios from "axios";

import {
  DataGrid,
  GridColDef,
  GridCsvExportOptions,
  GridToolbarExport,
} from "@mui/x-data-grid";
import {
  Button,
  Container,
  Grid,
  Input,
  Stack,
  TextField,
} from "@mui/material"; // Import TextField component
import ExporttoExcel from "./ExporttoExcel";
import { ImportExportOutlined, InfoSharp, Search } from "@mui/icons-material";
import MyComponent from "./ExcelToJson";
import { Link } from "wouter";

const listingpage = () => {
  const [data, setData] = useState<any[]>([]);
  const [searchKeywords, setSearchKeywords] = useState<Record<string, string>>(
    {});
  const [filteredData, setFilteredData] = useState<any[]>([]);
  const [status, setStatus] = useState("New");
  
  const myCols = [
    { field: "vendorCode", headerName: "VendorCode", flex: 1, minWidth: 200 },
    { field: "poNumber", headerName: "PO_Number", flex: 1, minWidth: 200 },
    { field: "materialCode", headerName: "Material_Code", flex: 1, minWidth: 200 },
    { field: "poItem", headerName: "PO_Item", flex: 1, minWidth: 200,},
    { field: "grnNumber", headerName: "GRN Number", flex: 1, minWidth: 200 },
    { field: "grnDate",headerName: "Grn_Date", flex: 1, minWidth: 200,},
    { field: "invoiceNumber", headerName: "S-InvoiceNo", flex: 1, minWidth: 200 },
    { field: "invoiceDate", headerName: "S-Invoice_Date", flex: 1, minWidth: 200 },
    { field: "invoicequantity", headerName: "Invoice_Quantity", flex: 1, minWidth: 200 },
    { field: "basicPrice", headerName: "Basic_Price", flex: 1, minWidth: 200 },
    { field: "gst", headerName: "GST", flex: 1, minWidth: 200 },
    { field: "grandTotal", headerName: "Grand_Total", flex: 1, minWidth: 200 },
    {
 field: "status",
      headerName: "Status",
      flex: 1,
      minWidth: 200,
      
    },
    { field: "Attachment", headerName: "Attachment", flex: 1, minWidth: 200  ,
    renderCell: params => (
      <a href={params.row.Attachment} target="_blank" rel="noopener noreferrer">{params.row.Attachment}</a>
  )},
 
]

  //excel to json
  const [file, setFile] = useState(null);
  const [responseData, setResponseData] = useState([]);
  const [bookStatusAvail,setBookStatusAvail] = useState(false);


  async function fetchData() {
    try {
      const response = await axios.get(
        "http://localhost:8080/api/sendData"
      );
      console.log(response)
      setData(response.data);
      setFilteredData(response.data);

      setResponseData(response.data)
     // Check if BookingStatus is available in the dat
    //  if(localStorage.getItem("bookStatusAvail") === "true"){
    //   setColumns((prev) => {
    //     if (!prev.some(column => column.field === "bookingStatus")) {
    //       return [
    //         ...prev,
    //         {
    //           field: "bookingStatus",
    //           headerName: "Booking Status",
    //           minWidth: 200
    //         }
    //       ];  
    //     }
    //     return prev;
    //   });
      
      }
  catch (error) {
      console.error("Error fetching data:", error);
    }
  }

  useEffect(() => {
    fetchData();

  }, []);
  

  const handleFilterChange = (field: string, value: string) => {
    setSearchKeywords((prev: Record<string, string>) => ({
      ...prev,
      [field]: value,
    }));

    const filteredData = data.filter(
      (
        row: any // Assuming 'row' is of type 'any'
      ) => String(row[field]).toLowerCase().includes(value.toLowerCase())
    );
    filteredData.length === 0
      ? setFilteredData([])
      : setFilteredData(filteredData);
  };

  const handleExcelExport =  async() => {
      try {
        // Export data to Excel
        const excelData = ExporttoExcel(data);
        // Extract invoice numberS
        const invoiceNumbers = data.map((row: any) => row.invoiceNumber);
    console.log("invoiceNumbers", invoiceNumbers);
  
    // Send only invoice numbers to backend
    await axios.post("http://localhost:8080/api/updateStatusPending", invoiceNumbers);
    
  
        // Update status based on invoice number
        setStatus("In Process");
        await fetchData(); 
      } catch (error) {
        console.error("Error exporting to Excel:", error);
      }
    };



  const [columns, setColumns] = useState<GridColDef[]>(myCols);



  
  

  const customCsvOptions = {
    fileName: "SupplimentaryInvoice Data",
    delimiter: ";",
    utf8WithBom: true,
  };

  const exportButtonRef = useRef<HTMLButtonElement | null>(null);

  const handleExportToSap = () => {
    setStatus("In Process");
    if (exportButtonRef.current) {
      exportButtonRef.current.click();
    }
  };



  const onFileChange = async (event:any) => {
    const file = event.target.files[0];
    setFile(file);
  };


  const sendDataToBackend = async () => {
        try {
            if (file) {
                const formData = new FormData();
                formData.append("file", file);
                console.log(file);
                
                const invoiceNumbers = data.map((row: any) => row.invoiceNumber);
                formData.append("invoiceNumbers", JSON.stringify(invoiceNumbers));
                console.log(formData +"heeeeelo")


              const response =await axios.post('http://localhost:8080/api/updateStatusPass',formData)
              localStorage.setItem("bookStatusAvail","true");

          
              setBookStatusAvail(true);
               await fetchData();
        setResponseData(response.data); 
        setStatus("Pass");
                // Handle response if needed
              } else {
                console.error('No file selected.');
              }
          } catch (error) {
            console.error('An error occurred while validating:', error);
          }
        };


  return (
    <Grid>
      <Grid
        sx={{
          display: "flex",
          flexDirection: "row",
          justifyContent: "space-between",
        }}
      >
        <MyComponent data={data}/>
       

        <div>
        <Input
          type="file"
          inputProps={{ accept: ".xls,.xlsx" }}
          onChange={onFileChange}
        />
      </div>

      <div>
        {/* Your component JSX */}
        <button onClick={sendDataToBackend}>Send Data</button>
      </div>

      {/* <pre>{responseData}</pre> */}





        <Stack>
          <Button
            sx={{
              margin: 4,
              display: "flex",
              color: "#ffffff ",
              backgroundColor: "#0964C6!important",
            }}
            variant="outlined"
            startIcon={<InfoSharp />}
          >
            Status = {status}
          </Button>
        </Stack>
        <Stack
          sx={{
            display: "flex",
            flexDirection: "row",
            justifyContent: "space-between",
          }}
        >
          <Button
            onClick={handleExcelExport}
            sx={{ margin: 4, display: "flex", color: "#e8f4f8" }}
            variant="contained"
            startIcon={<ImportExportOutlined />}
          >
            Export To Excel
          </Button>
          <Button
            onClick={() => {
              handleExportToSap();
            }}
            sx={{ margin: 4, display: "flex", justifyContent: "flex-end" }}
            variant="contained"
            startIcon={<ImportExportOutlined />}
          >
            Export To SAP
          </Button>
        </Stack>
      </Grid>
      <div style={{ height: 500, width: "100%", border: "1px solid #ccc" }}>
        <DataGrid
          // disableColumnFilter
          components={{
            Toolbar: () => (
              <div>
                <GridToolbarExport
                  ref={exportButtonRef}
                  csvOptions={customCsvOptions}
                  style={{ display: "none" }}
                />
              </div>
            ),
          }}
          disableColumnMenu
          rowHeight={60}
          getRowId={(row) => row.vendorCode}
          columnHeaderHeight={80}
          columns={columns.map((column) => ({
            ...column,

            renderHeader: (params) => (
              <strong>
                  {params.colDef.headerName}
                  <TextField
                      placeholder="Search"
                      onChange={(e) =>handleFilterChange(column.field, e.target.value)}
                      style={{ width: '85%', display: 'block' }} />
              </strong>
          ),
      }))}
          rows={filteredData.length > 0 ? filteredData : data}
          disableRowSelectionOnClick
          sx={{
            border: "1px solid #EBEFF3",
            "& .MuiDataGrid-columnHeaders": {
              height: "70px",
            },
            "& .MuiDataGrid-columnHeaderTitleContainerContent": {
              width: "inherit",
            },
            "& .MuiDataGrid-columnHeaderTitleContainer": {
              width: "200%",
            },
            "& .MuiDataGrid-cellContent ": {
              whiteSpace: "pre-line",
            },
          }}
          // exportOptions={{ csvOptions: csvExportOptions }}
        />
      </div>
    </Grid>
  );
};

export default listingpage;