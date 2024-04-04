package com.mp.booklibrary.service;

import com.mp.booklibrary.dto.UserDto;
import com.mp.booklibrary.entity.UserProfile;
import com.mp.booklibrary.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;
    @Override
    public List<UserDto> getAll() {
        return UserDto.fromEntities(userRepository.getAll());
    }

    @Override
    public UserDto Save(UserProfile entity) {
        return UserDto.fromEntity(userRepository.Save(entity));
    }

    @Override
    public UserDto Update(UserProfile entity) {
        return UserDto.fromEntity(userRepository.Update(entity));
    }

    @Override
    public boolean Delete(UserProfile entity) {
        return userRepository.Delete(entity);
    }
}
