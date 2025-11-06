package blood_donation.com.blood_donation.framework.db.repository;

import blood_donation.com.blood_donation.framework.db.entity.ClientRecord;
import blood_donation.com.blood_donation.framework.db.entity.DonationRecord;
import blood_donation.com.blood_donation.framework.db.entity.LocationRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface DonationRepository extends JpaRepository<DonationRecord, Long> {
    Optional<List<DonationRecord>> findByClient(ClientRecord client);
    Optional<List<DonationRecord>> findByLocation(LocationRecord location);
    Optional<List<DonationRecord>> findByDateBetween(LocalDate fromDate, LocalDate toDate);
}
