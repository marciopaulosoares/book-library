package com.mp.booklibrary.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "book")
public class Book extends BaseEntity{

    @Column(name = "isbn", nullable = true)
    private String isbn;

    @Column(name = "title", nullable = true)
    private String title;

    @Column(name = "category", nullable = true)
    private String category;

    @Column(name="synopsis", nullable=true, length = 700)
    private String synopsis;

    @Column(name="removed", nullable = false)
    private boolean removed;
}
