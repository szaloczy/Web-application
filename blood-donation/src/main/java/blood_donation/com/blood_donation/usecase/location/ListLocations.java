package blood_donation.com.blood_donation.usecase.location;

import blood_donation.com.blood_donation.data.LocationDataSource;
import blood_donation.com.blood_donation.domain.Location;
import blood_donation.com.blood_donation.enums.LocationStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListLocations {

    private final LocationDataSource dataSource;

    public List<Location> execute(String name, String address, LocationStatus status) {
        return dataSource.getLocationsByFilters(name, address, status);
    }
}
