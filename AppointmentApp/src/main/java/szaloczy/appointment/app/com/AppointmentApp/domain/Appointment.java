package szaloczy.appointment.app.com.AppointmentApp.domain;

import szaloczy.appointment.app.com.AppointmentApp.enums.AppointmentStatus;

import java.time.LocalDateTime;

public record Appointment(Long id, Long userId, Long providerId, LocalDateTime startTime, LocalDateTime endTime, AppointmentStatus status) { }
