package blood_donation.com.blood_donation.usecase.location;

import blood_donation.com.blood_donation.data.LocationDataSource;
import blood_donation.com.blood_donation.domain.Location;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetLocation {

    private final LocationDataSource dataSource;

    public Location execute(Long id) {
        return dataSource.getLocationById(id);
    }
}
