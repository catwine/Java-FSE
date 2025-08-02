import React from 'react';
import FlightList from './FlightList';
import flights from './flightData';

const GuestPage = () => (
    <div className="page-container">
        <h2>Welcome, Guest!</h2>
        <FlightList flights={flights} />
        <p className="guest-message">Please login to book tickets.</p>
    </div>
);

export default GuestPage;
