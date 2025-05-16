package de.bmarwell.snailspace.demo4.app.services.api.commands;

import java.util.List;

public record SendMailCommand(String from, List<String> to, String subject, String body) implements ExecutableCommand<SendMailResponse> {

}
