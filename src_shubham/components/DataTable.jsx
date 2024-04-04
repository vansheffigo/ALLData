import * as React from 'react';
import "../assets/styles/global.scss";
import { DataGrid } from '@mui/x-data-grid';
import Button from '@mui/material/Button';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';

const columns = [

    { field: 'invoiceNumber', headerName: ' S- Invoice No', width: 150 },
    { field: 'invoiceDate', headerName: 'S-Invoice Date', width:150},
    { field: 'invoiceAmount', headerName: 'Invoice Amount', width:150},
    { field: 'vendorCode', headerName: 'Vendor Code', width: 150 },
    { field: 'poId', headerName: 'PO No', width: 120 },
    { field: 'materialCode', headerName: 'Material Code', width: 150 },
    { field: 'quantity', headerName: 'No of Items', width: 150 },
    { field: 'price', headerName: 'Price', width: 100 },
    { field: 'gst', headerName: 'GST', width: 100, 
    renderCell: params => (
        <p>{params.row.gst+'%'}</p>
    )
    },
    { field: 'grnNumber', headerName: 'GRN Number', width: 150 },
    { field: 'grnDate', headerName: 'GRN Date', width: 150 },
    { field: 'bookingStatus', headerName: 'Booking Status', width: 120 },
];


function DataTable() {
    const [rows, setRows] = React.useState([]);
    const [emptyRows, setEmptyRows] = React.useState([]);
    const [searched, setSearched] = React.useState(false);
    const navigate = useNavigate();
    const [filteredRows, setFilteredRows] = React.useState([]);
    const handleNewButtonClick = () => {
        navigate('/retro/newbill');
    };

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
    

    React.useEffect(() => {
        const fetchData = async () => {
            try {
                const response = await axios.get('http://localhost:8080/api/fetchAllData');
                console.log(response);
                setRows(response.data); // Assuming your API returns an array of objects
            } catch (error) {
                console.error('Error fetching data:', error);
            }
        };

        fetchData();
    }, []);

    return (
        <div id="data-table">
            <Button id='newbill-button' variant="contained" onClick={handleNewButtonClick}>New</Button>
            <DataGrid
                rows={searched?(filteredRows.length > 0 ? filteredRows : emptyRows):(rows)}
                columns={columns.map((column) => ({
                    ...column,
                    // sortable: false, // Assuming you want to disable sorting too 
                    // disableColumnMenu: true,
                    renderHeader: (params) => (
                        <strong>
                            {params.colDef.headerName}
                            <input
                                type="text"
                                placeholder="Search"
                                onChange={(e) =>handleFilterChange(column.field, e.target.value)}
                                style={{ width: '85%', display: 'block' }} />
                        </strong>
                    ),
                }))}
                getRowId={(row) => row.vendorCode}
                style={{ border: '2px solid black', borderRadius: '5px' }}
            />
        </div>
    );
}

export default DataTable;
