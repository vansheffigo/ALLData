import * as React from 'react';
import { DataGrid } from '@mui/x-data-grid';
import axios from 'axios';
import saveAs from 'file-saver';
import * as XLSX from 'xlsx';
import { Link } from 'react-router-dom';
import { Button, TextField } from '@mui/material';


const columns = [
    { field: 'vendorCode', headerName: 'Vendor Code', width: 117 },
    { field: 'poNumber', headerName: 'PO NO', width: 97 },
    { field: 'materialCode', headerName: 'MATERIAL CODE', width: 160 },
    { field: 'poItem', headerName: 'QTY', width: 97 },
    { field: 'grnNumber', headerName: 'GRN NO', width: 103 },
    { field: 'grnDate', headerName: 'GRN DATE', width: 117 },
    { field: 'invoiceNumber', headerName: 'Supplimentry Inv No. /DEBIT/ RD INV. NO.', width: 160 },
    { field: 'invoiceDate', headerName: 'S-Inv DATE', width: 117 },
    { field: 'invoicequantity', headerName: 'Invoice Quantity', width: 160},
    { field: 'basicPrice', headerName: 'BASIC Amt.', width: 121 },
    { field: 'gst', headerName: 'GST %', width: 103 },
    { field: 'grandTotal', headerName: 'GRAND TOTAL', width: 145 },
    { field: 'Remarks', headerName: 'Remarks', width: 105 },
    { field: 'Attachment', headerName: 'Attachment', width: 105,
        renderCell: params => (
            <a href={params.row.Attachment} target="_blank" rel="noopener noreferrer">{params.row.Attachment}</a>
        )
    }
];



const DataTableWithRemarks = ({data}) => {
    const [rows, setRows] = React.useState([]);
    const [emptyRows, setEmptyRows] = React.useState([]);
    const [searched, setSearched] = React.useState(false);
    const [filteredRows, setFilteredRows] = React.useState([]);

    const handleFilterChange = (field, value) => {
        const keyword = value.toLowerCase();
        const filteredData = rows.filter((row) => {
          const textValue = row[field]?.toString()?.toLowerCase() || '';
          return textValue.includes(keyword);
        });
        setFilteredRows(filteredData);
        setSearched(true);
        if (value='') {
            setSearched(false);
        }
      };

    const exportToExcel = () => {
        const worksheet = XLSX.utils.json_to_sheet(rows);
        const workbook = XLSX.utils.book_new();
        XLSX.utils.book_append_sheet(workbook, worksheet, "Sheet1");
        const excelBuffer = XLSX.write(workbook, { bookType: 'xlsx', type: 'array' });
        const data = new Blob([excelBuffer], { type: 'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=UTF-8' });
        saveAs(data, 'DataTable.xlsx');
    };

    React.useEffect(() => {
        const fetchData = async () => {
            try {
                // const response = await axios.get('http://localhost:8080/api/data');
             
                setRows(data); // Assuming your API returns an array of objects
            } catch (error) {
                console.error('Error fetching data:', error);
            }
        };

        fetchData();
    }, []);

    return (
        <>
        <div style={{width:'65%',margin:'auto'}}>
            <Button variant="contained" color="primary"  style={{marginBottom:'10px'}} onClick={exportToExcel}>
                Export to Excel
            </Button>
            <DataGrid
                rows={searched?(filteredRows.length > 0 ? filteredRows : emptyRows):(rows)}
                columns={columns.map((column) => ({
                    ...column,
                    // sortable: false, // Assuming you want to disable sorting too 
                    disableColumnMenu: true,
                    renderHeader: (params) => (
                        <strong>
                            {params.colDef.headerName}
                            <TextField
                            style={{
                                width:"98%",
                                marginBottom: 5,
                                lineHeight:"24px",
                            }}
                            size="small"
                            variant="outlined"
                            placeholder={`Search`}
                            onChange={(e) =>handleFilterChange(column.field, e.target.value)}
                            style={{ width: '85%', display: 'block' }} />
                        </strong>
                    ),
                }))}
                pageSize={10}
                rowsPerPageOptions={[5, 10, 20]}
                getRowId={(row) => row.vendorCode}
                style={{height: 400, width: '100%', margin: 'auto', marginTop: '20',  border:'2px solid black', borderRadius:'5px', marginBottom:'30px'}}
            />
        </div>
        </>
    );
};
export default DataTableWithRemarks;