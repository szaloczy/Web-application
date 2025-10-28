package blood_donation.com.blood_donation.domain;

import org.springframework.security.core.Transient;

import java.util.Date;

@Transient
public record Donation(Long id, Donator donator, Location location, Date donationDate, String doctorFullName) {}
