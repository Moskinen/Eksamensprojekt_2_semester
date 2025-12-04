package com.example.eksamensprojekt_2_semester.repository.impl;

import com.example.eksamensprojekt_2_semester.model.User;
import com.example.eksamensprojekt_2_semester.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    JdbcTemplate template;

    @Override
    public void createUser(User user){
        String sql = "INSERT INTO user (firstName, lastName, address, zip, phoneNumber, email, CPR) VALUES (?, ?, ?, ?, ?, ?, ?)";
        template.update(sql, user.getFirstName(), user.getLastName(), user.getAddress(), user.getZip(), user.getPhoneNumber(), user.getEmail(), user.getCPR());
    }
}
