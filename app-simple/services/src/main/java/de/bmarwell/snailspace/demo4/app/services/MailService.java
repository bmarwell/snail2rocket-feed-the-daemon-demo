package de.bmarwell.snailspace.demo4.app.services;

import java.util.List;

public interface MailService {

    MailSendStatus sendMail(String from, String to, String subject, String body);

    List<MailOutQueueItem> getMailOutQueue();
}
