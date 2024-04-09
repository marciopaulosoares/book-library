package com.mp.booklibrary.dto;

import com.mp.booklibrary.entity.UserProfile;
import com.mp.booklibrary.enums.UserProfileType;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDto extends BaseDto {
    private String name;
    private String email;
    private boolean active;
    private int profileType;
    private String profileTypeDescription;

    public UserDto(String name, String email, boolean active, Optional<Long> id, int profileType) {
        super(id);
        this.name = name;
        this.email = email;
        this.active = active;
        this.profileType = profileType;
    }

    public UserDto() {
        super(Optional.empty());
    }

    public UserProfile toEntity(){
        return new UserProfile(
                id.isPresent() ? id.get() : 0,
                name,
                email,
                UserProfileType.values()[profileType],
                active
        );
    }

    public static  UserDto fromEntity(UserProfile entity){
        if(entity == null){
            return new UserDto(
                    entity.getName(),
                    entity.getEmail(),
                    entity.isActive(),
                    Optional.ofNullable(entity.getId()),
                    entity.getProfileType().getValue()
            );
        }

        return  new UserDto(
                    entity.getName(),
                    entity.getEmail(),
                    entity.isActive(),
                    Optional.of(entity.getId()),
                    entity.getProfileType().getValue()
        );
    }

    public static List<UserDto> fromEntities(Iterable<UserProfile> entities){
        List<UserDto> users = new ArrayList<UserDto>();
         for(UserProfile user : entities ){
             users.add(fromEntity(user));
         }

         return  users;
    }

    public boolean isActive() {
        return active;
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

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getProfileType() {
        return profileType;
    }

    public void setProfileType(int profileType) {
        this.profileType = profileType;
    }

    public String getProfileTypeDescription() {
        return profileTypeDescription;
    }
    private  void setProfileTypeDescription(int profileType){
        for (UserProfileType p : UserProfileType.values()){
            if(p.getValue() == profileType){
                profileTypeDescription = p.getName();
            }
        }
    }
}
