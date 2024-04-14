package com.mp.booklibrary.entity;

import com.mp.booklibrary.enums.UserProfileType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
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

    public UserProfile(String name, String email, UserProfileType profileType, boolean active) {
        this.name = name;
        this.email = email;
        this.active = active;
        this.profileType = profileType;
    }
}