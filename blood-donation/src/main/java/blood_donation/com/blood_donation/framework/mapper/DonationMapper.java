package blood_donation.com.blood_donation.framework.mapper;

import blood_donation.com.blood_donation.domain.Donation;
import blood_donation.com.blood_donation.framework.db.entity.DonationRecord;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface DonationMapper {
    
    DonationMapper INSTANCE = Mappers.getMapper(DonationMapper.class);
    
    @Mapping(target = "client.id", source = "clientId")
    @Mapping(target = "location.id", source = "locationId")
    @Mapping(target = "client.fullname", ignore = true)
    @Mapping(target = "client.birthplace", ignore = true)
    @Mapping(target = "client.dateOfBirth", ignore = true)
    @Mapping(target = "client.citizenship", ignore = true)
    @Mapping(target = "client.address", ignore = true)
    @Mapping(target = "client.tajNumber", ignore = true)
    @Mapping(target = "client.gender", ignore = true)
    @Mapping(target = "client.donations", ignore = true)
    @Mapping(target = "location.name", ignore = true)
    @Mapping(target = "location.address", ignore = true)
    @Mapping(target = "location.status", ignore = true)
    @Mapping(target = "location.donations", ignore = true)
    DonationRecord toDonationRecord(Donation donation);
    
    @Mapping(target = "clientId", source = "client.id")
    @Mapping(target = "locationId", source = "location.id")
    @Mapping(target = "client", source = "client")
    @Mapping(target = "location", source = "location")
    Donation toDonation(DonationRecord donationRecord);
    
    List<Donation> toDonations(List<DonationRecord> donationRecords);
}
