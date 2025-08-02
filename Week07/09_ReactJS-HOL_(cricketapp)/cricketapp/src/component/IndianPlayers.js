import React from 'react';

function IndianPlayers() {
    const T20players = ['Virat', 'Rohit', 'Bumrah', 'Gill'];
    const RanjiTrophy = ['Sundar', 'Shubman', 'Jaiswal'];

    // Destructuring for odd/even team players
    const [odd1, odd2, ...rest] = T20players;
    const [even1, even2, ...r] = RanjiTrophy;

    // Merging arrays using ES6 spread
    const allPlayers = [...T20players, ...RanjiTrophy];

    return (
        <div>
            <h2>Indian Players</h2>
            <p><strong>Odd Team Players:</strong> {odd1}, {odd2}</p>
            <p><strong>Even Team Players:</strong> {even1}, {even2}</p>
            <h3>All Merged Players</h3>
            <ul>
                {allPlayers.map((player, index) => (
                    <li key={index}>{player}</li>
                ))}
            </ul>
        </div>
    );
}

export default IndianPlayers;