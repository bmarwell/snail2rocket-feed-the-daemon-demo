package de.bmarwell.snailspace.demo4.app.services.user;

import de.bmarwell.snailspace.demo4.app.common.value.User;
import de.bmarwell.snailspace.demo4.app.common.value.UserId;
import de.bmarwell.snailspace.demo4.app.services.api.UserService;
import java.util.Optional;

public class UserServiceImpl extends AbstractCachingUserService implements UserService {

    @Override
    public User updateUser(UserId userId, User user) {
        try {
            Thread.sleep(Long.parseLong(System.getProperty("method.timeout", "100")));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return user;
    }

    @Override
    protected Optional<User> doGetUserFromDatabase(UserId userId) {
        try {
            Thread.sleep(Long.parseLong(System.getProperty("method.timeout", "100")));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (userId.value().equals("mthmulders")) {
            return Optional.of(new User(userId, "Maarten"));
        }

        return Optional.empty();
    }
}
