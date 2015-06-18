package com.smoovpost.demo;

import com.smoovpost.data.entities.User;
import com.smoovpost.data.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by hungnguyendang on 6/18/15.
 */

@RestController
public class UserWebController {
    @Autowired
    private UserService postService;

    @RequestMapping(value = "/posts/getAll", produces = "application/json")
    public @ResponseBody
    List<User> getAllPost(){
        return  postService.findAll();
    }
//    @RequestMapping(value = "/post/save", produces = "application/json")
//    public @ResponseBody Post savePost(@RequestBody AddPostRequest request){
//        return postService.savePost(request);
//    }
//    @RequestMapping(value = "/post/get/{postId}")
//    public @ResponseBody Post findOne(@PathVariable String postId){
//        return postService.findOne(postId);
//    }
}
