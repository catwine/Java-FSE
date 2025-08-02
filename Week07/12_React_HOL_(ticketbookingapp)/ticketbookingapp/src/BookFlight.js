import React from 'react';

const BookFlight = ({ flight, onConfirm, onCancel }) => {
    if (!flight) return null;

    return (
        <div className="booking-modal">
            <h3>Book Your Flight</h3>
            <p>
                From: {flight.from} <br />
                To: {flight.to} <br />
                Time: {flight.time} <br />
                Price: {flight.price}
            </p>
            <button className="booking-confirm-btn" onClick={() => onConfirm(flight)}>
                Confirm Booking
            </button>
            <button className="booking-cancel-btn" onClick={onCancel}>
                Cancel
            </button>
        </div>
    );
};

export default BookFlight;
