package de.bmarwell.snailspace.demo4.app.db.api;

import de.bmarwell.snailspace.demo4.app.common.value.MailOutboxEntry;
import java.util.List;

public interface MailOutboxRepository {

    // Define methods for interacting with the mail outbox
    void saveMailOutboxEntry(MailOutboxEntry entry);

    List<MailOutboxEntry> getAllMailOutboxEntries();

    void deleteMailOutboxEntry(Long id);

    // Other methods as needed

}
