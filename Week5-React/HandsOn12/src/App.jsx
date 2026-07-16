import { useState } from "react";
import GuestPage from "./GuestPage.jsx";
import UserPage from "./UserPage.jsx";

function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  if (isLoggedIn) {
    return (
      <div>
        <button onClick={() => setIsLoggedIn(false)}>Logout</button>
        <UserPage />
      </div>
    );
  }

  return (
    <div>
      <button onClick={() => setIsLoggedIn(true)}>Login</button>
      <GuestPage />
    </div>
  );
}

export default App;
