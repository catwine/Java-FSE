import React, { useState } from "react";
import BookDetails from "./BookDetails";
import BlogDetails from "./BlogDetails";
import CourseDetails from "./CourseDetails";
import "./App.css";

function App() {
  const [activeComponent, setActiveComponent] = useState("book");

  const renderComponent = () => {
    switch (activeComponent) {
      case "book":
        return <BookDetails />;
      case "blog":
        return <BlogDetails />;
      case "course":
        return <CourseDetails />;
      default:
        return <p>Select a category to view details.</p>;
    }
  };

  return (
      <div className="App">
        <h1>Blogger App</h1>
        <div className="nav-buttons">
          <button onClick={() => setActiveComponent("book")}>Book Details</button>
          <button onClick={() => setActiveComponent("blog")}>Blog Details</button>
          <button onClick={() => setActiveComponent("course")}>Course Details</button>
        </div>
        <div className="content">{renderComponent()}</div>
      </div>
  );
}

export default App;
