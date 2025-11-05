package blood_donation.com.blood_donation.framework.datasource;

import blood_donation.com.blood_donation.data.LocationDataSource;
import blood_donation.com.blood_donation.domain.Location;
import blood_donation.com.blood_donation.enums.LocationStatus;
import blood_donation.com.blood_donation.framework.db.entity.LocationRecord;
import blood_donation.com.blood_donation.framework.db.repository.LocationRepository;
import blood_donation.com.blood_donation.framework.mapper.LocationMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class LocationDataSourceImpl implements LocationDataSource {

    private final LocationRepository locationRepository;
    private final LocationMapper locationMapper;

    public LocationDataSourceImpl(LocationRepository locationRepository, LocationMapper locationMapper) {
        this.locationRepository = locationRepository;
        this.locationMapper = locationMapper;
    }

    @Override
    public void createLocation(Location location) {
        LocationRecord locationRecord = locationMapper.toLocationRecord(location);
        locationRepository.save(locationRecord);
    }

    @Override
    public void updateLocation(Location location) {
        LocationRecord locationRecord = locationMapper.toLocationRecord(location);
        locationRepository.save(locationRecord);
    }

    @Override
    public void deleteLocation(Location location) {
        LocationRecord locationRecord = locationMapper.toLocationRecord(location);
        locationRepository.delete(locationRecord);
    }

    @Override
    public Location getLocationById(Long id) {
        Optional<LocationRecord> locationRecord = locationRepository.findById(id);
        return locationRecord.map(locationMapper::toLocation).orElse(null);
    }

    @Override
    public Location getLocationByStatus(LocationStatus status) {
        Optional<LocationRecord> locationRecord = locationRepository.findByStatus(status);
        return locationRecord.map(locationMapper::toLocation).orElse(null);
    }

    @Override
    public Location getLocationByName(String name) {
        Optional<LocationRecord> locationRecord = locationRepository.findByName(name);
        return locationRecord.map(locationMapper::toLocation).orElse(null);
    }

    @Override
    public Location getLocationByAddress(String address) {
        Optional<LocationRecord> locationRecord = locationRepository.findByAddress(address);
        return locationRecord.map(locationMapper::toLocation).orElse(null);
    }

    @Override
    public List<Location> getAllLocation() {
        List<LocationRecord> locationRecords = locationRepository.findAll();
        return locationMapper.toLocations(locationRecords);
    }
}
