package blood_donation.com.blood_donation.framework.mapper;

import blood_donation.com.blood_donation.domain.Location;
import blood_donation.com.blood_donation.framework.db.entity.LocationRecord;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface LocationMapper {
    @Mapping(target = "donations", ignore = true)
    LocationRecord toLocationRecord(Location location);
    
    Location toLocation(LocationRecord locationRecord);
    List<Location> toLocations(List<LocationRecord> locationRecords);
}
