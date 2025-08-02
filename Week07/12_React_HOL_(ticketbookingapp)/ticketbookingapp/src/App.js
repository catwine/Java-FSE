import React, { useState } from 'react';
import GuestPage from './GuestPage';
import UserPage from './UserPage';
import './styles.css';

function App() {
  const [loggedIn, setLoggedIn] = useState(false);

  return (
      <div className="app">
        <nav className="navbar">
          <h1>TicketBookingApp</h1>
          {loggedIn ? (
              <button className="button" onClick={() => setLoggedIn(false)}>
                Logout
              </button>
          ) : (
              <button className="button" onClick={() => setLoggedIn(true)}>
                Login
              </button>
          )}
        </nav>
        {loggedIn ? <UserPage /> : <GuestPage />}
      </div>
  );
}

export default App;
