function OfficeCard({ office, onClick, focused }) {
    return (
        <div
            style={{
                border: focused ? "2px solid #1976D2" : "1px solid #ccc",
                background: focused ? "#E3F2FD" : "#fff",
                padding: 18,
                borderRadius: 8,
                cursor: "pointer"
            }}
            onClick={onClick}
        >
            <h2 style={{ margin: 0 }}>{office.name}</h2>
            <div style={{ color: office.rent < 60000 ? "red" : "green", fontWeight: "bold", margin: "8px 0" }}>
                ₹{office.rent.toLocaleString()}
            </div>
            <div style={{ color: "#666" }}>{office.address}</div>
        </div>
    );
}
export default OfficeCard;
