import React from "react";
import Card from "./Card";

const blogs = [
    {
        title: "Understanding React Hooks",
        author: "Jane Doe",
        image: "https://images.unsplash.com/photo-1464983953574-0892a716854b?auto=format&fit=crop&w=600&q=80",
        content: "React Hooks are functions that let you use state and other React features in functional components."
    },
    {
        title: "JavaScript ES6 Features",
        author: "John Appleseed",
        image: "https://images.unsplash.com/photo-1504384308090-c894fdcc538d?auto=format&fit=crop&w=600&q=80",
        content: "Learn about the new features introduced in ES6 that make JavaScript development easier."
    },
    {
        title: "CSS Grid Layout",
        author: "Mary Smith",
        image: "https://images.unsplash.com/photo-1522071820081-009f0129c71c?auto=format&fit=crop&w=600&q=80",
        content: "A guide to building modern web layouts using CSS Grid."
    }
];

const BlogDetails = () => {
    if (blogs.length === 0) {
        return <p>Blog details are not available.</p>;
    }

    return (
        <div>
            <h2>Blog Details</h2>
            <div className="card-container">
                {blogs.map((blog, index) => (
                    <Card
                        key={index}
                        title={blog.title}
                        subtitle={{ label: "Author", value: blog.author }}
                        image={blog.image}
                        description={blog.content}
                    />
                ))}
            </div>
        </div>
    );
};

export default BlogDetails;
