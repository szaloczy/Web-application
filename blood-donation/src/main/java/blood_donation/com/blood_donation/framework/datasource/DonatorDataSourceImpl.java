package blood_donation.com.blood_donation.framework.datasource;

import blood_donation.com.blood_donation.data.DonatorDataSource;
import blood_donation.com.blood_donation.domain.Donator;

import java.util.List;

public class DonatorDataSourceImpl implements DonatorDataSource {
    @Override
    public void createDonator(Donator donator) {

    }

    @Override
    public void updateDonator(Donator donator) {

    }

    @Override
    public void deleteDonator(Donator donator) {

    }

    @Override
    public Donator getDonatorById(Long id) {
        return null;
    }

    @Override
    public List<Donator> getAllDonator() {
        return List.of();
    }
}
