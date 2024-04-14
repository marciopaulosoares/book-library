package com.mp.booklibrary.dto;

import com.mp.booklibrary.entity.UserProfile;
import com.mp.booklibrary.utils.EnumUtils;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
@Setter
@Getter
public class UserResponseDto extends UserDto {
    private String id;
    private String profileTypeDescription;
    @Builder
    public UserResponseDto(String name, String email, boolean active, int profileType, String id) {
        super(name, email, active, profileType);
        this.id = id;
    }

    public static List<UserResponseDto> fromEntities(Iterable<UserProfile> entities){
        List<UserResponseDto> users = new ArrayList<UserResponseDto>();
        for(UserProfile user : entities ){
            users.add(fromEntity(user));
        }

        return  users;
    }

    public static  UserResponseDto fromEntity(UserProfile entity){
        UserResponseDto user = UserResponseDto.builder()
                .name(entity.getName())
                .email(entity.getEmail())
                .active(entity.isActive())
                .profileType(entity.getProfileType().getValue())
                .id(entity.getId().toString())
                .build();
        //TODO
        // Encapsulate profile description every type that show user profile data
        user.profileTypeDescription = EnumUtils.getUserProfileTypeDescription(entity.getProfileType().getValue());

        return user;
    }
}
