import React, { useState } from 'react';
import FlightList from './FlightList';
import BookFlight from './BookFlight';
import flights from './flightData';

const UserPage = () => {
    const [selectedFlightId, setSelectedFlightId] = useState(null);

    const handleBookClick = (flightId) => {
        setSelectedFlightId(flightId);
    };

    const handleConfirm = (flight) => {
        alert(`Ticket for flight ${flight.from} → ${flight.to} booked successfully!`);
        setSelectedFlightId(null);
    };

    const handleCancel = () => {
        setSelectedFlightId(null);
    };

    const selectedFlight = flights.find(f => f.id === selectedFlightId);

    return (
        <div className="page-container">
            <h2>Welcome, User!</h2>
            <FlightList flights={flights} showBook={true} onBook={handleBookClick} />
            {selectedFlight && (
                <BookFlight flight={selectedFlight} onConfirm={handleConfirm} onCancel={handleCancel} />
            )}
        </div>
    );
};

export default UserPage;
