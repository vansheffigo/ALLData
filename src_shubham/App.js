import React from 'react';
import ReactDOM from 'react-dom/client';
import { BrowserRouter, Routes, Route } from 'react-router-dom';

import Home from './screens/Home';
import RetroBilling from './screens/RetroBilling';
import UploadBill from "./screens/UploadBill";
import './App.css';

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path='/retro' element={<RetroBilling/>}/>
        <Route path='/retro/newbill' element={<UploadBill/>}/>
      </Routes>
    </BrowserRouter>
  );
}

export default App;
