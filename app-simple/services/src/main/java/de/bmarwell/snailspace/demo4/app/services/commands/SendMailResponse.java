package de.bmarwell.snailspace.demo4.app.services.commands;

import de.bmarwell.snailspace.demo4.app.common.value.MailId;
import java.util.Optional;

public record SendMailResponse(MailId sentMailId, Optional<Throwable> failedWith) implements CommandResponse {

    public static SendMailResponse ofError(Throwable error) {
        return new SendMailResponse(null, Optional.of(error));
    }

    public static SendMailResponse ofSuccess(MailId sentMailId) {
        return new SendMailResponse(sentMailId, Optional.empty());
    }

}
