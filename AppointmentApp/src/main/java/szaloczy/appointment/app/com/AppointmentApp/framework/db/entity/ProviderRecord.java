package szaloczy.appointment.app.com.AppointmentApp.framework.db.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Table
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProviderRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    @Column(nullable = false)
    String name;

    @Column(nullable = false)
    String specialization;

    @Column(nullable = false)
    String contactInfo;

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserRecord user;

    @OneToMany(mappedBy = "provider", cascade = CascadeType.ALL)
    private List<ServiceRecord> services;

    @OneToMany(mappedBy = "provider", cascade = CascadeType.ALL)
    private List<AppointmentRecord> appointments;
}
