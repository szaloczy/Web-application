package blood_donation.com.blood_donation.usecase.location;

import blood_donation.com.blood_donation.domain.Location;
import blood_donation.com.blood_donation.usecase.base.UseCase;

public class CreateLocation extends UseCase<Location, Boolean> {
    @Override
    public Boolean execute(Location input) {
        return false;
    }
}
