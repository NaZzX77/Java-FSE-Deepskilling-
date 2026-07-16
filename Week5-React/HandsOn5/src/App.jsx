import CohortDetails from "./components/CohortDetails.jsx";

const cohorts = [
  {
    name: "INTADMDF10 - .NET FSD",
    startedOn: "22-Feb-2022",
    currentStatus: "Scheduled",
    coach: "Apoorv",
    trainer: "Apoorv"
  },
  {
    name: "ADM21JF014 - Java FSD",
    startedOn: "10-Sep-2021",
    currentStatus: "Ongoing",
    coach: "Ramesh",
    trainer: "Ramesh"
  },
  {
    name: "CDBJF21025 - Java FSD",
    startedOn: "24-Dec-2021",
    currentStatus: "Ongoing",
    coach: "Suresh",
    trainer: "Suresh"
  }
];

function App() {
  return (
    <div>
      <h1>Cohorts Details</h1>
      {cohorts.map((cohort) => (
        <CohortDetails key={cohort.name} cohort={cohort} />
      ))}
    </div>
  );
}

export default App;
