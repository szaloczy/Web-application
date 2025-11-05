package blood_donation.com.blood_donation.usecase.user;

import blood_donation.com.blood_donation.data.UserDataSource;
import blood_donation.com.blood_donation.domain.User;
import blood_donation.com.blood_donation.dto.LoginResponseDTO;
import blood_donation.com.blood_donation.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Login {

    private final UserDataSource dataSource;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    public LoginResponseDTO login(String email, String password) {
        User user = dataSource.getUserByEmail(email);

        if (user == null) {
            return null;
        }

        // BCrypt jelszó ellenőrzés
        if (!passwordEncoder.matches(password, user.password())) {
            return null;
        }

        String token = jwtUtil.generateToken(user.username());
        return new LoginResponseDTO(token, user.username(), user.email(), user.role());
    }
}
