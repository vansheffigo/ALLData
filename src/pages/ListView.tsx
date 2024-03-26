import React, { useState, useEffect, useRef } from "react";
import axios from "axios";
import {
  DataGrid,
  GridCsvExportOptions,
  GridToolbarExport,
} from "@mui/x-data-grid";
import { Button, Container, Grid, Stack, TextField } from "@mui/material"; // Import TextField component
import ExporttoExcel from "./ExporttoExcel";
import { wrap } from "module";
import { ImportExportOutlined, InfoSharp } from "@mui/icons-material";

const listingpage = () => {
  const [data, setData] = useState([]);
  const [searchKeywords, setSearchKeywords] = useState<Record<string, string>>(
    {}
  );
  const [filteredData, setFilteredData] = useState([]);
  const [status, setStatus] = useState("New");

  async function fetchData() {
    try {
      const response = await axios.get(
        "http://localhost:8080/api/sendData"
      );
      setData(response.data);
      setFilteredData(response.data);
    } catch (error) {
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

  const handleExcelExport = () => {
    ExporttoExcel(data);
    setStatus("In Process");
  };

  // const csvExportOptions: GridCsvExportOptions = {
  //   includeColumnGroupsHeaders: true, // Include column headers in the CSV
  //   utf8WithBom: true, // Add UTF-8 BOM character to support non-ASCII characters
  // };

  const columns = [
    { field: "vendorCode", headerName: "VendorCode", flex: 1, minWidth: 200 },
    { field: "poNumber", headerName: "PO_Number", flex: 1, minWidth: 200 },
    { field: "materialCode", headerName: "Material_Code", flex: 1, minWidth: 200 },
    {
      field: "poItem",
      headerName: "PO_Item",
      flex: 1,
      minWidth: 200,
    },
    { field: "grnNumber", headerName: "GRN Number", flex: 1, minWidth: 200 },
    {
      field: "grnDate",
      headerName: "Grn_Date",
      flex: 1,
      minWidth: 200,
    },
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
      Padding: "dense",
    },
  ];

  const customCsvOptions = {
    fileName: "customerDataBase",
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

  return (
    <Grid>
      <Grid
        sx={{
          display: "flex",
          flexDirection: "row",
          justifyContent: "space-between",
        }}
      >
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
          getRowId={(row) => row.vendorCode}
          disableColumnMenu
          rowHeight={60}
          columnHeaderHeight={80}
          columns={columns.map((column) => ({
            ...column,

            renderHeader: (params) => (
              <div
                style={{
                  height: "100%",
                  display: "flex",
                  flexDirection: "column",
                  justifyContent: "center",
                  flexWrap: "wrap",
                  flexGrow: 1,
                }}
              >
                <span style={{ lineHeight: "20px" }}>{column.headerName}</span>
                <TextField
                  style={{
                    width: "98%",
                    marginBottom: 5,
                    lineHeight: "24px",
                  }}
                  size="small"
                  variant="outlined"
                  placeholder={`Search`}
                  value={searchKeywords[column.field] || ""}
                  onChange={(e) =>
                    handleFilterChange(column.field, e.target.value)
                  }
                />{" "}
              </div>
            ),
          }))}
          rows={filteredData}
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
          }}
          // exportOptions={{ csvOptions: csvExportOptions }}
        />
      </div>
    </Grid>
  );
};

export default listingpage;
