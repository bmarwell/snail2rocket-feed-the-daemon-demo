package de.bmarwell.snailspace.demo4.app.services.api;

import java.time.Instant;

/**
 * Queue status, should contain more than just those two values.
 * @param queuedAt when the mail was put into the queue.
 * @param status the status of the mail.
 */
public record MailOutQueueItem(Instant queuedAt, MailSendStatus status) {

}
