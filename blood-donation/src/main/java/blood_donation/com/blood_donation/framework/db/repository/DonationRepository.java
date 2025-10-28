package blood_donation.com.blood_donation.framework.db.repository;

import blood_donation.com.blood_donation.framework.db.entity.DonationRecord;
import blood_donation.com.blood_donation.framework.db.entity.DonatorRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DonationRepository extends JpaRepository<DonationRecord, Long> {
    Optional<List<DonationRecord>> findByDonator(DonatorRecord donator);
}
