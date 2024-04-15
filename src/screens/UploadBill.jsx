import React, { useState, useRef, useEffect } from 'react';
import Layout from "../components/Layout";
import '../assets/styles/global.scss';
import { Button, Typography, Box, Input, Container, Alert } from '@mui/material';
import axios from 'axios';
import Snackbar from '@mui/material/Snackbar';
import LinearWithValueLabel from '../components/LinearProgressWithLabel';
import DataTableWithRemarks from '../components/DataTableWithRemarks';


const UploadBill = () => {
  const [exFile, setExFile] = useState([]);
  const [file, setFile] = useState(null);
  const [uploaded, setUploaded] = useState(null);
  const [open, setOpen] = React.useState(false);
  const [showTable, setShowTable] = useState(false); 
  const [responseData, setResponseData] = useState([]);
  const [validationSuccess, setValidationSuccess] = useState(false);


  const allowedExtensions = /(\.xlsx|\.xls)$/i;
  const handleClose = (event, reason) => {
    if (reason === 'clickaway') {
      return;
    }
    setOpen(false);
  };

  const directoryRef = useRef(null);
useEffect(() => {
    if (directoryRef.current !== null) {
        directoryRef.current.setAttribute("directory", "");
        directoryRef.current.setAttribute("webkitdirectory", "");
    }
}, [directoryRef]);
const validateFile = async () => {
  try {

    const cloudName = process.env.REACT_APP_CLOUDINARY_CLOUD_NAME;
    const url = `https://api.cloudinary.com/v1_1/${cloudName}/raw/upload`;

    const formData = new FormData();
    formData.append("file", file);
    // Filter out only .pdf files
    const pdfFiles = Array.from(file).filter(f => f.type === 'application/pdf');
    console.log(pdfFiles);
    // Filter out only .xlsx and .xls files
    const excelFiles = Array.from(file).filter(f => f.type === 'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet' || f.type === 'application/vnd.ms-excel');
    console.log(excelFiles);

    const pdfLinks = [];

    for(let i=0;i<1;i++){
      const formData = new FormData(); 
      formData.append("file", excelFiles[0]);

      const response = await axios.post(`http://localhost:9000/api/localUpload`, formData);
      const uploadedUrl = response.data.link;
      console.log(`Uploaded excel file link:`, uploadedUrl);
      pdfLinks.push(uploadedUrl);
    }

    // Upload PDF files sequentially
    for (let i = 0; i < pdfFiles.length; i++) {
      const formData = new FormData();
      formData.append("file", pdfFiles[i]);

      const response = await axios.post(`http://localhost:9000/api/localUpload`, formData);
      const uploadedUrl = response.data.link;
      console.log(`Uploaded PDF file ${i + 1}:`, uploadedUrl);
      pdfLinks.push(uploadedUrl);
  }

    // const response = await axios.post('/api/validate', formData);
    const dataToSend = {
      pdfLinks: pdfLinks
    };

    console.log(dataToSend);
    const response = await axios.post('http://localhost:8080/api/validate', { "urls": pdfLinks});
    console.log(response);
    setResponseData(response.data);

    setShowTable(true);
    const resp = await axios.get('http://localhost:8080/api/upload');
    console.log(resp.data);
    setValidationSuccess(resp.data);
  } catch (error) {
    console.error('An error occurred while validating:', error);
  }
};

  const onClickingUpload = async (event) => {
    try {
      let cloudName = process.env.REACT_APP_CLOUDINARY_CLOUD_NAME;
      const url = `https://api.cloudinary.com/v1_1/${cloudName}/raw/upload`;
      const formData = new FormData();
      formData.append("file", exFile);
      formData.append("upload_preset", 'excel_preset');
      const response = await axios.post(url, formData, {
        onUploadProgress: (data) => {
          setUploaded(Math.round((data.loaded / data.total) * 100));
          if (Math.round((data.loaded / data.total) * 100) === 100) {
            setTimeout(() => {
              setUploaded(null);
              setOpen(true);
            }, 1000);
          }
          if (open) {
            setTimeout(() => {
              handleClose();
            }, 5000);
          }
        },
      });

      const ret_url = response.data.secure_url;
      console.log(ret_url);
    } catch (error) {
      console.error('An error occurred during upload:', error);
    }
  }

  const onFileChange = async (event) => {
    const files = event.target.files;
    const fileVector = [];

    for(let i=0;i<files.length;i++){
      fileVector.push(files[i]);
    }

    console.log(fileVector);
    setShowTable(false);
    setFile(fileVector);
    setExFile(fileVector[0]);
    console.log(fileVector[0]);
  };



  return (
    <>
      <Layout />
      <Container className="page-content" id="retro-container">
        <Box sx={{ mt: 2, paddingTop: 3, borderRadius: 3 }} bgcolor="#00A8B1" color="background.paper" p={2}>
          <Typography variant="h6" >Retro Billing</Typography>
        </Box>
        <Typography variant="subtitle1">Supplementary invoice upload</Typography>
        <Button color="primary" component="a" href="https://docs.google.com/uc?export=download&id=1zJfHuR2Ok_qsTS5yEOJHyTxT03s_VGjy" sx={{ marginLeft: 0, paddingLeft: 0 }}>
          Click Here to Download Reference Template
        </Button>
        <Box display="flex" alignItems="center" mt={2}>
        <input 
          multiple
          type="file"
          ref={directoryRef}
          onChange={onFileChange}
          />
        </Box>
        {uploaded && <LinearWithValueLabel value={uploaded} />}
        <Snackbar
          open={open}
          autoHideDuration={3000}
          onClose={handleClose}
          anchorOrigin={{
            vertical: 'top',
            horizontal: 'right',
          }}
        ><Alert severity='success'>File Uploaded successfully</Alert></Snackbar>
        <Button id='validate-button' variant="contained" color="primary" onClick={validateFile}>
          Validate
        </Button>
        <Button id='uploadretro-button' onClick={onClickingUpload} variant="contained" color="primary" disabled={!validationSuccess}>
          Upload
        </Button>
      </Container>
      {showTable && <DataTableWithRemarks data={responseData}/>}
    </>
  );
};

export default UploadBill;