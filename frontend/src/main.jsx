import { Routes, Route } from "react-router-dom";

function Login() {
  return <h2>Login Page</h2>;
}

function App() {
  return (
    <Routes>
      <Route path="/" element={<Login />} />
    </Routes>
  );
}

export default App;