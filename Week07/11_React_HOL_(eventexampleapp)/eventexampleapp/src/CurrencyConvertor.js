import React, { useState } from "react";


const RATE = 90;

export default function CurrencyConvertor() {
    const [rupees, setRupees] = useState("");
    const [euro, setEuro] = useState("");
    const [result, setResult] = useState("");

    // Handle Rs to Euro
    const handleSubmit = (e) => {
        e.preventDefault();
        if (!rupees) return setResult("Please enter a value in Rupees.");
        const euroValue = (parseFloat(rupees) / RATE).toFixed(2);
        setEuro(euroValue);
        setResult(`${rupees} INR = €${euroValue}`);
    };

// Euro to Rupees handler (add setRupees with converted value)
    const handleEuroToRs = () => {
        if (!euro) return setResult("Please enter a value in Euro.");
        const rupeesValue = (parseFloat(euro) * RATE).toFixed(2);
        setRupees(rupeesValue); // <--- update the rupees input field!
        setResult(`€${euro} = ₹${rupeesValue}`);
    };


    return (
        <div style={{ border: "1px solid #888", padding: 18, borderRadius: 8 }}>
            <h3>Currency Convertor</h3>
            <form onSubmit={handleSubmit} style={{ marginBottom: 10 }}>
                <label>
                    Indian Rupees (₹):&nbsp;
                    <input
                        type="number"
                        min="0"
                        value={rupees}
                        onChange={(e) => setRupees(e.target.value)}
                        style={{ width: 100 }}
                        required
                    />
                </label>
                <button type="submit" style={{ marginLeft: 10 }}>
                    Convert to Euro (€)
                </button>
            </form>
            <label>
                Euro (€):&nbsp;
                <input
                    type="number"
                    min="0"
                    value={euro}
                    onChange={(e) => setEuro(e.target.value)}
                    style={{ width: 100 }}
                />
            </label>
            <button type="button" style={{ marginLeft: 10 }} onClick={handleEuroToRs}>
                Convert to Rupees (₹)
            </button>

            {result && <div style={{ marginTop: 18, fontWeight: "bold" }}>{result}</div>}
        </div>
    );
}
