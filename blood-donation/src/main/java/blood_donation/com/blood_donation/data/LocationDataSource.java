package blood_donation.com.blood_donation.data;

import blood_donation.com.blood_donation.domain.Location;
import blood_donation.com.blood_donation.enums.LocationStatus;

import java.util.List;

public interface LocationDataSource {
    void createLocation(Location location);
    void updateLocation(Location location);
    void deleteLocation(Location location);
    Location getLocationById(Long id);
    Location getLocationByStatus(LocationStatus status);
    Location getLocationByName(String name);
    Location getLocationByAddress(String address);
    List<Location> getAllLocation();
    List<Location> getLocationsByFilters(String name, String address, LocationStatus status);
}

