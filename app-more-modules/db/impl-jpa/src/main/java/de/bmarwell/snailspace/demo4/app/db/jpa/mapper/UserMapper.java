package de.bmarwell.snailspace.demo4.app.db.jpa.mapper;

import de.bmarwell.snailspace.demo4.app.common.value.User;
import de.bmarwell.snailspace.demo4.app.db.jpa.pdo.UserPdo;

public class UserMapper {

    public static User toDomain(UserPdo userPdo) {
        return new User(userPdo.getUserId(), userPdo.getName());
    }

}
