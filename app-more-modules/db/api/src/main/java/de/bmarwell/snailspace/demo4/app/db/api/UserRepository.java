package de.bmarwell.snailspace.demo4.app.db.api;

import de.bmarwell.snailspace.demo4.app.common.value.User;
import de.bmarwell.snailspace.demo4.app.common.value.UserId;
import java.util.List;
import java.util.Optional;

public interface UserRepository {

    Optional<User> getUserById(UserId userId);

    List<User> getUserByName(String name);
}
