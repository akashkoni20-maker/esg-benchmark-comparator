import java.util.HashMap;
import java.util.Map;

@RequestMapping("/api/stats")
@GetMapping("/stats")
public Map<String, Object> stats() {

    Map<String, Object> data = new HashMap<>();

    data.put("totalLogs", repository.count());
    data.put("activeUsers", 12);
    data.put("todayLogs", 5);
    data.put("deletedLogs", 2);

    return data;
}