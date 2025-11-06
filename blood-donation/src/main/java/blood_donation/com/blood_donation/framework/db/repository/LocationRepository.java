package blood_donation.com.blood_donation.framework.db.repository;

import blood_donation.com.blood_donation.enums.LocationStatus;
import blood_donation.com.blood_donation.framework.db.entity.LocationRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface LocationRepository extends JpaRepository<LocationRecord, Long> {
    Optional<LocationRecord> findByName(String name);
    Optional<LocationRecord> findByAddress(String address);
    Optional<LocationRecord> findByStatus(LocationStatus status);
    long countByStatus(LocationStatus status);
    
    @Query("SELECT l FROM LocationRecord l WHERE " +
           "(:name IS NULL OR :name = '' OR LOWER(l.name) LIKE LOWER(CONCAT('%', :name, '%'))) AND " +
           "(:address IS NULL OR :address = '' OR LOWER(l.address) LIKE LOWER(CONCAT('%', :address, '%'))) AND " +
           "(:status IS NULL OR l.status = :status)")
    List<LocationRecord> findByFilters(@Param("name") String name, 
                                       @Param("address") String address, 
                                       @Param("status") LocationStatus status);
}
