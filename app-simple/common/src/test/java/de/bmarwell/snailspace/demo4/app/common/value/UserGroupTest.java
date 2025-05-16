package de.bmarwell.snailspace.demo4.app.common.value;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Base64;
import java.util.random.RandomGenerator;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class UserGroupTest {

    @Test
    void groupname_has_default_state() {
        // given
        var group = new UserGroup("test");

        // then
        assertThat(group.groupState()).isEqualTo(UserGroup.GroupState.PUBLIC);
    }

    @RepeatedTest(10)
    void tostring_contains_groupname() {
        // given
        byte[] bb = new byte[64];
        RandomGenerator.getDefault().nextBytes(bb);
        String groupName = Base64.getEncoder().encodeToString(bb);
        var group = new UserGroup(groupName);

        // then
        assertThat(group.toString()).contains(groupName);
    }
}
