package blood_donation.com.blood_donation.framework.db.entity;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", nullable = false)
    private ClientRecord client;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id", nullable = false)
    private LocationRecord location;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date donationDate;

    @Column(nullable = false)
    private String doctorFullName;
}
