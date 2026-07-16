import { useState } from "react";

function CurrencyConvertor() {
  const [rupees, setRupees] = useState("");
  const [euro, setEuro] = useState("");

  function handleSubmit(event) {
    event.preventDefault();
    setEuro(Number(rupees) / 90);
  }

  return (
    <div>
      <h1>Currency Convertor</h1>
      <form onSubmit={handleSubmit}>
        <label>
          Amount in Rupees
          <input value={rupees} onChange={(event) => setRupees(event.target.value)} />
        </label>
        <button type="submit">Convert</button>
      </form>
      {euro !== "" && <h2>Euro: {euro.toFixed(2)}</h2>}
    </div>
  );
}

export default CurrencyConvertor;
