package de.bmarwell.snailspace.demo4.app.services;

import de.bmarwell.snailspace.demo4.app.common.value.User;
import de.bmarwell.snailspace.demo4.app.common.value.UserGroup;
import de.bmarwell.snailspace.demo4.app.common.value.UserId;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.random.RandomGenerator;

public class JndiLdapService implements LdapService {

    public Optional<User> getUser(UserId userId) {
        try {
            Thread.sleep(Long.parseLong(System.getProperty("method.timeout", "100")));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (userId.value().equals("bmarwell")) {
            return Optional.of(new User(userId, "Benjamin"));
        }

        if (userId.value().equals("mthmulders")) {
            return Optional.of(new User(userId, "Maarten"));
        }

        return Optional.empty();
    }

    public List<UserGroup> getUserGroupNames(UserId userId) {
        try {
            Thread.sleep(Long.parseLong(System.getProperty("method.timeout", "100")));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        List<UserGroup> groups = new ArrayList<>();

        RandomGenerator randomGenerator = RandomGenerator.getDefault();
        for (int i = 0; i < 10; i++) {
            var bb = new byte[24];
            randomGenerator.nextBytes(bb);
            String group = Base64.getEncoder().encodeToString(bb);
            groups.add(new UserGroup(group));
        }

        return Collections.unmodifiableList(groups);
    }
}
