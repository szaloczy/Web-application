package blood_donation.com.blood_donation.framework.datasource;

import blood_donation.com.blood_donation.data.DonationDataSource;
import blood_donation.com.blood_donation.domain.Donation;
import blood_donation.com.blood_donation.framework.db.entity.ClientRecord;
import blood_donation.com.blood_donation.framework.db.entity.DonationRecord;
import blood_donation.com.blood_donation.framework.db.entity.LocationRecord;
import blood_donation.com.blood_donation.framework.db.repository.ClientRepository;
import blood_donation.com.blood_donation.framework.db.repository.DonationRepository;
import blood_donation.com.blood_donation.framework.db.repository.LocationRepository;
import blood_donation.com.blood_donation.framework.mapper.DonationMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DonationDataSourceImpl implements DonationDataSource {

    private final DonationRepository donationRepository;
    private final ClientRepository clientRepository;
    private final LocationRepository locationRepository;
    private final DonationMapper donationMapper;

    @Override
    public Donation createDonation(Donation donation) {
        ClientRecord client = clientRepository.findById(donation.clientId())
                .orElseThrow(() -> new IllegalArgumentException("Véradó nem található"));
        LocationRecord location = locationRepository.findById(donation.locationId())
                .orElseThrow(() -> new IllegalArgumentException("Helyszín nem található"));

        DonationRecord donationRecord = DonationRecord.builder()
                .client(client)
                .location(location)
                .date(donation.date())
                .eligible(donation.eligible())
                .reason(donation.reason())
                .doctor(donation.doctor())
                .controlled(donation.controlled())
                .patientFullname(donation.patientFullname())
                .patientTaj(donation.patientTaj())
                .build();

        DonationRecord savedRecord = donationRepository.save(donationRecord);
        return donationMapper.toDonation(savedRecord);
    }

    @Override
    public Donation updateDonation(Donation donation) {
        ClientRecord client = clientRepository.findById(donation.clientId())
                .orElseThrow(() -> new IllegalArgumentException("Véradó nem található"));
        LocationRecord location = locationRepository.findById(donation.locationId())
                .orElseThrow(() -> new IllegalArgumentException("Helyszín nem található"));

        DonationRecord donationRecord = DonationRecord.builder()
                .id(donation.id())
                .client(client)
                .location(location)
                .date(donation.date())
                .eligible(donation.eligible())
                .reason(donation.reason())
                .doctor(donation.doctor())
                .controlled(donation.controlled())
                .patientFullname(donation.patientFullname())
                .patientTaj(donation.patientTaj())
                .build();

        DonationRecord updatedRecord = donationRepository.save(donationRecord);
        return donationMapper.toDonation(updatedRecord);
    }

    @Override
    public void deleteDonation(Long id) {
        donationRepository.deleteById(id);
    }

    @Override
    public List<Donation> getAllDonations() {
        List<DonationRecord> donationRecords = donationRepository.findAll();
        return donationMapper.toDonations(donationRecords);
    }

    @Override
    public Donation getDonationById(Long id) {
        return donationRepository.findById(id)
                .map(donationMapper::toDonation)
                .orElse(null);
    }

    @Override
    public List<Donation> getDonationsByClientId(Long clientId) {
        ClientRecord client = clientRepository.findById(clientId)
                .orElseThrow(() -> new IllegalArgumentException("Véradó nem található"));
        List<DonationRecord> donationRecords = donationRepository.findByClient(client).orElse(List.of());
        return donationMapper.toDonations(donationRecords);
    }

    @Override
    public List<Donation> getDonationsByLocationId(Long locationId) {
        LocationRecord location = locationRepository.findById(locationId)
                .orElseThrow(() -> new IllegalArgumentException("Helyszín nem található"));
        List<DonationRecord> donationRecords = donationRepository.findByLocation(location).orElse(List.of());
        return donationMapper.toDonations(donationRecords);
    }

    @Override
    public List<Donation> getDonationsByDateRange(LocalDate fromDate, LocalDate toDate) {
        List<DonationRecord> donationRecords = donationRepository.findByDateBetween(fromDate, toDate).orElse(List.of());
        return donationMapper.toDonations(donationRecords);
    }
}
