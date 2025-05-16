package de.bmarwell.snailspace.demo4.app.services.user;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import de.bmarwell.snailspace.demo4.app.common.value.User;
import de.bmarwell.snailspace.demo4.app.common.value.UserId;
import java.util.Optional;
import org.junit.jupiter.api.Test;

class UserServiceImplTest {

    @Test
    void test() {
        final UserServiceImpl userService = new UserServiceImpl();
        final UserId mthmulders = new UserId("mthmulders");

        // when
        final User maarten = userService.updateUser(mthmulders, new User(mthmulders, "Maarten"));

        // then
        assertThat(maarten).isNotNull();
    }

    @Test
    void get_user_by_id() {
        // given
        final UserServiceImpl userService = spy(new UserServiceImpl());
        final UserId mthmulders = new UserId("mthmulders");

        // when
        User userById = userService.getUserById(mthmulders).orElseThrow();
        User userById2 = userService.getUserById(mthmulders).orElseThrow();
        User userById3 = userService.getUserById(mthmulders).orElseThrow();

        // then
        assertThat(userById).isEqualTo(userById2).isEqualTo(userById3);
        // verify cache was used
        verify(userService, times(1)).doGetUserFromDatabase(mthmulders);
    }

    @Test
    void get_unknown_user() {
        // given
        final UserServiceImpl userService = spy(new UserServiceImpl());
        final UserId someone = new UserId("someone");

        // when
        Optional<User> userById = userService.getUserById(someone);
        Optional<User> userById2 = userService.getUserById(someone);
        Optional<User> userById3 = userService.getUserById(someone);

        // then
        assertThat(userById).isEmpty();
        assertThat(userById2).isEmpty();
        assertThat(userById3).isEmpty();
        // in a real application, you would cache the empty result instead.
        verify(userService, times(3)).doGetUserFromDatabase(someone);
    }
}
