package com.cooleo.data.services;

import com.cooleo.data.entities.User;

import java.util.List;

/**
 * Created by hungnguyendang on 6/18/15.
 */
public interface UserService {
     User add(User user);
     User update(User user);
     void delete (User user);
     List<User> findAll();
     User findOne(String email);
}
