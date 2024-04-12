package com.mp.booklibrary.repository;

import com.mp.booklibrary.entity.UserProfile;
import com.mp.booklibrary.enums.UserProfileType;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface UserRepository extends CrudRepository<UserProfile, Long> {
    List<UserProfile> findByNameIgnoreCaseContaining(String name);
    List<UserProfile> findByUserProfileType(UserProfileType type);

}
