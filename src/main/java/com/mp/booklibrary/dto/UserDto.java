package com.mp.booklibrary.dto;

import com.mp.booklibrary.entity.UserProfile;

import java.util.List;
import java.util.stream.Collectors;

public class UserDto {
    private Long Id;
    private String Name;
    private String Email;
    private boolean Active;

    public UserDto(Long id, String name, String email, boolean active) {
        Id = id;
        Name = name;
        Email = email;
        Active = active;
    }

    public UserDto() {
    }

    public static  UserDto fromEntity(UserProfile entity){
        if(entity == null){
            return new UserDto();
        }

        return  new UserDto(entity.getId(), entity.getName(), entity.getEmail(), entity.isActive());
    }

    public static List<UserDto> fromEntities(List<UserProfile> entities){
        return entities.stream().map( u -> fromEntity(u)).collect(Collectors.toList());
    }

    public Long getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public String getEmail() {
        return Email;
    }

    public boolean isActive() {
        return Active;
    }
}
