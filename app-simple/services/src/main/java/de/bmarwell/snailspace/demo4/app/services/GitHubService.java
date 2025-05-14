package de.bmarwell.snailspace.demo4.app.services;

import java.util.List;
import java.util.Optional;

public interface GitHubService {

    List<String> queryRepositories(String searchTerm);

    Optional<GitHubUserStats> queryGitHubUserStats(String searchTerm);
}
