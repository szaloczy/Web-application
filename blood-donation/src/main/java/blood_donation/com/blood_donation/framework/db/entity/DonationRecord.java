package blood_donation.com.blood_donation.framework.db.entity;

import blood_donation.com.blood_donation.domain.Donator;
import blood_donation.com.blood_donation.domain.Location;
import blood_donation.com.blood_donation.enums.LocationStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Table
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DonationRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private Donator donator;

    @Column(nullable = false)
    private Location location;

    @Column(nullable = false)
    private Date donationDate;

    @Column(nullable = false)
    private String DoctorFullName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "locatio_id", nullable = false)
    private LocationRecord Location;
}
