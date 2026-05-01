import { BrowserRouter, Routes, Route, Link } from "react-router-dom";
import Dashboard from "./pages/Dashboard";
import DetailPage from "./pages/DetailPage";
import Analytics from "./pages/Analytics";


function App() {
  return (
    <BrowserRouter>
      <div style={{ padding: "20px" }}>
        <Link to="/">Dashboard</Link> |{" "}
        <Link to="/detail/1">Detail</Link>
      </div>

      <Routes>
        <Route path="/" element={<Dashboard />} />
        <Route path="/detail/:id" element={<DetailPage />} />
        <Route path="/analytics" element={<Analytics />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;