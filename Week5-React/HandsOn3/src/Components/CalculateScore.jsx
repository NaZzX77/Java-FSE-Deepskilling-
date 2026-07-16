function CalculateScore(props) {
  const average = props.total / props.goal;

  return (
    <div className="score-card">
      <h1>Student Score Calculator</h1>
      <p>Name: {props.name}</p>
      <p>School: {props.school}</p>
      <p>Total: {props.total}</p>
      <p>Goal: {props.goal}</p>
      <p>Average Score: {average}</p>
    </div>
  );
}

export default CalculateScore;
