import './App.css';
import React from 'react';
import OrderForm from "./components/OrderForm";
import Example from "./components/Example";

function App() {
  return (
      <div>
        <h1>Order</h1>
        <OrderForm/>
          <br />
          <br />
          <br />
          <h1>example</h1>
          <Example/>
      </div>
  );
}


export default App;
