package blood_donation.com.blood_donation.domain;

import blood_donation.com.blood_donation.enums.GenderType;
import java.time.LocalDate;

public record Client(
    Long id,
    String fullname,
    String birthplace,
    LocalDate dateOfBirth,
    String citizenship,
    String address,
    String tajNumber,
    GenderType gender
) {
}
