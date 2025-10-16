public record Schedule(Long id, Long providerId, LocalDate date, List<TimeSlot> availableSlots) {}
