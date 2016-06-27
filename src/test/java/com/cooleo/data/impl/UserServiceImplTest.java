package com.cooleo.data.impl;

import com.cooleo.demo.Application;


/**
 * Created by hungnguyendang on 6/18/15.
 */

import static org.junit.Assert.*;

import com.cooleo.data.entities.User;
import com.cooleo.data.services.UserService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import java.util.List;

/**
 * Created by hungnguyendang on 6/18/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)

public class UserServiceImplTest {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private UserService userService;
    @Before
    public void before() {
        mongoTemplate.dropCollection("user");
    }
    @After
    public void after() {
        mongoTemplate.dropCollection("user");
    }

    @Test
    public void testAdd() throws Exception {
            String email = "hung0@gmail.com";
            User user = new User();
            user.setName("Hung");
            user.setEmail(email);
            user.setPassword("hung");
            user.setTitle("Software Developer");
            User addedUser = userService.add(user);
            assertNotNull(addedUser);


    }
    @Test
    public void testAddDuplicateEmail() throws Exception{
        String email = "hung0@gmail.com";
        User user = new User();
        user.setName("Hung");
        user.setEmail(email);
        user.setPassword("hung");
        user.setTitle("Software Developer");
        User addedUser = userService.add(user);

        User user2 = new User();
        user2.setName("Hung");
        user2.setEmail(email);
        user2.setPassword("hung");
        user2.setTitle("Software Developer");

        User addedUser2 = userService.add(user2);


        assertNull(addedUser2);
    }

    @Test
    public void testUpdate() throws Exception {

        User user = new User();
        user.setName("Hero");
        user.setEmail("hero2@gmail.com");
        user.setPassword("hero");
        user.setTitle("Software Developer");
        userService.add(user);

        User user2 = userService.findOne("hero2@gmail.com");
        if(user2 != null){
            user2.setName("Herol");
            User updatedUser = userService.update(user2);
            Assert.assertEquals(updatedUser.getName(), "Herol");
        }
    }
    @Test
    public void testDelete() throws Exception {
        User user = new User();
        user.setName("Hero");
        user.setEmail("hero3@gmail.com");
        user.setPassword("hero");
        user.setTitle("Software Developer");
        userService.add(user);

        User user2 = userService.findOne("hero3@gmail.com");
        if(user2 != null){
            userService.delete(user2);
            User user3 = userService.findOne("hero@gmail.com");
            assertNull(user3);
        }
    }
    @Test
    public void testFindAll() throws Exception {
        User user = new User();
        user.setName("Hero");
        user.setEmail("hero3@gmail.com");
        user.setPassword("hero");
        user.setTitle("Software Developer");
        userService.add(user);
        List<User> users = userService.findAll();
        assertNotNull(users);
        System.out.println("size>>>>>>>>>>>>>>>>>>>>"+ users.size());
        Assert.assertEquals(users.size(), 1);
    }
}