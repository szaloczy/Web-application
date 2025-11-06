package blood_donation.com.blood_donation.usecase.donation;

import blood_donation.com.blood_donation.data.DonationDataSource;
import blood_donation.com.blood_donation.domain.Donation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class CreateDonation {

    private final DonationDataSource dataSource;

    public Donation execute(LocalDate date, boolean eligible, String reason, String doctor,
                           boolean controlled, String patientFullname, String patientTaj,
                           Long clientId, Long locationId) {
        
        Donation donation = new Donation(null, date, eligible, reason, doctor, controlled, 
                                        patientFullname, patientTaj, clientId, locationId, null, null);
        return dataSource.createDonation(donation);
    }
}
