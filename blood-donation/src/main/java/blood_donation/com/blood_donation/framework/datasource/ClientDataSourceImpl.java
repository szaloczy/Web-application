package blood_donation.com.blood_donation.framework.datasource;

import blood_donation.com.blood_donation.data.ClientDataSource;
import blood_donation.com.blood_donation.domain.Client;
import blood_donation.com.blood_donation.framework.db.entity.ClientRecord;
import blood_donation.com.blood_donation.framework.db.repository.ClientRepository;
import blood_donation.com.blood_donation.framework.mapper.ClientMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientDataSourceImpl implements ClientDataSource {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    @Override
    public Client createClient(Client client) {
        ClientRecord clientRecord = clientMapper.toClientRecord(client);
        ClientRecord savedRecord = clientRepository.save(clientRecord);
        return clientMapper.toClient(savedRecord);
    }

    @Override
    public Client updateClient(Client client) {
        ClientRecord clientRecord = clientMapper.toClientRecord(client);
        ClientRecord updatedRecord = clientRepository.save(clientRecord);
        return clientMapper.toClient(updatedRecord);
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }

    @Override
    public List<Client> getAllClients() {
        List<ClientRecord> clientRecords = clientRepository.findAll();
        return clientMapper.toClients(clientRecords);
    }

    @Override
    public Client getClientById(Long id) {
        return clientRepository.findById(id)
                .map(clientMapper::toClient)
                .orElse(null);
    }

    @Override
    public Client getClientByTajNumber(String tajNumber) {
        return clientRepository.findByTajNumber(tajNumber)
                .map(clientMapper::toClient)
                .orElse(null);
    }
}
