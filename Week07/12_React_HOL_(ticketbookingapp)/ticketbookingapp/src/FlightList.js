import React from 'react';

const FlightList = ({ flights, showBook = false, onBook }) => (
    <div className="flight-list">
        <h3>Available Flights</h3>
        {flights.map(flight => (
            <div key={flight.id} className="flight-item">
                <div>
                    <span role="img" aria-label="airplane" className="flight-logo">✈️</span>
                    {flight.from} → {flight.to} | {flight.time} | {flight.price}
                </div>
                {showBook && (
                    <button className="button" onClick={() => onBook(flight.id)}>
                        Book
                    </button>
                )}
            </div>
        ))}
    </div>
);

export default FlightList;
