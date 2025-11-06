package blood_donation.com.blood_donation.config;

import blood_donation.com.blood_donation.framework.mapper.ClientMapper;
import blood_donation.com.blood_donation.framework.mapper.DonationMapper;
import blood_donation.com.blood_donation.framework.mapper.LocationMapper;
import blood_donation.com.blood_donation.framework.mapper.UserMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    public ClientMapper clientMapper() {
        return Mappers.getMapper(ClientMapper.class);
    }

    @Bean
    public DonationMapper donationMapper() {
        return Mappers.getMapper(DonationMapper.class);
    }

    @Bean
    public LocationMapper locationMapper() {
        return Mappers.getMapper(LocationMapper.class);
    }

    @Bean
    public UserMapper userMapper() {
        return Mappers.getMapper(UserMapper.class);
    }
}
