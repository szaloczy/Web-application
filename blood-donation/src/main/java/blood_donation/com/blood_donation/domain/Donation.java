package blood_donation.com.blood_donation.domain;

import java.util.Date;

public record Donation(Long id, Donator donator, Location location, Date donationDate, String doctorFullName) {}
