package blood_donation.com.blood_donation.usecase.donator;

import blood_donation.com.blood_donation.domain.Donator;
import blood_donation.com.blood_donation.usecase.base.UseCase;

public class RemoveDonator extends UseCase<Donator, Boolean> {

    @Override
    public Boolean execute(Donator input) {
        return false;
    }
}
