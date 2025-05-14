package de.bmarwell.snailspace.demo4.app.services;

import de.bmarwell.snailspace.demo4.app.common.value.User;
import de.bmarwell.snailspace.demo4.app.common.value.UserId;
import java.util.Optional;

public interface UserService {

    User updateUser(UserId userId, User user);

    Optional<User> getUserById(UserId userId);
}
