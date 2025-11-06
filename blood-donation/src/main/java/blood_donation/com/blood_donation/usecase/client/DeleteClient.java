package blood_donation.com.blood_donation.usecase.client;

import blood_donation.com.blood_donation.data.ClientDataSource;
import blood_donation.com.blood_donation.domain.Client;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteClient {

    private final ClientDataSource dataSource;

    public void execute(Long id) {
        Client client = dataSource.getClientById(id);
        if (client == null) {
            throw new IllegalArgumentException("Véradó nem található");
        }
        dataSource.deleteClient(id);
    }
}
