package blood_donation.com.blood_donation.usecase.user;

import blood_donation.com.blood_donation.data.UserDataSource;
import blood_donation.com.blood_donation.domain.User;
import blood_donation.com.blood_donation.framework.datasource.UserDataSourceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Login {

    private UserDataSource dataSource;

    public boolean login(String email, String password) {
        if (isValidCredentials(email, password)) {
            User user = dataSource.getUserByEmail(email);

            if(user == null) return false;


        }
        return false;
    }

    private boolean isValidCredentials(String email, String password) {
        return email != null && password != null;
    }
}
