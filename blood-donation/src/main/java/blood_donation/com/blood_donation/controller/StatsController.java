package blood_donation.com.blood_donation.controller;

import blood_donation.com.blood_donation.domain.DashboardStats;
import blood_donation.com.blood_donation.usecase.stats.GetDashboardStats;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/stats")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:3000"}, allowCredentials = "true")
public class StatsController {

    private final GetDashboardStats getDashboardStats;

    public StatsController(GetDashboardStats getDashboardStats) {
        this.getDashboardStats = getDashboardStats;
    }

    @GetMapping("/dashboard")
    public ResponseEntity<DashboardStats> getDashboardStats() {
        try {
            DashboardStats stats = getDashboardStats.execute();
            return ResponseEntity.ok(stats);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
