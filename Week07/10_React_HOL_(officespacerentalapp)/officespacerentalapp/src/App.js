import React, { useState } from "react";
import OfficeCard from "./OfficeCard";

// Sample offices
const offices = [
  {
    id: 1,
    name: "Urban Hive",
    rent: 55000,
    address: "123 MG Road, Bengaluru",
    image: "https://images.unsplash.com/photo-1486406146926-c627a92ad1ab?auto=format&fit=crop&w=1050&q=80"
  },
  {
    id: 2,
    name: "The Executive Suite",
    rent: 79000,
    address: "456 Residency Road, Bengaluru",
    image: "https://images.unsplash.com/photo-1524758631624-e2822e304c36?auto=format&fit=crop&w=1050&q=80"
  },
  {
    id: 3,
    name: "Workspace Plus",
    rent: 59000,
    address: "789 Brigade Road, Bengaluru",
    image: "https://images.unsplash.com/photo-1504384308090-c894fdcc538d?auto=format&fit=crop&w=1050&q=80"
  }
];

function App() {
  const [officeList, setOfficeList] = useState(offices);
  const [selectedId, setSelectedId] = useState(offices[0].id);

  const handleFocus = (id) => {
    setSelectedId(id);
    // Move focused item to the first in the list
    setOfficeList(prev => {
      const idx = prev.findIndex(o => o.id === id);
      if (idx === 0) return prev;
      const item = prev[idx];
      const newList = prev.filter((_, i) => i !== idx);
      return [item, ...newList];
    });
  };

  return (
      <div style={{ maxWidth: 700, margin: "auto", padding: 24 }}>
        <h1 style={{ textAlign: "center" }}>Office Space Rental App</h1>
        {officeList.length > 0 && (
            <img
                src={officeList[0].image}
                alt="Featured Office"
                style={{ display: "block", width: "100%", maxHeight: 240, objectFit: "cover", borderRadius: 8, marginBottom: 24 }}
            />
        )}
        <div style={{ display: "flex", flexDirection: "column", gap: 18 }}>
          {officeList.map((office) => (
              <OfficeCard
                  key={office.id}
                  office={office}
                  focused={office.id === selectedId}
                  onClick={() => handleFocus(office.id)}
              />
          ))}
        </div>
      </div>
  );
}

export default App;
