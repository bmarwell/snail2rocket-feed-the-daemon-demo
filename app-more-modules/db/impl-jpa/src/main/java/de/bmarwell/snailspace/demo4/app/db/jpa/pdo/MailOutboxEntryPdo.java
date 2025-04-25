package de.bmarwell.snailspace.demo4.app.db.jpa.pdo;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.StringJoiner;

@Entity
public class MailOutboxEntryPdo {

    @Id
    Long id;

    String sender;

    String recipient;

    String subject;

    String body;

    public MailOutboxEntryPdo() {
    }

    public MailOutboxEntryPdo(Long id, String sender, String recipient, String subject,
        String body) {
        this.id = id;
        this.sender = sender;
        this.recipient = recipient;
        this.subject = subject;
        this.body = body;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", MailOutboxEntryPdo.class.getSimpleName() + "[", "]")
            .add("id=" + id)
            .toString();
    }
}
