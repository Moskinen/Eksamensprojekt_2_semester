package com.example.eksamensprojekt_2_semester.service;

import com.example.eksamensprojekt_2_semester.model.User;
import com.example.eksamensprojekt_2_semester.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public void createUser(User user) {
        userRepository.createUser(user);
    }

}
