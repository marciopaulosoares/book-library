package com.mp.booklibrary.repository;

import com.mp.booklibrary.entity.UserProfile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class UserRepositoryImpl implements UserRepository {
    @Override
    public List<UserProfile> getAll() {
        List<UserProfile> users = new ArrayList<>();
        users.add(new UserProfile(1L, "user1", "user1@example.com", true));
        users.add(new UserProfile(2L, "user2", "user2@example.com", true));
        users.add(new UserProfile(3L, "user3", "user3@example.com", false));
        users.add(new UserProfile(4L, "user4", "user4@example.com", true));
        return  users;
    }

    @Override
    public UserProfile Save(UserProfile entity) {
        entity.setId(5L);
        return entity;
    }

    @Override
    public UserProfile Update(UserProfile entity) {
        return entity;
    }

    @Override
    public boolean Delete(UserProfile entity) {
        return true;
    }
}
