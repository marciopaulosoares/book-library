package com.mp.booklibrary.entity;

import com.mp.booklibrary.enums.UserProfileType;
import jakarta.persistence.*;

@Entity
@Table(name = "user_profile")
public class UserProfile extends BaseEntity {

    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "active")
    private boolean active;



    @Column(name="profile_type")
    @Enumerated(EnumType.ORDINAL)
    private UserProfileType profileType;

    public UserProfile(Long id, String name, String email, UserProfileType profileType, boolean active) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.active = active;
        this.profileType = profileType;
    }

    public UserProfile() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public UserProfileType getProfileType() {
        return profileType;
    }

    public void setProfileType(UserProfileType profileType) {
        this.profileType = profileType;
    }
}
