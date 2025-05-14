package de.bmarwell.snailspace.demo4.app.services.db;

import de.bmarwell.snailspace.demo4.app.common.value.User;
import de.bmarwell.snailspace.demo4.app.common.value.UserId;
import de.bmarwell.snailspace.demo4.app.services.db.mapper.UserMapper;
import de.bmarwell.snailspace.demo4.app.services.db.pdo.UserPdo;
import de.bmarwell.snailspace.demo4.app.services.db.pdo.UserPdo_;
import jakarta.annotation.Resource;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

public class JpaUserRepository implements UserRepository {

    @PersistenceContext
    EntityManager em;

    public JpaUserRepository() {
        // cdi
    }

    public JpaUserRepository(EntityManagerFactory emf) {
        this.em = emf.createEntityManager();
    }

    @Override
    public Optional<User> getUserById(UserId userId) {
        try {
            Thread.sleep(Long.parseLong(System.getProperty("method.timeout")));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<UserPdo> query = cb.createQuery(UserPdo.class);
        Root<UserPdo> from = query.from(UserPdo.class);
        query.where(
            cb.equal(from.get(UserPdo_.userId), userId)
        );

        return em.createQuery(query).getResultList().stream().findFirst().map(UserMapper::toDomain);
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
