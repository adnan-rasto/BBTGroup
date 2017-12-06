package com.ara.bbtgroup.rest;


import com.ara.bbtgroup.model.User;
import com.ara.bbtgroup.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(ResourceConstants.EMPLOYEE_V1)
public class UserResource {

    @Autowired
    // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private UserRepository userRepository;

    // ======================================
    // =             GET METHOD             =
    // ======================================

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody List<User> getAllUsers() {

        return (List<User>) userRepository.findAll();
    }

    @GetMapping(path = "/{firstname}")
    public ResponseEntity<User> getUserByFirstname(@PathVariable String firstname) {

        return new ResponseEntity<>(userRepository.findByUsername(firstname), HttpStatus.OK);
    }

    // ======================================
    // =             POST METHOD            =
    // ======================================

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<User> createUser(@RequestBody User userRequest){
        userRepository.save(userRequest);
        return new ResponseEntity<>(userRequest, HttpStatus.CREATED);
    }

    // ======================================
    // =             PUT METHOD             =
    // ======================================

    @RequestMapping(path = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<User> udpateUser(
            @RequestBody
                    User userRequestRequest) {

        return new ResponseEntity<>(new User(), HttpStatus.OK);
    }

    // ======================================
    // =          DELETE METHOD             =
    // ======================================

    @RequestMapping(path = "/{userId}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delteUser(
            @PathVariable
                    Integer reservationId) {

        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
