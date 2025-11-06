package blood_donation.com.blood_donation.usecase.stats;

import blood_donation.com.blood_donation.domain.DashboardStats;
import blood_donation.com.blood_donation.enums.LocationStatus;
import blood_donation.com.blood_donation.framework.db.repository.ClientRepository;
import blood_donation.com.blood_donation.framework.db.repository.DonationRepository;
import blood_donation.com.blood_donation.framework.db.repository.LocationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class GetDashboardStats {

    private final DonationRepository donationRepository;
    private final ClientRepository clientRepository;
    private final LocationRepository locationRepository;

    public GetDashboardStats(DonationRepository donationRepository,
                            ClientRepository clientRepository,
                            LocationRepository locationRepository) {
        this.donationRepository = donationRepository;
        this.clientRepository = clientRepository;
        this.locationRepository = locationRepository;
    }

    public DashboardStats execute() {
        LocalDate today = LocalDate.now();
        LocalDate firstDayOfMonth = today.withDayOfMonth(1);

        long todayDonations = donationRepository.countByDate(today);
        long totalClients = clientRepository.count();
        long activeLocations = locationRepository.countByStatus(LocationStatus.ACTIVE);
        long thisMonthDonations = donationRepository.countByDateBetween(firstDayOfMonth, today);
        long eligibleDonations = donationRepository.countByEligible(true);
        long ineligibleDonations = donationRepository.countByEligible(false);

        return new DashboardStats(
            todayDonations,
            totalClients,
            activeLocations,
            thisMonthDonations,
            eligibleDonations,
            ineligibleDonations
        );
    }
}
