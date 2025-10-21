package blood_donation.com.blood_donation.usecase.donator;

import blood_donation.com.blood_donation.domain.Donator;
import blood_donation.com.blood_donation.domain.User;
import blood_donation.com.blood_donation.usecase.base.UseCase;

import java.util.List;

public class ListDonators extends UseCase<User, List<Donator>> {
    @Override
    public List<Donator> execute(User input) {
        return null;
    }
}
