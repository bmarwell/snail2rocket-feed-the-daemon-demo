package de.bmarwell.snailspace.demo4.app.services;

import de.bmarwell.snailspace.demo4.app.common.value.User;
import de.bmarwell.snailspace.demo4.app.common.value.UserId;
import java.util.Map;
import java.util.Optional;
import java.util.WeakHashMap;

abstract class AbstractCachingUserService implements UserService {

    private final Map<UserId, User> cache = new WeakHashMap<>();

    @Override
    public Optional<User> getUserById(UserId userId) {
        if (this.cache.containsKey(userId)) {
            // TODO: cache invalidation
            return Optional.ofNullable(this.cache.get(userId));
        }

        Optional<User> user = doGetUserFromDatabase(userId);
        if (user.isEmpty()) {
            return Optional.empty();
        }

        this.cache.put(userId, user.orElseThrow());

        return user;
    }

    protected abstract Optional<User> doGetUserFromDatabase(UserId userId);
}
