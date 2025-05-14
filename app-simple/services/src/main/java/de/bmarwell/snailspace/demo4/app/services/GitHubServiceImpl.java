package de.bmarwell.snailspace.demo4.app.services;

import java.net.URI;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

public class GitHubServiceImpl implements GitHubService {

    @Override
    public List<String> queryRepositories(String searchTerm) {
        try {
            Thread.sleep(Long.parseLong(System.getProperty("method.timeout", "100")));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (searchTerm.contains("bmarwell")) {
            return List.of("bmarwell", "snailspace");
        }

        if (searchTerm.contains("mthmulders")) {
            return List.of("mthmulders", "snailspace");
        }

        return List.of();
    }

    @Override
    public Optional<GitHubUserStats> queryGitHubUserStats(String searchTerm) {
        try {
            Thread.sleep(Long.parseLong(System.getProperty("method.timeout", "100")));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (searchTerm.contains("bmarwell")) {
            return Optional.of(
                new GitHubUserStats(
                    "bmarwell",
                    Optional.of(URI.create("https://avatars.githubusercontent.com/u/1413391?v=4")),
                    93L,
                    64L,
                    Instant.EPOCH
                )
            );
        }

        if (searchTerm.contains("mthmulders")) {
            return Optional.of(
                new GitHubUserStats(
                    "mthmulders",
                    Optional.of(URI.create("https://avatars.githubusercontent.com/u/430114?v=4")),
                    186L,
                    86L,
                    Instant.EPOCH
                )
            );
        }

        return Optional.empty();
    }
}
