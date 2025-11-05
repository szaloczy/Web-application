package blood_donation.com.blood_donation.framework.datasource;

import blood_donation.com.blood_donation.data.UserDataSource;
import blood_donation.com.blood_donation.domain.User;
import blood_donation.com.blood_donation.framework.db.entity.UserRecord;
import blood_donation.com.blood_donation.framework.db.repository.UserRepository;
import blood_donation.com.blood_donation.framework.mapper.UserMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserDataSourceImpl implements UserDataSource {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserDataSourceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public void createUser(User user) {
        UserRecord userRecord = userMapper.toUserRecord(user);
        userRepository.save(userRecord);
    }

    @Override
    public void deleteUser(User user) {

    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public User getUserByUsername(String username) {
        Optional<UserRecord> userRecord = userRepository.findByUsername(username);
        return userRecord.map(userMapper::toUser).orElse(null);
    }

    @Override
    public User getUserByEmail(String email) {
        Optional<UserRecord> userRecord = userRepository.findByEmail(email);
        return userRecord.map(userMapper::toUser).orElse(null);
    }

    @Override
    public User getUserById(Long id) {
        Optional<UserRecord> userRecord = userRepository.findById(id);
        return userRecord.map(userMapper::toUser).orElse(null);
    }

    @Override
    public List<User> getAllUser() {
        List<UserRecord> userRecords = userRepository.findAll();
        return userMapper.toUsers(userRecords);
    }
}
