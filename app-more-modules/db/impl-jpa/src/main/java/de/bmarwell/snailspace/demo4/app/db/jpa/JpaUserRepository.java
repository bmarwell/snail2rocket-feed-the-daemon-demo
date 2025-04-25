package de.bmarwell.snailspace.demo4.app.db.jpa;

import de.bmarwell.snailspace.demo4.app.common.value.User;
import de.bmarwell.snailspace.demo4.app.common.value.UserId;
import de.bmarwell.snailspace.demo4.app.db.api.UserRepository;
import java.util.List;
import java.util.Optional;

public class JpaUserRepository implements UserRepository {

    @Override
    public Optional<User> getUserById(UserId userId) {
        try {
            Thread.sleep(Long.parseLong(System.getProperty("method.timeout")));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if ("bmarwell".equals(userId.value())) {
            return Optional.of(new User(userId, "Ben"));
        }

        if ("mthmulders".equals(userId.value())) {
            return Optional.of(new User(userId, "Maarten"));
        }

        return Optional.empty();
    }

    @Override
    public List<User> getUserByName(String name) {
        try {
            Thread.sleep(Long.parseLong(System.getProperty("method.timeout")));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if ("Ben".equals(name)) {
            return List.of(new User(new UserId("bmarwell"), "Ben"));
        }

        if ("Maarten".equals(name)) {
            return List.of(new User(new UserId("mthmulders"), "Maarten"));
        }

        return List.of();
    }

}
