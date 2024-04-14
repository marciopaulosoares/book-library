package com.mp.booklibrary.dto;

public class UserAddPayload extends UserDto {

    public UserAddPayload(String name, String email, boolean active, int profileType) {
        this.name = name;
        this.email = email;
        this.active = active;
        this.profileType = profileType;
    }
}
