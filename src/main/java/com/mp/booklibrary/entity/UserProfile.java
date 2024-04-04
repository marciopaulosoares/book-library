package com.mp.booklibrary.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user_profile")
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long Id;
    @Column(name = "name", nullable = false)
    private String Name;
    @Column(name = "email", nullable = false)
    private String Email;
    @Column(name = "active")
    private boolean Active;

    public UserProfile(Long id, String name, String email, boolean active) {

        Id = id;
        Name = name;
        Email = email;
        Active = active;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public boolean isActive() {
        return Active;
    }

    public void setActive(boolean active) {
        Active = active;
    }
}
