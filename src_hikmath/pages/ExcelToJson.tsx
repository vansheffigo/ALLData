import { Input } from "@mui/material";
import axios from "axios";
import React, { useEffect, useState } from "react";
import * as XLSX from "xlsx";


function MyComponent({data}) {

   
    
  const [status, setStatus] = useState("New");


        useEffect(()=>{
            console.log("file is sending")  
        })
  return (
    <>
      
    </>
  );
}

export default MyComponent;