package de.bmarwell.snailspace.demo4.app.services;

import de.bmarwell.snailspace.demo4.app.common.value.MailId;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

public class MailServiceImpl implements MailService{

    @Override
    public MailSendStatus sendMail(String from, String to, String subject, String body) {
        try {
            Thread.sleep(Long.parseLong(System.getProperty("method.timeout", "100")));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (!from.contains("@")) {
            return new MailSendStatus(new MailId(UUID.randomUUID()), "invalid sender");
        }

        if (!to.contains("@")) {
            return new MailSendStatus(new MailId(UUID.randomUUID()), "invalid recipient");
        }

        return new MailSendStatus(new MailId(UUID.randomUUID()), "sent");
    }


    @Override
    public List<MailOutQueueItem> getMailOutQueue() {
        try {
            Thread.sleep(Long.parseLong(System.getProperty("method.timeout", "100")));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return List.of(
            new MailOutQueueItem(
                Instant.EPOCH, new MailSendStatus(new MailId(UUID.randomUUID()), "queued")),
            new MailOutQueueItem(Instant.now(), new MailSendStatus(new MailId(UUID.randomUUID()), "queued"))
        );
    }
}
