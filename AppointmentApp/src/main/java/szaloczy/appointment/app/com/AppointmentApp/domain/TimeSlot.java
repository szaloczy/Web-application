package szaloczy.appointment.app.com.AppointmentApp.domain;

import java.time.LocalTime;

public record TimeSlot(Long id,LocalTime start, LocalTime end) {}
