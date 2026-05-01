import { useEffect, useState } from "react";
import axios from "axios";
import {
  BarChart, Bar, XAxis, YAxis, Tooltip, CartesianGrid, ResponsiveContainer
} from "recharts";

function Analytics() {

  const [data, setData] = useState([]);

  useEffect(() => {
    axios.get("http://localhost:8080/api/analytics")
      .then(res => {
        console.log(res.data); // ✅ check data
        setData(res.data);
      })
      .catch(err => console.log(err));
  }, []);

  return (
    <div style={{ width: "100%", height: 400 }}>
      <h2>Analytics Dashboard</h2>

      {/* ✅ IMPORTANT FIX */}
      <ResponsiveContainer width="100%" height="100%">
        <BarChart data={data}>
          <CartesianGrid strokeDasharray="3 3" />
          <XAxis dataKey="name" />
          <YAxis />
          <Tooltip />
          <Bar dataKey="score" />
        </BarChart>
      </ResponsiveContainer>

    </div>
  );
}

export default Analytics;