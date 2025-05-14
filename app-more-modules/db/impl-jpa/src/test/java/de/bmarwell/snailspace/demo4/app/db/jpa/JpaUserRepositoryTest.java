package de.bmarwell.snailspace.demo4.app.db.jpa;

import static org.assertj.core.api.Assertions.assertThat;

import de.bmarwell.snailspace.demo4.app.common.value.User;
import de.bmarwell.snailspace.demo4.app.common.value.UserId;
import java.util.Optional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(DbTestExtension.class)
class JpaUserRepositoryTest {

    private JpaUserRepository service;

    @BeforeEach
    void setUp(JpaUserRepository service) {
        this.service = service;
    }

    @Test
    void user_by_id_empty() {
        // when
        final Optional<User> optionalUser = service.getUserById(new UserId("unknown"));

        // then
        assertThat(optionalUser).isNotPresent();
    }

    @Test
    void user_by_id_mthmulders() {
        // when
        final Optional<User> optionalUser = service.getUserById(new UserId("mthmulders"));

        // then
        assertThat(optionalUser).isPresent();
    }

    @Test
    void user_by_id_bmarwell() {
        // when
        final Optional<User> optionalUser = service.getUserById(new UserId("bmarwell"));

        // then
        assertThat(optionalUser).isPresent();
    }


    // byNameTests

    @Test
    void user_by_name_unknown() {
        // when
        final var users = service.getUserByName("unknown");

        // then
        assertThat(users).isEmpty();
    }

    @Test
    void user_by_name_ben() {
        // when
        final var users = service.getUserByName("Ben");

        // then
        assertThat(users).hasSize(1);
    }

    @Test
    void user_by_name_maarten() {
        // when
        final var users = service.getUserByName("Maarten");

        // then
        assertThat(users).hasSize(1);
    }

}
