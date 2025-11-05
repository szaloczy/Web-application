package blood_donation.com.blood_donation.usecase.location;

import blood_donation.com.blood_donation.data.LocationDataSource;
import blood_donation.com.blood_donation.domain.Location;
import blood_donation.com.blood_donation.enums.LocationStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateLocation {

    private final LocationDataSource dataSource;

    public Location execute(String name, String address, LocationStatus status) {
        Location location = new Location(null, name, address, status != null ? status : LocationStatus.ACTIVE);
        dataSource.createLocation(location);
        return location;
    }
}
