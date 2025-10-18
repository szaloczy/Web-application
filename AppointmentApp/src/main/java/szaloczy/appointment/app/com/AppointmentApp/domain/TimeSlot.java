package szaloczy.appointment.app.com.AppointmentApp.domain;

import java.time.LocalTime;

public record TimeSlot(LocalTime start, LocalTime end) {}
