function IndianPlayers() {
  const team = ["Sachin", "Dhoni", "Virat", "Rohit", "Yuvraj", "Raina"];
  const [first, second, third, fourth, fifth, sixth] = team;
  const oddPlayers = [
    { position: "First", name: first },
    { position: "Third", name: third },
    { position: "Fifth", name: fifth }
  ];
  const evenPlayers = [
    { position: "Second", name: second },
    { position: "Fourth", name: fourth },
    { position: "Sixth", name: sixth }
  ];
  const t20Players = ["First Player", "Second Player", "Third Player"];
  const ranjiTrophyPlayers = ["Fourth Player", "Fifth Player", "Sixth Player"];
  const allPlayers = [...t20Players, ...ranjiTrophyPlayers];

  return (
    <div>
      <h1>Odd Players</h1>
      {oddPlayers.map((player) => (
        <p key={player.position}>{player.position} : {player.name}</p>
      ))}
      <h1>Even Players</h1>
      {evenPlayers.map((player) => (
        <p key={player.position}>{player.position} : {player.name}</p>
      ))}
      <h1>List of Indian Players Merged:</h1>
      {allPlayers.map((player) => (
        <p key={player}>Mr. {player}</p>
      ))}
    </div>
  );
}

export default IndianPlayers;
