import { useState } from "react";
import axios from "axios";

function AuditLogForm() {
  const [action, setAction] = useState("");
  const [username, setUsername] = useState("");
  const [error, setError] = useState("");

  const handleSubmit = async (e) => {
    e.preventDefault();

    if (action === "" || username === "") {
      setError("All fields required");
      return;
    }

    await axios.post("http://localhost:8080/api/audit-logs", {
      action,
      username
    });

    alert("Saved Successfully");
    setAction("");
    setUsername("");
    setError("");
  };

  return (
    <div style={{padding:"20px"}}>
      <h2>Create Audit Log</h2>

      {error && <p style={{color:"red"}}>{error}</p>}

      <form onSubmit={handleSubmit}>
        <input
          placeholder="Action"
          value={action}
          onChange={(e) => setAction(e.target.value)}
        />
        <br /><br />

        <input
          placeholder="Username"
          value={username}
          onChange={(e) => setUsername(e.target.value)}
        />
        <br /><br />

        <button type="submit">Save</button>
      </form>
    </div>
  );
}

export default AuditLogForm;