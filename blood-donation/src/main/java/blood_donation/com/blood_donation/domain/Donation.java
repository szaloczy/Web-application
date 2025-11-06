package blood_donation.com.blood_donation.domain;

import java.time.LocalDate;

public record Donation(
    Long id,
    LocalDate date,
    boolean eligible,
    String reason,
    String doctor,
    boolean controlled,
    String patientFullname,
    String patientTaj,
    Long clientId,
    Long locationId,
    Client client,
    Location location
) {
}
