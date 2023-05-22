import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import OrderForm from './components/OrderForm';
import PurchaseForm from './components/PurchaseForm';

function App() {
    return (
        <Router>
            <Routes>
                <Route path="/" element={<OrderForm />} />
                <Route path="/payment" element={<PurchaseForm />} />
            </Routes>
        </Router>
    );
}

export default App;
