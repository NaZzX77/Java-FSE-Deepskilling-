import IndianPlayers from "./components/IndianPlayers.jsx";
import ListofPlayers from "./components/ListofPlayers.jsx";

function App() {
  const flag = true;

  if (flag) {
    return <ListofPlayers />;
  }

  return <IndianPlayers />;
}

export default App;
