package blood_donation.com.blood_donation.usecase.location;

import blood_donation.com.blood_donation.data.LocationDataSource;
import blood_donation.com.blood_donation.domain.Location;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteLocation {

    private final LocationDataSource dataSource;

    public void execute(Long id) {
        Location location = dataSource.getLocationById(id);
        if (location != null) {
            dataSource.deleteLocation(location);
        }
    }
}
