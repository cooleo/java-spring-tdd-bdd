package com.smoovpost.data.repositories;

import com.smoovpost.data.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by hungnguyendang on 6/18/15.
 */


public interface UserRepository extends MongoRepository<User, String> {
  User findByEmail(String email);
}
