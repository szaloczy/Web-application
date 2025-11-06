package blood_donation.com.blood_donation.usecase.client;

import blood_donation.com.blood_donation.data.ClientDataSource;
import blood_donation.com.blood_donation.domain.Client;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetClient {

    private final ClientDataSource dataSource;

    public Client execute(Long id) {
        return dataSource.getClientById(id);
    }
}
