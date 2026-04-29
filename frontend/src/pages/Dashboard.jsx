import { useEffect, useState } from "react";
import axios from "axios";
import {
  BarChart, Bar, XAxis, YAxis, Tooltip, CartesianGrid
} from "recharts";

function Dashboard() {
  const [stats, setStats] = useState({});

  useEffect(() => {
    axios.get("http://localhost:8080/api/audit-logs/stats")
      .then((res) => setStats(res.data));
  }, []);

  const chartData = [
    { name: "Total", value: stats.totalLogs || 0 },
    { name: "Users", value: stats.activeUsers || 0 },
    { name: "Today", value: stats.todayLogs || 0 },
    { name: "Deleted", value: stats.deletedLogs || 0 }
  ];

  return (
    <div style={{ padding: "20px" }}>
      <h2>Dashboard</h2>

      <div style={{ display: "flex", gap: "10px", flexWrap: "wrap" }}>
        <div>Total Logs: {stats.totalLogs}</div>
        <div>Users: {stats.activeUsers}</div>
        <div>Today: {stats.todayLogs}</div>
        <div>Deleted: {stats.deletedLogs}</div>
      </div>

      <br />

      <BarChart width={500} height={300} data={chartData}>
        <CartesianGrid strokeDasharray="3 3" />
        <XAxis dataKey="name" />
        <YAxis />
        <Tooltip />
        <Bar dataKey="value" />
      </BarChart>
    </div>
  );
}

export default Dashboard;