package blood_donation.com.blood_donation.framework.db.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Table(name = "donation_record")
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

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private boolean eligible;

    @Column
    private String reason;

    @Column(name = "doctor", nullable = false)
    private String doctor;

    @Column(nullable = false)
    private boolean controlled;

    @Column(name = "patient_fullname")
    private String patientFullname;

    @Column(name = "patient_taj", length = 9)
    private String patientTaj;
}
