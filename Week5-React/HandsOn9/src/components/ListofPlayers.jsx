function ListofPlayers() {
  const players = [
    { name: "Sachin", score: 95 },
    { name: "Dravid", score: 82 },
    { name: "Ganguly", score: 68 },
    { name: "Sehwag", score: 75 },
    { name: "Yuvraj", score: 60 },
    { name: "Dhoni", score: 90 },
    { name: "Kohli", score: 99 },
    { name: "Rohit", score: 88 },
    { name: "Raina", score: 64 },
    { name: "Jadeja", score: 72 },
    { name: "Bumrah", score: 55 }
  ];

  const lowScoringPlayers = players.filter((player) => player.score < 70);

  return (
    <div>
      <h1>List of Players</h1>
      {players.map((player) => (
        <p key={player.name}>Mr. {player.name} <span>{player.score}</span></p>
      ))}
      <h1>List of Players having Scores Less than 70</h1>
      {lowScoringPlayers.map((player) => (
        <p key={player.name}>Mr. {player.name} <span>{player.score}</span></p>
      ))}
    </div>
  );
}

export default ListofPlayers;
