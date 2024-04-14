package com.mp.booklibrary.repository;

import com.mp.booklibrary.entity.UserProfile;
import com.mp.booklibrary.enums.UserProfileType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<UserProfile, Long> {
    List<UserProfile> findByNameIgnoreCaseContaining(String name);
    List<UserProfile> findByProfileType(int type);

}
