package com.mp.booklibrary.service;

import com.mp.booklibrary.dto.UserDto;
import com.mp.booklibrary.dto.UserResponseDto;
import com.mp.booklibrary.entity.UserProfile;

import java.util.List;

public interface UserService {
    List<UserResponseDto> findAll();
    UserResponseDto Save(UserProfile entity);
    UserResponseDto Update(UserProfile entity);
    boolean Delete(Long id);
}
