package blood_donation.com.blood_donation.usecase.location;

import blood_donation.com.blood_donation.domain.Location;
import blood_donation.com.blood_donation.domain.User;
import blood_donation.com.blood_donation.usecase.base.UseCase;

import java.util.List;

public class ListLocations extends UseCase<User, List<Location>> {
    @Override
    public List<Location> execute(User input) {
        return null;
    }
}
