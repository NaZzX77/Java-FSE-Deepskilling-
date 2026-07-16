import { useState } from "react";
import CurrencyConvertor from "./CurrencyConvertor.jsx";

function App() {
  const [counter, setCounter] = useState(0);

  function sayHello() {
    alert("Hello Member");
  }

  function incrementCounter() {
    setCounter(counter + 1);
    sayHello();
  }

  function decrementCounter() {
    setCounter(counter - 1);
  }

  function sayWelcome(message) {
    alert(message);
  }

  function onPress() {
    alert("I was clicked");
  }

  return (
    <div>
      <h1>{counter}</h1>
      <button onClick={incrementCounter}>Increment</button>
      <button onClick={decrementCounter}>Decrement</button>
      <button onClick={() => sayWelcome("welcome")}>Say Welcome</button>
      <button onClick={onPress}>OnPress</button>
      <CurrencyConvertor />
    </div>
  );
}

export default App;
