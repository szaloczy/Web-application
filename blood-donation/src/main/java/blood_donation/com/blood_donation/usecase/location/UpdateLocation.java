package blood_donation.com.blood_donation.usecase.location;

import blood_donation.com.blood_donation.data.LocationDataSource;
import blood_donation.com.blood_donation.domain.Location;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateLocation {

    private final LocationDataSource dataSource;

    public Location execute(Long id, String name, String address, blood_donation.com.blood_donation.enums.LocationStatus status) {
        Location location = new Location(id, name, address, status);
        dataSource.updateLocation(location);
        return location;
    }
}
