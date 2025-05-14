package de.bmarwell.snailspace.demo4.app.services.db;

import de.bmarwell.snailspace.demo4.app.common.value.UserId;
import de.bmarwell.snailspace.demo4.app.services.db.pdo.UserPdo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.concurrent.ConcurrentHashMap;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ExtensionContext.Store;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

public class DbTestExtension implements AfterEachCallback, BeforeEachCallback, ParameterResolver {

    private static final ExtensionContext.Namespace NAMESPACE = ExtensionContext.Namespace.create(DbTestExtension.class);

    protected EntityManagerFactory newEntityManagerFactory(String testname) {
        var properties = new ConcurrentHashMap<String, String>();
        properties.put("jakarta.persistence.jdbc.driver", org.hsqldb.jdbc.JDBCDriver.class.getName());
        properties.put("jakarta.persistence.jdbc.url", String.format("jdbc:hsqldb:mem:%s", testname));
        properties.put("jakarta.persistence.jdbc.user", "SA");

        properties.put("eclipselink.ddl-generation", "create-tables");

        return Persistence.createEntityManagerFactory("UserData", properties);
    }

    @Override
    public void beforeEach(ExtensionContext context) {
        String testname = String.format("%s_%s", context.getRequiredTestClass().getSimpleName(), context.getRequiredTestMethod().getName());
        Store store = context.getStore(NAMESPACE);
        EntityManagerFactory emf = newEntityManagerFactory(testname);
        store.put("emf", emf);

        JpaUserRepository jpaUserRepository = new JpaUserRepository(emf);
        store.put("jpaUserRepository", jpaUserRepository);

        // insert test data
        try (var em = emf.createEntityManager()) {
            em.getTransaction().begin();

            var maarten = new UserPdo(new UserId("mthmulders"), "Maarten");
            var ben = new UserPdo(new UserId("bmarwell"), "Ben");

            em.persist(maarten);
            em.persist(ben);

            em.getTransaction().commit();
        }
    }

    @Override
    public boolean supportsParameter(ParameterContext parameterContext,
        ExtensionContext extensionContext) throws ParameterResolutionException {
        return parameterContext.getParameter().getType().isAssignableFrom(JpaUserRepository.class);
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext,
        ExtensionContext extensionContext) throws ParameterResolutionException {
        ExtensionContext.Store store = extensionContext.getStore(NAMESPACE);

        return store.get("jpaUserRepository", JpaUserRepository.class);
    }

    @SuppressWarnings("resource")
    @Override
    public void afterEach(ExtensionContext context) {
        Store store = context.getStore(NAMESPACE);
        store.remove("jpaUserRepository", JpaUserRepository.class);

        EntityManagerFactory emf = store.get("emf", EntityManagerFactory.class);
        emf.close();
        store.remove("emf", EntityManagerFactory.class);
    }
}
