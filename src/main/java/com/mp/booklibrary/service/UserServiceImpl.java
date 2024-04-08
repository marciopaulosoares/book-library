package com.mp.booklibrary.service;

import com.mp.booklibrary.dto.UserDto;
import com.mp.booklibrary.entity.UserProfile;
import com.mp.booklibrary.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserDto> findAll() {

        return UserDto.fromEntities(userRepository.findAll());
    }

    @Override
    public UserDto Save(UserProfile entity) {
        return UserDto.fromEntity(userRepository.save(entity));
    }

    @Override
    public UserDto Update(UserProfile entity) {

        return UserDto.fromEntity(userRepository.save(entity));
    }

    @Override
    public boolean Delete(Long id) {
        Optional<UserProfile> user = userRepository.findById(id);
        if(!user.isEmpty()){
            userRepository.delete(user.get());
            return  true;
        }
        return  false;
    }
}
