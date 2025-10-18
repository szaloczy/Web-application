package szaloczy.appointment.app.com.AppointmentApp.domain;

import java.time.LocalDate;
import java.util.List;

public record Schedule(Long id, Long providerId, LocalDate date, List<TimeSlot> availableSlots) {}
