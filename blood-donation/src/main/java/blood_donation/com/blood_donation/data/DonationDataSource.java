package blood_donation.com.blood_donation.data;

import blood_donation.com.blood_donation.domain.Donation;

import java.time.LocalDate;
import java.util.List;

public interface DonationDataSource {
    Donation createDonation(Donation donation);
    Donation updateDonation(Donation donation);
    void deleteDonation(Long id);
    List<Donation> getAllDonations();
    Donation getDonationById(Long id);
    List<Donation> getDonationsByClientId(Long clientId);
    List<Donation> getDonationsByLocationId(Long locationId);
    List<Donation> getDonationsByDateRange(LocalDate fromDate, LocalDate toDate);
}
