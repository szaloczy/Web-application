package blood_donation.com.blood_donation.framework.mapper;

import blood_donation.com.blood_donation.domain.Client;
import blood_donation.com.blood_donation.framework.db.entity.ClientRecord;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ClientMapper {
    
    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);
    
    @Mapping(target = "donations", ignore = true)
    ClientRecord toClientRecord(Client client);
    
    @Mapping(target = "id", source = "id")
    @Mapping(target = "fullname", source = "fullname")
    @Mapping(target = "birthplace", source = "birthplace")
    @Mapping(target = "dateOfBirth", source = "dateOfBirth")
    @Mapping(target = "citizenship", source = "citizenship")
    @Mapping(target = "address", source = "address")
    @Mapping(target = "tajNumber", source = "tajNumber")
    @Mapping(target = "gender", source = "gender")
    Client toClient(ClientRecord clientRecord);
    
    List<Client> toClients(List<ClientRecord> clientRecords);
}
