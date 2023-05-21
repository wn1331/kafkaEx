import axios from "axios";
import React, {useState} from 'react';

function Example() {
    const [msg, setSelectedMsg] = useState('');

    const handleMsgChange = (event) => {
        setSelectedMsg(event.target.value);
    }

    const exSubmit = async (event) => {
        event.preventDefault();
        try {
            const response = await axios.post('/ex/send', {msg})
            console.log(response);
        } catch (error) {

        }
    }
    return(
        <div>
            <form onSubmit={exSubmit}>
                <input type="text" value={msg} onChange={handleMsgChange}/>
                <button type="submit">메시지 테스트</button>
            </form>
        </div>
    );
};

export default Example;