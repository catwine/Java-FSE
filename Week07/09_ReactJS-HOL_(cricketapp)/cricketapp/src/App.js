import React from 'react';
import ListOfPlayers from './component/ListofPlayers';
import IndianPlayers from './component/IndianPlayers';

function App() {
  const flag = true; // Toggle switch between components

  return (
      <div className="App">
        <h1>Cricket App</h1>
        {flag ? <ListOfPlayers /> : <IndianPlayers />}
      </div>
  );
}

export default App;