package blood_donation.com.blood_donation.domain;

import blood_donation.com.blood_donation.enums.LocationStatus;
import org.springframework.security.core.Transient;

@Transient
public record Location(Long id, String name, String address, LocationStatus status) {
}
