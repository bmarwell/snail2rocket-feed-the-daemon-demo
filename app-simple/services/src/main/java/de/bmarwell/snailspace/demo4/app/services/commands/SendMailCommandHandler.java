package de.bmarwell.snailspace.demo4.app.services.commands;

import de.bmarwell.snailspace.demo4.app.services.MailSendStatus;
import de.bmarwell.snailspace.demo4.app.services.MailService;
import jakarta.inject.Inject;

public class SendMailCommandHandler implements CommandHandler<SendMailCommand, SendMailResponse> {

    @Inject
    MailService mailService;

    @Override
    public boolean canHandle(Class<ExecutableCommand<?>> commandClass) {
        return commandClass.isAssignableFrom(SendMailCommand.class);
    }

    @Override
    public SendMailResponse execute(SendMailCommand command) {
        try {
            Thread.sleep(Long.parseLong(System.getProperty("method.timeout")));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (!command.from().contains("@")) {
            return SendMailResponse.ofError(new IllegalArgumentException("invalid mail address: " + command.from()));
        }

        MailSendStatus mailSendStatus = mailService.sendMail(
            command.from(),
            // TODO: swallows recipients
            command.to().getFirst(),
            command.subject(),
            command.body()
        );

        return SendMailResponse.ofSuccess(mailSendStatus.mailId());
    }

    public void setMailService(MailService mailService) {
        this.mailService = mailService;
    }
}
