import React from "react";
import Card from "./Card";

const books = [
    {
        title: "The Great Gatsby",
        author: "F. Scott Fitzgerald",
        image: "https://images.unsplash.com/photo-1512820790803-83ca734da794?auto=format&fit=crop&w=600&q=80",
        description: "A novel set in the Jazz Age, telling the tragic story of Jay Gatsby."
    },
    {
        title: "To Kill a Mockingbird",
        author: "Harper Lee",
        image: "https://images.unsplash.com/photo-1529655683826-aba9b3e77383?auto=format&fit=crop&w=600&q=80",
        description: "A novel about racial injustice in the Deep South."
    },
    {
        title: "1984",
        author: "George Orwell",
        image: "https://images.unsplash.com/photo-1524995997946-a1c2e315a42f?auto=format&fit=crop&w=600&q=80",
        description: "A dystopian novel on totalitarian regime and surveillance."
    }
];

const BookDetails = () => {
    if (books.length === 0) {
        return <p>No book info available.</p>;
    }

    return (
        <div>
            <h2>Book Details</h2>
            <div className="card-container">
                {books.map((book, index) => (
                    <Card
                        key={index}
                        title={book.title}
                        subtitle={{ label: "Author", value: book.author }}
                        image={book.image}
                        description={book.description}
                    />
                ))}
            </div>
        </div>
    );
};

export default BookDetails;
