package de.bmarwell.snailspace.demo4.app.services.commands;

import static org.assertj.core.api.Assertions.assertThat;

import de.bmarwell.snailspace.demo4.app.common.value.MailId;
import de.bmarwell.snailspace.demo4.app.services.api.MailOutQueueItem;
import de.bmarwell.snailspace.demo4.app.services.api.MailSendStatus;
import de.bmarwell.snailspace.demo4.app.services.api.MailService;
import de.bmarwell.snailspace.demo4.app.services.api.commands.SendMailCommand;
import de.bmarwell.snailspace.demo4.app.services.api.commands.SendMailResponse;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

class SendMailCommandHandlerTest {

    SendMailCommandHandler service;

    @BeforeEach
    void setUp() {
        service = new SendMailCommandHandler();
        service.setMailService(new DummyMailService());
    }

    @RepeatedTest(5)
    void sendmail_never_fails() {
        final var command = new SendMailCommand(
            "Maarten <maarten@it.invalid>",
            List.of("Ben <ben@domain.invalid>"),
            "snail2rocket",
            "body"
        );

        // when
        SendMailResponse mailResponse = service.execute(command);

        // then
        assertThat(mailResponse).isNotNull();
        assertThat(mailResponse.sentMailId()).isNotNull();
    }

    @RepeatedTest(5)
    void always_fails_on_invalid_address() {
        final var command = new SendMailCommand(
            "Maarten <maarten_at_it.invalid>",
            List.of("Ben <ben_at_domain.invalid>"),
            "snail2rocket",
            "body"
        );

        // when
        SendMailResponse mailResponse = service.execute(command);

        // then
        assertThat(mailResponse).isNotNull();
        assertThat(mailResponse.failedWith()).isPresent();
    }

    static class DummyMailService implements MailService {
        @Override
        public MailSendStatus sendMail(String from, String to, String subject, String body) {
            return new MailSendStatus(new MailId(UUID.randomUUID()), "success") ;
        }

        @Override
        public List<MailOutQueueItem> getMailOutQueue() {
            return List.of();
        }
    }

}
