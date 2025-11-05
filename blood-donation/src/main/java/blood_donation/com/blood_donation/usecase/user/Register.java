package blood_donation.com.blood_donation.usecase.user;

import blood_donation.com.blood_donation.data.UserDataSource;
import blood_donation.com.blood_donation.domain.User;
import blood_donation.com.blood_donation.dto.LoginResponseDTO;
import blood_donation.com.blood_donation.exception.InvalidPasswordException;
import blood_donation.com.blood_donation.exception.UserAlreadyExistsException;
import blood_donation.com.blood_donation.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Register {

    private final UserDataSource dataSource;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public LoginResponseDTO register(String username, String email, String password) {
        validateUserDoesNotExists(username, email);
        validatePassword(password);

        String hashedPassword = passwordEncoder.encode(password);
        User user = new User(null, username, email, hashedPassword, "ADMIN");

        dataSource.createUser(user);

        // Generálj JWT tokent
        String token = jwtUtil.generateToken(user.username());
        return new LoginResponseDTO(token, user.username(), user.email(), user.role());
    }

    private void validateUserDoesNotExists(String email, String username) {
        if(dataSource.getUserByEmail(email) != null) {
            throw new UserAlreadyExistsException("User with email: " + email + " already exists");
        }

        if(dataSource.getUserByUsername(username) != null) {
            throw new UserAlreadyExistsException("User with " + username + "already exists");
        }
    }

    private void validatePassword(String password) {
        if(password == null || password.length() < 8) {
            throw new InvalidPasswordException("Password must be at least 8 character long");
        }
    }
}
