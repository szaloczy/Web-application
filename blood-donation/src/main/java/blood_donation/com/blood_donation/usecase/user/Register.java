package blood_donation.com.blood_donation.usecase.user;

import blood_donation.com.blood_donation.domain.User;
import blood_donation.com.blood_donation.exception.InvalidPasswordException;
import blood_donation.com.blood_donation.exception.UserAlreadyExistsException;
import blood_donation.com.blood_donation.framework.datasource.UserDataSourceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class Register {

    private final UserDataSourceImpl dataSource;
    private PasswordEncoder passwordEncoder;

    public Register(UserDataSourceImpl dataSource, PasswordEncoder passwordEncoder) {
        this.dataSource = dataSource;
        this.passwordEncoder = passwordEncoder;
    }

    public User register(String username, String email, String password) {
        validateUserDoesNotExists(username, email);
        validatePassword(password);

        String hashedPassword = passwordEncoder.encode(password);

        User user = new User(null, username, email, hashedPassword);

        dataSource.createUser(user);

        return user;
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
