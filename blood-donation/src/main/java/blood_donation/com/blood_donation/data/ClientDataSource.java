package blood_donation.com.blood_donation.data;

import blood_donation.com.blood_donation.domain.Client;

import java.util.List;

public interface ClientDataSource {
    Client createClient(Client client);
    Client updateClient(Client client);
    void deleteClient(Long id);
    List<Client> getAllClients();
    Client getClientById(Long id);
    Client getClientByTajNumber(String tajNumber);
}
