import React from "react";
import Card from "./Card";

const courses = [
    {
        name: "Full Stack Web Development",
        instructor: "John Smith",
        image: "https://images.unsplash.com/photo-1513258496099-48168024aec0?auto=format&fit=crop&w=600&q=80",
        description: "Learn front-end and back-end development with this comprehensive course."
    },
    {
        name: "Data Science Bootcamp",
        instructor: "Emily Johnson",
        image: "https://images.unsplash.com/photo-1666875753105-c63a6f3bdc86?q=80",
        description: "Master data analysis and machine learning techniques."
    },
    {
        name: "Digital Marketing Essentials",
        instructor: "Michael Lee",
        image: "https://images.unsplash.com/photo-1507525428034-b723cf961d3e?auto=format&fit=crop&w=600&q=80",
        description: "Basics of SEO, social media, and online advertising."
    }
];

const CourseDetails = () => {
    if (courses.length === 0) {
        return <p>No course information available.</p>;
    }

    return (
        <div>
            <h2>Course Details</h2>
            <div className="card-container">
                {courses.map((course, index) => (
                    <Card
                        key={index}
                        title={course.name}
                        subtitle={{ label: "Instructor", value: course.instructor }}
                        image={course.image}
                        description={course.description}
                    />
                ))}
            </div>
        </div>
    );
};

export default CourseDetails;
