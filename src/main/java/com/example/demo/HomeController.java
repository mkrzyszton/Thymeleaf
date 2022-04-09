package com.example.demo;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class HomeController {

    ObjectMapper objectMapper = new ObjectMapper();
    Map<Integer, UserEntity> users = new HashMap<>();

    String userJson;
    {
        try {
            userJson = objectMapper.writeValueAsString(users);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public HomeController() {
        users.put(1, new UserEntity("Maciek", 19));
        users.put(2, new UserEntity("Czesław", 52));
        users.put(3, new UserEntity("Bohdan", 66));
    }

    @RequestMapping("/")
    @ResponseBody
    public String hello() {
        return "Hello World!";
    }

    @RequestMapping("/example")
    public String index() {
        return "example";
    }

    @GetMapping("/users")
    @ResponseBody
    public String getUsers() {

        return userJson;
    }
//
//    @GetMapping("/users/{id}/get")
//    @ResponseBody
//    public String getUser(@PathVariable int id) {
//        return user.get(id);
//    }
//
//    @GetMapping("/users/{id}/remove")
//    @ResponseBody
//    public String removeUser(@PathVariable int id) {
//        return user.remove(id);
//    }

//
//    @RequestMapping("/user/add")
//    @ResponseBody
//    public String addUser(@RequestParam String name, int age) {
//        return user;
//    }
}
