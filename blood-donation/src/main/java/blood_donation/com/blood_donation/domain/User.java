package blood_donation.com.blood_donation.domain;

import org.springframework.security.core.Transient;

@Transient
public record User (Long id, String username, String email, String password){}
