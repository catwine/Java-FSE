import React from "react";

const Card = ({ title, subtitle, image, description }) => {
    return (
        <div className="custom-card">
            <div className="card-image-wrapper">
                <img src={image} alt={title} className="custom-image" />
            </div>
            <div className="card-content">
                <h3 className="card-title">{title}</h3>
                <p className="card-subtitle"><strong>{subtitle.label}:</strong> {subtitle.value}</p>
                <p className="card-description">{description}</p>
            </div>
        </div>
    );
};

export default Card;
