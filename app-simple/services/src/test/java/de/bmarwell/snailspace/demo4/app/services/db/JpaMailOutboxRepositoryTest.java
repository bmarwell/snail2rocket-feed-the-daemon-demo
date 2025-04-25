package de.bmarwell.snailspace.demo4.app.services.db;

import static org.assertj.core.api.Assertions.assertThat;

import de.bmarwell.snailspace.demo4.app.common.value.MailOutboxEntry;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class JpaMailOutboxRepositoryTest {

    @Test
    void test_send_mail() {
        final JpaMailOutboxRepository service = new JpaMailOutboxRepository();
        final MailOutboxEntry entry = new MailOutboxEntry(
            1L,
            "mthmulders@maarten.invalid",
            "bmarwell@ben.invalid",
            "Test Subject",
            "Test Body"
        );

        // when
        service.saveMailOutboxEntry(entry);

        // assert no exception
    }

    @Test
    void all_entries_empty() {
        final JpaMailOutboxRepository service = new JpaMailOutboxRepository();

        // when
        final var entries = service.getAllMailOutboxEntries();

        // then
        assertThat(entries).isEmpty();
    }

}
