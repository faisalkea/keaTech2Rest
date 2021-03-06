package com.lagoon.backend.service;

import com.lagoon.backend.model.User;

import java.util.List;

/**
 * Created by Le on 4/27/2016.
 */
public interface UserService {

    List<User> findAllUsers();

    List<User> findAllUsersDummyData();

    User findByUserName(String userName);

    User save(User user);

    User findById(long id);
}
