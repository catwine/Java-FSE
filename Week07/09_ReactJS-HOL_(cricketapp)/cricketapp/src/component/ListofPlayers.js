import React from 'react';

const players = [
    { name: 'Virat Kohli', score: 82 },
    { name: 'Rohit Sharma', score: 45 },
    { name: 'KL Rahul', score: 90 },
    { name: 'Shreyas Iyer', score: 67 },
    { name: 'Hardik Pandya', score: 30 },
    { name: 'Jadeja', score: 55 },
    { name: 'Bumrah', score: 76 },
    { name: 'Chahal', score: 69 },
    { name: 'Gill', score: 91 },
    { name: 'Pant', score: 65 },
    { name: 'Siraj', score: 72 }
];


const ListOfPlayers = () => {
    const lowScore = players.filter(player => player.score < 70);

    return (
        <div>
            <h2>List of Players</h2>
            <ul>
                {players.map((player, i) => (
                    <li key={i}>Mr. {player.name} {player.score}</li>
                ))}
            </ul>

            <h2>List of Players having Scores Less than 70</h2>
            <ul>
                {lowScore.map((player, i) => (
                    <li key={i}>Mr. {player.name} {player.score}</li>
                ))}
            </ul>
        </div>
    );
};

export default ListOfPlayers;