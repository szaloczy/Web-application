package blood_donation.com.blood_donation.data;

import blood_donation.com.blood_donation.domain.Donator;

import java.util.List;

public interface DonatorDataSource {
    void createDonator(Donator donator);
    void updateDonator(Donator donator);
    void deleteDonator(Donator donator);
    Donator getDonatorById(Long id);
    List<Donator> getAllDonator();
}
