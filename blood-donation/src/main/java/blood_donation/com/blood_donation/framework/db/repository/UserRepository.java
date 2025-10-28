package blood_donation.com.blood_donation.framework.db.repository;

import blood_donation.com.blood_donation.framework.db.entity.UserRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserRecord, Long> {
    Optional<UserRecord> findByUsername(String username);
    Optional<UserRecord> findByEmail(String email);
}
