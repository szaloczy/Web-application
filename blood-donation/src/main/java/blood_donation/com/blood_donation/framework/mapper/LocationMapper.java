package blood_donation.com.blood_donation.framework.mapper;

import blood_donation.com.blood_donation.domain.Location;
import blood_donation.com.blood_donation.framework.db.entity.LocationRecord;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface LocationMapper {
    
    LocationMapper INSTANCE = Mappers.getMapper(LocationMapper.class);
    
    @Mapping(target = "donations", ignore = true)
    LocationRecord toLocationRecord(Location location);
    
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "address", source = "address")
    @Mapping(target = "status", source = "status")
    Location toLocation(LocationRecord locationRecord);
    
    List<Location> toLocations(List<LocationRecord> locationRecords);
}
