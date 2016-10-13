package com.lagoon.backend.service.impl;

import com.lagoon.backend.dao.UserDao;
import com.lagoon.backend.model.User;
import com.lagoon.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Le on 4/27/2016.
 */

@Service
public class UserServiceImpl implements UserService{

    private List<User> list = new ArrayList<>();

    @Autowired
    private UserDao userDao;

    public UserServiceImpl() {
        fillDummyData();
    }

    public List<User> findAllUsers() {
        return userDao.findAll();
    }

    @Override
    public List<User> findAllUsersDummyData() {
        return list;
    }

    public User findByUserName(String userName) {
        return userDao.findByUsername(userName);
    }

    public User save(User user) {
        return userDao.save(user);
    }

    @Override
    public User findById(long id) {
        for (int i = 0; i < this.list.size(); i++){
            if(list.get(i).getId() == id){
                return list.get(i);
            }
        }
        return null;
    }

    private void fillDummyData(){
        User user = new User();
        user.setId(1l);
        user.setUsername("faisal");
        user.setPassword("kommer1");
        user.setEnabled("1");
        this.list.add(user);

        User user2 = new User();
        user2.setId(2l);
        user2.setUsername("fasolie");
        user2.setPassword("kommer2");
        user2.setEnabled("1");
        this.list.add(user2);

        User user3 = new User();
        user3.setId(3l);
        user3.setUsername("test");
        user3.setPassword("kommer3");
        user3.setEnabled("1");
        this.list.add(user3);
    }

}
