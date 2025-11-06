package blood_donation.com.blood_donation.usecase.client;

import blood_donation.com.blood_donation.data.ClientDataSource;
import blood_donation.com.blood_donation.domain.Client;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListClients {

    private final ClientDataSource dataSource;

    public List<Client> execute() {
        return dataSource.getAllClients();
    }
}
