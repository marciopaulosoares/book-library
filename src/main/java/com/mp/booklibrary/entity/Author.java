package com.mp.booklibrary.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "author")
public class Author extends BaseEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "date_birth", nullable = true)
    private Date dateBirth;

    @Column(name = "date_death", nullable = true)
    private Date dateDeath;

    @Column(name = "bio", nullable = true, length = 1000)
    private String bio;
}
