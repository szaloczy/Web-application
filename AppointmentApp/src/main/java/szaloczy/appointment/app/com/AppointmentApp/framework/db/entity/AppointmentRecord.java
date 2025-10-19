package szaloczy.appointment.app.com.AppointmentApp.framework.db.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.cglib.core.Local;
import szaloczy.appointment.app.com.AppointmentApp.enums.AppointmentStatus;

import java.time.LocalDateTime;

@Table
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private Long providerId;

    @Column(nullable = false)
    private LocalDateTime startTime;

    @Column(nullable = false)
    private LocalDateTime endTime;

    @Column(nullable = false)
    private AppointmentStatus status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserRecord user;

    @ManyToOne
    @JoinColumn(name = "provider_id")
    private ProviderRecord provider;

    @ManyToOne
    @JoinColumn(name = "service_id")
    private ServiceRecord service;
}
