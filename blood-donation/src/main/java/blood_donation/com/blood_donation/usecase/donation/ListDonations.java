package blood_donation.com.blood_donation.usecase.donation;

import blood_donation.com.blood_donation.domain.Donation;
import blood_donation.com.blood_donation.domain.User;
import blood_donation.com.blood_donation.usecase.base.UseCase;

import java.util.List;

public class ListDonations extends UseCase<User, List<Donation>> {
    @Override
    public List<Donation> execute(User input) {
        return null;
    }
}
