package blood_donation.com.blood_donation.framework.datasource;

import blood_donation.com.blood_donation.data.DonationDataSource;
import blood_donation.com.blood_donation.domain.Donation;
import blood_donation.com.blood_donation.domain.Donator;

import java.util.List;


public class DonationDataSourceImpl implements DonationDataSource {

    @Override
    public void createDonation(Donation donation) {

    }

    @Override
    public void updateDonation(Donation donation) {

    }

    @Override
    public void deleteDonation(Donation donation) {

    }

    @Override
    public Donation getDonationById(Long id) {
        return null;
    }

    @Override
    public Donation getDonationByDonator(Donator donator) {
        return null;
    }

    @Override
    public List<Donation> getAllDonation() {
        return List.of();
    }
}
