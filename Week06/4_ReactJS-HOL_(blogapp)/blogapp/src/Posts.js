// src/Posts.js
import React from 'react';
import Post from './Post';

class Posts extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            posts: [],
        };
    }

    loadPosts = async () => {
        try {
            const response = await fetch('https://jsonplaceholder.typicode.com/posts');
            const data = await response.json();
            const postObjects = data.map(
                (p) => new Post(p.id, p.title, p.body)
            );
            this.setState({ posts: postObjects });
        } catch (error) {
            console.error('Error loading posts:', error);
        }
    };

    componentDidMount() {
        this.loadPosts();
    }

    componentDidCatch(error, info) {
        alert('An error occurred in Posts component.');
        console.error("Error caught in component:", error, info);
    }

    render() {
        return (
            <div>
                <h1>Blog Posts</h1>
                {this.state.posts.map((post) => (
                    <div key={post.id}>
                        <h2>{post.title}</h2>
                        <p>{post.body}</p>
                    </div>
                ))}
            </div>
        );
    }
}
export default Posts;
