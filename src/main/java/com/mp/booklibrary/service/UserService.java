package com.mp.booklibrary.service;

import com.mp.booklibrary.dto.UserDto;
import com.mp.booklibrary.entity.UserProfile;

import java.util.List;

public interface UserService {
    List<UserDto> getAll();
    UserDto Save(UserProfile entity);
    UserDto Update(UserProfile entity);
    boolean Delete(UserProfile entity);
}
