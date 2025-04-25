package de.bmarwell.snailspace.demo4.app.common.value;

public record MailOutboxEntry(Long id, String sender, String recipient, String subject, String body) {

}
