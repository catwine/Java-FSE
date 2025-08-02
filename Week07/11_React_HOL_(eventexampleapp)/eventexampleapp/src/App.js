import React, { useState } from "react";
import CurrencyConvertor from "./CurrencyConvertor";

function App() {
  // Counter state
  const [counter, setCounter] = useState(0);
  // State for show message on "Say Welcome"
  const [welcomeMsg, setWelcomeMsg] = useState("");
  // State for synthetic event message
  const [pressMsg, setPressMsg] = useState("");

  // Multiple methods for Increment
  const handleIncrement = () => {
    increment();
    sayHello();
  };

  const increment = () => setCounter(prev => prev + 1);

  const sayHello = () => {
    alert("Hello! Counter incremented successfully.");
  };

  // Decrement
  const handleDecrement = () => setCounter(prev => prev - 1);

// For Say Welcome button
    const handleWelcome = (greeting) => {
        alert(`${greeting} to the Event Handler Demo!`);
    };

// For OnPress button
    const handleOnPress = (e) => {
        alert("I was clicked");
    };

  return (
      <div style={{ maxWidth: 480, margin: "auto", padding: 24, fontFamily: "sans-serif" }}>
        <h1>Event Examples App</h1>

        {/* Counter Section */}
        <div style={{ marginBottom: 32 }}>
          <h2>Counter: {counter}</h2>
          <button onClick={handleIncrement} style={{ marginRight: 8 }}>
            Increment
          </button>
          <button onClick={handleDecrement}>
            Decrement
          </button>

        </div>

        {/* Say Welcome */}
        <div style={{ marginBottom: 32 }}>
          <button onClick={() => handleWelcome("Welcome")}>
            Say Welcome
          </button>
          {welcomeMsg && (
              <div style={{ marginTop: 10, color: "green" }}>{welcomeMsg}</div>
          )}
        </div>

        {/* Synthetic event OnPress */}
        <div style={{ marginBottom: 32 }}>
          <button onClick={handleOnPress}>
            OnPress
          </button>
          {pressMsg && <div style={{ marginTop: 10, color: "blue" }}>{pressMsg}</div>}
        </div>

        {/* Currency Convertor */}
        <CurrencyConvertor />
      </div>
  );
}

export default App;
