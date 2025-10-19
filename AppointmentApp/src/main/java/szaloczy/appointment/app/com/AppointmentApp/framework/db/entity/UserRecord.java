package szaloczy.appointment.app.com.AppointmentApp.framework.db.entity;

import jakarta.persistence.*;
import lombok.*;
import szaloczy.appointment.app.com.AppointmentApp.enums.UserRole;

import java.util.List;

@Table
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private UserRole role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AppointmentRecord> appointments;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private ProviderRecord providerProfile;

}
