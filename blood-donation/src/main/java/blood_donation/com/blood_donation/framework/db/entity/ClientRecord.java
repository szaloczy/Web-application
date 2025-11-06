package blood_donation.com.blood_donation.framework.db.entity;

import blood_donation.com.blood_donation.enums.GenderType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Table
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private String fullname;

    @Column(nullable = false)
    private String birthplace;

    @Column(nullable = false)
    private LocalDate dateOfBirth;

    @Column(nullable = false)
    private String citizenship;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false, unique = true, length = 9)
    private String tajNumber;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private GenderType gender;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client", fetch = FetchType.LAZY)
    private List<DonationRecord> donations;
}
