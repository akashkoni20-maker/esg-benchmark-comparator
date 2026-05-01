import { useEffect, useState } from "react";
import axios from "axios";

function Dashboard() {
  const [search, setSearch] = useState("");
  const [debouncedSearch, setDebouncedSearch] = useState("");
  const [status, setStatus] = useState("");
  const [fromDate, setFromDate] = useState("");
  const [toDate, setToDate] = useState("");
  const [data, setData] = useState([]);

  // ✅ AI states
  const [aiInput, setAiInput] = useState("");
  const [aiResponse, setAiResponse] = useState("");
  const [loading, setLoading] = useState(false);

  // ✅ AI function
  const handleAI = () => {
    setLoading(true);

    setTimeout(() => {
      setAiResponse("AI Suggestion: Improve ESG score by reducing emissions.");
      setLoading(false);
    }, 1500);
  };

  // Debounce typing
  useEffect(() => {
    const timer = setTimeout(() => {
      setDebouncedSearch(search);
    }, 500);

    return () => clearTimeout(timer);
  }, [search]);

  // API Call
  useEffect(() => {
    axios
      .get("http://localhost:8080/companies", {
        params: {
          search: debouncedSearch,
          status: status,
          fromDate: fromDate,
          toDate: toDate,
        },
      })
      .then((res) => setData(res.data))
      .catch(() => {
        setData([
          { id: 1, name: "Tesla", status: "Active", date: "2026-04-20" },
          { id: 2, name: "Infosys", status: "Inactive", date: "2026-04-22" },
        ]);
      });
  }, [debouncedSearch, status, fromDate, toDate]);

  return (
    <div style={{ padding: "30px" }}>
      <h1>ESG Search Dashboard</h1>

      {/* 🔍 Filters */}
      <input
        placeholder="Search company..."
        value={search}
        onChange={(e) => setSearch(e.target.value)}
      />

      <select onChange={(e) => setStatus(e.target.value)}>
        <option value="">All Status</option>
        <option>Active</option>
        <option>Inactive</option>
      </select>

      <input type="date" onChange={(e) => setFromDate(e.target.value)} />
      <input type="date" onChange={(e) => setToDate(e.target.value)} />

      <hr />

      {/* 📊 Data List */}
      {data.map((item) => (
        <div key={item.id}>
          {item.name} | {item.status} | {item.date}
        </div>
      ))}

      {/* 🤖 AI PANEL (NEW) */}
      <hr />

      <h2>AI Panel</h2>

      <input
        placeholder="Ask AI..."
        value={aiInput}
        onChange={(e) => setAiInput(e.target.value)}
      />

      <button onClick={handleAI}>Ask AI</button>

      {loading && <p>Loading...</p>}

      {aiResponse && (
        <div
          style={{
            marginTop: "10px",
            padding: "15px",
            border: "1px solid gray",
            borderRadius: "10px",
          }}
        >
          {aiResponse}
        </div>
      )}
    </div>
  );
}

export default Dashboard;