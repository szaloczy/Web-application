package blood_donation.com.blood_donation.usecase.client;

import blood_donation.com.blood_donation.data.ClientDataSource;
import blood_donation.com.blood_donation.domain.Client;
import blood_donation.com.blood_donation.enums.GenderType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class UpdateClient {

    private final ClientDataSource dataSource;

    public Client execute(Long id, String fullname, String birthplace, LocalDate dateOfBirth,
                         String citizenship, String address, String tajNumber, GenderType gender) {
        Client client = new Client(id, fullname, birthplace, dateOfBirth, citizenship, address, tajNumber, gender);
        return dataSource.updateClient(client);
    }
}
