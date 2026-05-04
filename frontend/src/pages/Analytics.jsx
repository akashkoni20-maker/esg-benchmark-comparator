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
        console.log(res.data);
        setData(res.data);
      })
      .catch(err => console.log(err));
  }, []);

  return (
    <div style={{ padding: "20px" }}>

      <h2 style={{ textAlign: "center", marginBottom: "20px" }}>
        Analytics Dashboard
      </h2>

      {/* ✅ Responsive Container */}
      <div
        style={{
          width: "100%",
          height: window.innerWidth < 768 ? "250px" : "400px"
        }}
      >
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

    </div>
  );
}

export default Analytics;