package de.bmarwell.snailspace.demo4.app.services.api;

import java.net.URI;
import java.time.Instant;
import java.util.Optional;

public record GitHubUserStats(String username, Optional<URI> avatarUri, long numberOfRepositories, long numberOfFollowers, Instant profileCreatedAt) {

}
