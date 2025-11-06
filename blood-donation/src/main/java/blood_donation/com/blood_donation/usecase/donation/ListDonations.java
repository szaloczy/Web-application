package blood_donation.com.blood_donation.usecase.donation;

import blood_donation.com.blood_donation.data.DonationDataSource;
import blood_donation.com.blood_donation.domain.Donation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ListDonations {

    private final DonationDataSource dataSource;

    public List<Donation> execute(Long clientId, Long locationId, LocalDate fromDate, LocalDate toDate) {
        if (clientId != null) {
            return dataSource.getDonationsByClientId(clientId);
        }
        if (locationId != null) {
            return dataSource.getDonationsByLocationId(locationId);
        }
        if (fromDate != null && toDate != null) {
            return dataSource.getDonationsByDateRange(fromDate, toDate);
        }
        return dataSource.getAllDonations();
    }
}
