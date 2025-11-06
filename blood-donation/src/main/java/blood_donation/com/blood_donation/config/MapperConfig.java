package blood_donation.com.blood_donation.config;

import blood_donation.com.blood_donation.framework.mapper.ClientMapper;
import blood_donation.com.blood_donation.framework.mapper.ClientMapperImpl;
import blood_donation.com.blood_donation.framework.mapper.DonationMapper;
import blood_donation.com.blood_donation.framework.mapper.DonationMapperImpl;
import blood_donation.com.blood_donation.framework.mapper.LocationMapper;
import blood_donation.com.blood_donation.framework.mapper.LocationMapperImpl;
import blood_donation.com.blood_donation.framework.mapper.UserMapper;
import blood_donation.com.blood_donation.framework.mapper.UserMapperImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    public ClientMapper clientMapper() {
        return new ClientMapperImpl();
    }

    @Bean
    public DonationMapper donationMapper() {
        return new DonationMapperImpl();
    }

    @Bean
    public LocationMapper locationMapper() {
        return new LocationMapperImpl();
    }

    @Bean
    public UserMapper userMapper() {
        return new UserMapperImpl();
    }
}
