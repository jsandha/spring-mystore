package org.sandha.store.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class UserTagId implements Serializable {
    private static final long serialVersionUID = -1850069223487031262L;
    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "tag_id", nullable = false)
    private Integer tagId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UserTagId entity = (UserTagId) o;
        return Objects.equals(this.tagId, entity.tagId) &&
                Objects.equals(this.userId, entity.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tagId, userId);
    }

}