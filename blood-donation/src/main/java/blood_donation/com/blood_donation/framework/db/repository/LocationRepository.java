package blood_donation.com.blood_donation.framework.db.repository;

import blood_donation.com.blood_donation.framework.db.entity.LocationRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LocationRepository extends JpaRepository<LocationRecord, Long> {
    Optional<LocationRecord> findByName(String name);
    Optional<LocationRecord> findByAddress(String address);
}
