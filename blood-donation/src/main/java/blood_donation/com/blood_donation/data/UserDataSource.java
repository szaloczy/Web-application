package blood_donation.com.blood_donation.data;

import blood_donation.com.blood_donation.domain.User;

import java.util.List;

public interface UserDataSource {

    void createUser(User user);
    void deleteUser(User user);
    void updateUser(User user);
    User getUserByFullName(String fullName);
    User getUserByEmail(String email);
    User getUserById(Long id);
    List<User> getAllUser();
}
