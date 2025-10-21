package blood_donation.com.blood_donation.usecase.donation;

import blood_donation.com.blood_donation.domain.Donation;
import blood_donation.com.blood_donation.usecase.base.UseCase;

public class DeleteDonation extends UseCase<Donation, Boolean> {
    @Override
    public Boolean execute(Donation input) {
        return false;
    }
}
