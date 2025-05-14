package de.bmarwell.snailspace.demo4.app.services.api.commands;

import java.util.Optional;

public interface CommandResponse {

    default Optional<Throwable> failedWith() {
        return Optional.empty();
    }

}
