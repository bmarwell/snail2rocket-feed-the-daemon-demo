package de.bmarwell.snailspace.demo4.app.services;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class MailServiceImplTest {

    @Test
    void test() {
        final MailService service = new MailServiceImpl();

        // when
        final MailSendStatus mailSendStatus = service.sendMail("mail@mthmulders.invalid",
            "bmarwell@apache.invalid", "Test", "Test");

        // then
        assertThat(mailSendStatus).isNotNull();
        assertThat(mailSendStatus.status()).isEqualTo("sent");
    }

    @Test
    void expect_failure_invalid_sender() {
        final MailService service = new MailServiceImpl();

        // when
        final MailSendStatus mailSendStatus = service.sendMail("mail at mthmulders.invalid",
            "bmarwell@apache.invalid", "Test", "Test");

        // then
        assertThat(mailSendStatus).isNotNull();
        assertThat(mailSendStatus.status()).isEqualTo("invalid sender");
    }

    @Test
    void expect_failure_invalid_recipient() {
        final MailService service = new MailServiceImpl();

        // when
        final MailSendStatus mailSendStatus = service.sendMail("mail@mthmulders.invalid",
            "bmarwell_at_apache.invalid", "Test", "Test");

        // then
        assertThat(mailSendStatus).isNotNull();
        assertThat(mailSendStatus.status()).isEqualTo("invalid recipient");
    }

    @RepeatedTest(10)
    void queue_doesnt_empty() {
        // given
        final MailServiceImpl service = new MailServiceImpl();

        // when
        List<MailOutQueueItem> mailOutQueue = service.getMailOutQueue();

        // then
        assertThat(mailOutQueue).isNotEmpty();
        assertThat(mailOutQueue).hasSize(2);
    }
}
