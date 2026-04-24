import axios from "axios";
import AuditLogList from "./pages/AuditLogList";

<Route path="/audit-logs" element={<AuditLogList />} />
const api = axios.create({
  baseURL: "http://localhost:8080/api",
});

export default api;