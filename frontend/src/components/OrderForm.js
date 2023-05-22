import React, { useState } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

function OrderForm() {
    const [orderName, setSelectedProduct] = useState('');
    const [count, setQuantity] = useState('');
    const navigate = useNavigate();

    const handleProductChange = (event) => {
        setSelectedProduct(event.target.value);
    };

    const handleQuantityChange = (event) => {
        setQuantity(event.target.value);
    };

    const handleSubmit = async (event) => {
        event.preventDefault();

        try {
            const response = await axios.post('/kafka/send', { orderName, count });
            console.log(response.data);
            const paymentPageUrl = response.data;
            navigate(paymentPageUrl);
        } catch (error) {
            console.error(error);
        }
    };

    return (
        <form onSubmit={handleSubmit}>
            <label>
                주문 상품:
                <select value={orderName} onChange={handleProductChange}>
                    <option value="">상품을 선택하세요</option>
                    <option value="product1">상품 1</option>
                    <option value="product2">상품 2</option>
                    <option value="product3">상품 3</option>
                </select>
            </label>
            <br />
            <label>
                수량:
                <input type="number" value={count} onChange={handleQuantityChange} />
            </label>
            <br />
            <button type="submit">주문하기</button>
        </form>
    );
}

export default OrderForm;
