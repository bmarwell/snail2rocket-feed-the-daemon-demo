package de.bmarwell.snailspace.demo4.app.common.randomid;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.UUID;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class RandomIdTest {

    @RepeatedTest(1_000)
    void two_invocations_are_never_the_same() {
        final var id1 = RandomId.randomId();
        final var id2 = RandomId.randomId();

        assertThat(id1).isNotEqualTo(id2);
    }

    @RepeatedTest(1_000)
    void never_equals_uuid() {
        final var id1 = RandomId.randomId();
        final var id2 = UUID.randomUUID();

        assertThat(id1.getValue()).isNotEqualTo(id2.toString());
    }

    @Test
    void is_lowercase() {
        final var id = RandomId.randomId();

        // expect
        assertThat(id.getValue()).isEqualTo(id.getValue().toLowerCase());
    }

    @Test
    void tostring_is_plain_value() {
        final var id = RandomId.randomId();

        // expect
        assertThat(id.toString()).isEqualTo(id.getValue());
    }
}
