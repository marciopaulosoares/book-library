package com.mp.booklibrary.repository;

import com.mp.booklibrary.entity.UserProfile;

import java.util.List;


public interface UserRepository {
    List<UserProfile> getAll();
    UserProfile Save(UserProfile entity);
    UserProfile Update(UserProfile entity);
    boolean Delete(UserProfile entity);
}
