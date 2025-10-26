package blood_donation.com.blood_donation.framework.db.repository;

import blood_donation.com.blood_donation.framework.db.entity.DonatorRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonatorRepository extends JpaRepository<DonatorRecord, Long> {

}
