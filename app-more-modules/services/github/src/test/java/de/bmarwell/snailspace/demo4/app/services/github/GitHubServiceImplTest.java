package de.bmarwell.snailspace.demo4.app.services.github;

import static org.assertj.core.api.Assertions.assertThat;

import de.bmarwell.snailspace.demo4.app.services.api.GitHubUserStats;
import java.util.List;
import java.util.Optional;
import java.util.random.RandomGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class GitHubServiceImplTest {

    @Test
    void test() {
        final GitHubServiceImpl service = new GitHubServiceImpl();

        // when
        final List<String> repositories = service.queryRepositories("someone");

        // then
        assertThat(repositories).isEmpty();
    }

    @Test
    void find_bmarwell() {
        final GitHubServiceImpl service = new GitHubServiceImpl();

        // when
        final List<String> repositories = service.queryRepositories("bmarwell");

        // then
        Assertions.assertThat(repositories).isNotEmpty();
        Assertions.assertThat(repositories).contains("snailspace");
    }

    @Test
    void find_mthmulders() {
        final GitHubServiceImpl service = new GitHubServiceImpl();

        // when
        final List<String> repositories = service.queryRepositories("mthmulders");

        // then
        Assertions.assertThat(repositories).isNotEmpty();
        Assertions.assertThat(repositories).contains("snailspace");
    }

    @RepeatedTest(10)
    void finds_nothing_on_random_input() {
        // given
        final GitHubServiceImpl service = new GitHubServiceImpl();
        RandomGenerator randomGenerator = RandomGenerator.getDefault();
        Integer number = randomGenerator.nextInt();
        String searchTerm = number.toString();

        // when
        Optional<GitHubUserStats> queriedGitHubUserStats = service.queryGitHubUserStats(searchTerm);

        // then
        assertThat(queriedGitHubUserStats).isEmpty();
    }

    @Test
    void finds_maartens_stats() {
        final GitHubServiceImpl service = new GitHubServiceImpl();

        // when
        Optional<GitHubUserStats> stats = service.queryGitHubUserStats("mthmulders");

        // then
        assertThat(stats).isPresent();
        GitHubUserStats userStats = stats.orElseThrow();

        assertThat(userStats.avatarUri()).isPresent();
        assertThat(userStats.avatarUri().orElseThrow().toString()).startsWith("https://");
    }

    @Test
    void finds_bens_stats() {
        final GitHubServiceImpl service = new GitHubServiceImpl();

        // when
        Optional<GitHubUserStats> stats = service.queryGitHubUserStats("bmarwell");

        // then
        assertThat(stats).isPresent();
        GitHubUserStats userStats = stats.orElseThrow();

        assertThat(userStats.avatarUri()).isPresent();
        assertThat(userStats.avatarUri().orElseThrow().toString()).startsWith("https://");
    }

    @Test
    void maarten_has_more_repositores() {
        final GitHubServiceImpl service = new GitHubServiceImpl();

        // when
        GitHubUserStats maarten = service.queryGitHubUserStats("mthmulders").orElseThrow();
        GitHubUserStats ben = service.queryGitHubUserStats("bmarwell").orElseThrow();

        // then
        assertThat(maarten.numberOfRepositories()).isGreaterThan(ben.numberOfRepositories());
    }
}
