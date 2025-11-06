package blood_donation.com.blood_donation.usecase.donation;

import blood_donation.com.blood_donation.data.DonationDataSource;
import blood_donation.com.blood_donation.domain.Donation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetDonation {

    private final DonationDataSource dataSource;

    public Donation execute(Long id) {
        return dataSource.getDonationById(id);
    }
}
