package blood_donation.com.blood_donation.domain;

import blood_donation.com.blood_donation.enums.Gender;

import java.util.Date;

public record Donator(Long id, String fullname, int TAJNumber, Gender gender, String citizenship, String bornLocation, Date birthDate, String address, boolean isAble) {
}
