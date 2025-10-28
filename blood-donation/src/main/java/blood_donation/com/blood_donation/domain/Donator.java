package blood_donation.com.blood_donation.domain;

import blood_donation.com.blood_donation.enums.Gender;
import org.springframework.security.core.Transient;

import java.util.Date;

@Transient
public record Donator(Long id, String fullname, int TAJNumber, Gender gender, String citizenship, String bornLocation, Date birthDate, String address, boolean isAble) {
}
