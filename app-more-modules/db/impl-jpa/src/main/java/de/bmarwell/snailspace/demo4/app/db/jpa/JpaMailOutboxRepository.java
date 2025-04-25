package de.bmarwell.snailspace.demo4.app.db.jpa;

import de.bmarwell.snailspace.demo4.app.common.value.MailOutboxEntry;
import de.bmarwell.snailspace.demo4.app.db.api.MailOutboxRepository;
import java.util.List;

public class JpaMailOutboxRepository implements MailOutboxRepository {

    @Override
    public void saveMailOutboxEntry(MailOutboxEntry entry) {
        try {
            Thread.sleep(Long.parseLong(System.getProperty("method.timeout")));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<MailOutboxEntry> getAllMailOutboxEntries() {
        try {
            Thread.sleep(Long.parseLong(System.getProperty("method.timeout")));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return List.of();
    }

    @Override
    public void deleteMailOutboxEntry(Long id) {
        try {
            Thread.sleep(Long.parseLong(System.getProperty("method.timeout")));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
