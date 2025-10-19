package szaloczy.appointment.app.com.AppointmentApp.domain;

import szaloczy.appointment.app.com.AppointmentApp.enums.UserRole;

public record User(Long id, String username, String password, String email, UserRole role) { }
