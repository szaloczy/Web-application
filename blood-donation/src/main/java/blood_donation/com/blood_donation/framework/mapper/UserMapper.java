package blood_donation.com.blood_donation.framework.mapper;

import blood_donation.com.blood_donation.domain.User;
import blood_donation.com.blood_donation.framework.db.entity.UserRecord;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    UserRecord toUserRecord(User user);
    User toUser (UserRecord userRecord);
    List<User> toUsers(List<UserRecord> userRecords);
}
