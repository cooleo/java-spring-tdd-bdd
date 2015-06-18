package com.smoovpost.data.impl;

import com.smoovpost.data.entities.User;
import com.smoovpost.data.repositories.UserRepository;
import com.smoovpost.data.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hungnguyendang on 6/18/15.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public User add(User user) {
        User existedUser = userRepository.findByEmail(user.getEmail());
        if(existedUser == null){
            userRepository.save(user);
            return user;
        }
        return null;

    }

    @Override
    public User update(User user) {
        userRepository.save(user);
        return user;
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findOne(String email) {
        return userRepository.findByEmail(email);
    }
}
