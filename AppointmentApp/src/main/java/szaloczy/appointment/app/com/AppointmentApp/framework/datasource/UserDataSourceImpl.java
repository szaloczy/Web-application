package szaloczy.appointment.app.com.AppointmentApp.framework.datasource;

import lombok.RequiredArgsConstructor;
import szaloczy.appointment.app.com.AppointmentApp.data.UserDataSource;
import szaloczy.appointment.app.com.AppointmentApp.domain.User;

import java.util.List;

@RequiredArgsConstructor
public class UserDataSourceImpl implements UserDataSource {

    @Override
    public void createUse(User user) {

    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void deleteUser(User user) {

    }

    @Override
    public User getUserByUsername(String username) {
        return null;
    }

    @Override
    public User getUserByEmail(String email) {
        return null;
    }

    @Override
    public User getUserById(Long id) {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return List.of();
    }
}
