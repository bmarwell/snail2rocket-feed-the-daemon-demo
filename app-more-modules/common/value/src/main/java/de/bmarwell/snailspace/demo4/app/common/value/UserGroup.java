package de.bmarwell.snailspace.demo4.app.common.value;

public record UserGroup(String groupName, GroupState groupState) {

    public UserGroup(String groupName) {
        this(groupName, GroupState.PUBLIC);
    }

    enum GroupState {
        PUBLIC,
        DEPRECATED,
        HIDDEN,
        INVALID
    }
}
