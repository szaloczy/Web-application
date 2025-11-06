package blood_donation.com.blood_donation.domain;

public record DashboardStats(
    long todayDonations,
    long totalClients,
    long activeLocations,
    long thisMonthDonations,
    long eligibleDonations,
    long ineligibleDonations
) {
}
