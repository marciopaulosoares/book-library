package com.mp.booklibrary.dto;

import com.mp.booklibrary.entity.UserProfile;
import com.mp.booklibrary.utils.EnumUtils;
import lombok.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto{
    protected String name;
    protected String email;
    protected boolean active;
    protected int profileType;

    public UserProfile toEntity(){
        return new UserProfile(
                name,
                email,
                EnumUtils.getUserProfileType(profileType),
                active
        );
    }
}
