package szaloczy.appointment.app.com.AppointmentApp.domain;

import java.math.BigDecimal;

public record Service(Long id, String name, String description, BigDecimal price) {}
