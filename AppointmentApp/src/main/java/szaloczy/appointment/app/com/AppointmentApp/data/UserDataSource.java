package szaloczy.appointment.app.com.AppointmentApp.data;

import szaloczy.appointment.app.com.AppointmentApp.domain.User;

import java.util.List;

public interface UserDataSource {
    void createUse(User user);
    void updateUser(User user);
    void deleteUser(User user);
    User getUserByUsername(String username);
    User getUserByEmail(String email);
    User getUserById(Long id);
    List<User> getAllUsers();
}
