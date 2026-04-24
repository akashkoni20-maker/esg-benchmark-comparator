import { useEffect, useState } from "react";
import axios from "axios";

function AuditLogList() {
  const [logs, setLogs] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    axios.get("http://localhost:8080/api/audit-logs")
      .then((res) => setLogs(res.data))
      .catch((err) => console.log(err))
      .finally(() => setLoading(false));
  }, []);

  if (loading) return <h2>Loading...</h2>;

  if (logs.length === 0) return <h2>No Data Found</h2>;

  return (
    <div>
      <h2>Audit Logs</h2>
      <table border="1" cellPadding="10">
        <thead>
          <tr>
            <th>ID</th>
            <th>Action</th>
            <th>User</th>
          </tr>
        </thead>
        <tbody>
          {logs.map((log) => (
            <tr key={log.id}>
              <td>{log.id}</td>
              <td>{log.action}</td>
              <td>{log.username}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default AuditLogList;