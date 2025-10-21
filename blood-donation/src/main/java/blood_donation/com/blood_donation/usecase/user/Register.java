package blood_donation.com.blood_donation.usecase.user;

import blood_donation.com.blood_donation.domain.User;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Register {
    public User register(String fullname, String email, String password) {
        User user = new User(0L, fullname, email, password);
        //dataSource.createUser(user);
        return user;
    }

}
