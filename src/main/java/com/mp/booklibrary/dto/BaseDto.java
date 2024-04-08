package com.mp.booklibrary.dto;

import jakarta.persistence.MappedSuperclass;

import java.io.Serializable;
import java.util.Optional;

@MappedSuperclass
public abstract class BaseDto implements Serializable {
    public BaseDto(Optional<Long> id) {
        this.id = id;
    }

    protected Optional<Long> id;

    public Optional<Long> getId() {
        return id;
    }

    public void setId(Optional<Long> id) {
        this.id = id;
    }
}
