import React from 'react'
import '../assets/styles/global.scss'; 
 import Layout from '../components/Layout'
import DataTable from '../components/DataTable'
const RetroBilling = () => {
  return (
    <>
        <Layout/>
        <div className="page-content" id='table-container'>
            {<DataTable/>}
        </div>
    </>
  )
}

export default RetroBilling