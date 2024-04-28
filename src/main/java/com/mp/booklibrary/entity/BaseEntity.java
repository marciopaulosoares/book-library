package com.mp.booklibrary.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@MappedSuperclass
public class BaseEntity {
    @Id
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, unique = true, nullable = false)
    protected UUID id;
    @Column(name = "removed")
    private boolean removed;
    @Column(name = "creation_date")
    private LocalDateTime creationDate;
    @Column(name = "update_date", nullable = true)
    private LocalDateTime updateDate;

    public UUID getId() {
        return id;
    }

    public BaseEntity() {

        id = UUID.randomUUID();
        creationDate = LocalDateTime.now();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseEntity that = (BaseEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
