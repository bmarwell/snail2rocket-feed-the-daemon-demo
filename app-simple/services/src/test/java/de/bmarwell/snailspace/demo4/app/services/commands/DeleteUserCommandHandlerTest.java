package de.bmarwell.snailspace.demo4.app.services.commands;

import static org.assertj.core.api.Assertions.assertThat;

import de.bmarwell.snailspace.demo4.app.common.value.UserId;
import org.junit.jupiter.api.Test;

class DeleteUserCommandHandlerTest {

    @Test
    void delete_someone() {
        final DeleteUserCommandHandler service = new DeleteUserCommandHandler();
        final var command = new DeleteUserCommand(new UserId("test"));

        // when
        final DeleteUserResponse deleteUserResponse = service.execute(command);

        // then
        assertThat(deleteUserResponse).isNotNull();
    }

    @Test
    void delete_mthmulders() {
        final DeleteUserCommandHandler service = new DeleteUserCommandHandler();
        final var command = new DeleteUserCommand(new UserId("mthmulders"));

        // when
        final DeleteUserResponse deleteUserResponse = service.execute(command);

        // then
        assertThat(deleteUserResponse).isNotNull();
    }

    @Test
    void delete_bmarwell() {
        final DeleteUserCommandHandler service = new DeleteUserCommandHandler();
        final var command = new DeleteUserCommand(new UserId("bmarwell"));

        // when
        final DeleteUserResponse deleteUserResponse = service.execute(command);

        // then
        assertThat(deleteUserResponse).isNotNull();
    }

}
