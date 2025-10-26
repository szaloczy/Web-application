package blood_donation.com.blood_donation.data;

import blood_donation.com.blood_donation.domain.Donation;
import blood_donation.com.blood_donation.domain.Donator;

import java.util.List;

public interface DonationDataSource {
    void createDonation(Donation donation);
    void updateDonation(Donation donation);
    void deleteDonation(Donation donation);
    Donation getDonationById(Long id);
    Donation getDonationByDonator(Donator donator);
    List<Donation> getAllDonation();
}
