function FlightDetails() {
  const flights = [
    { flightName: "Air India", from: "Chennai", to: "Delhi", time: "10:00 AM" },
    { flightName: "Indigo", from: "Mumbai", to: "Bangalore", time: "02:30 PM" },
    { flightName: "SpiceJet", from: "Kolkata", to: "Hyderabad", time: "07:15 PM" }
  ];

  return (
    <div>
      <h2>Flight Details</h2>
      {flights.map((flight) => (
        <div key={flight.flightName} className="flight">
          <h3>{flight.flightName}</h3>
          <p>{flight.from} to {flight.to}</p>
          <p>{flight.time}</p>
        </div>
      ))}
    </div>
  );
}

export default FlightDetails;
