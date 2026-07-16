const office = {
  name: "DBS",
  rent: 50000,
  address: "Chennai"
};

const officeSpaces = [
  {
    name: "DBS",
    rent: 50000,
    address: "Chennai"
  },
  {
    name: "Regus",
    rent: 65000,
    address: "Bangalore"
  },
  {
    name: "WeWork",
    rent: 75000,
    address: "Hyderabad"
  }
];

function App() {
  return (
    <div>
      <h1>Office Space Rental App</h1>
      <img src="https://images.unsplash.com/photo-1497366754035-f200968a6e72?auto=format&fit=crop&w=900&q=80" alt="Office space" />
      <h2>Name: {office.name}</h2>
      <h3 style={{ color: office.rent < 60000 ? "red" : "green" }}>Rent: Rs. {office.rent}</h3>
      <h3>Address: {office.address}</h3>
      <h2>Available Office Spaces</h2>
      {officeSpaces.map((officeSpace) => (
        <div key={officeSpace.name} className="office-box">
          <h2>Name: {officeSpace.name}</h2>
          <h3 style={{ color: officeSpace.rent < 60000 ? "red" : "green" }}>Rent: Rs. {officeSpace.rent}</h3>
          <h3>Address: {officeSpace.address}</h3>
        </div>
      ))}
    </div>
  );
}

export default App;
