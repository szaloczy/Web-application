package blood_donation.com.blood_donation.usecase.client;

import blood_donation.com.blood_donation.data.ClientDataSource;
import blood_donation.com.blood_donation.domain.Client;
import blood_donation.com.blood_donation.enums.GenderType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class CreateClient {

    private final ClientDataSource dataSource;

    public Client execute(String fullname, String birthplace, LocalDate dateOfBirth, 
                         String citizenship, String address, String tajNumber, GenderType gender) {
        
        // Check if client with this TAJ number already exists
        Client existingClient = dataSource.getClientByTajNumber(tajNumber);
        if (existingClient != null) {
            throw new IllegalArgumentException("Véradó ezzel a TAJ számmal már létezik");
        }
        
        Client client = new Client(null, fullname, birthplace, dateOfBirth, citizenship, address, tajNumber, gender);
        return dataSource.createClient(client);
    }
}
