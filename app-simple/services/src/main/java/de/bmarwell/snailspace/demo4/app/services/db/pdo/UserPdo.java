package de.bmarwell.snailspace.demo4.app.services.db.pdo;

import de.bmarwell.snailspace.demo4.app.common.value.UserId;
import de.bmarwell.snailspace.demo4.app.services.db.converter.UserIdConverter;
import jakarta.persistence.Basic;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "USERS")
public class UserPdo {

    @Id
    @Basic
    @Convert(converter = UserIdConverter.class)
    UserId userId;

    String name;

    public UserPdo() {}

    public UserPdo(UserId userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    public UserId getUserId() {
        return userId;
    }

    public void setUserId(UserId userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
