package com.example.eksamensprojekt_2_semester.repository.impl;

import java.sql.PreparedStatement;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.example.eksamensprojekt_2_semester.model.User;
import com.example.eksamensprojekt_2_semester.repository.UserRepository;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    JdbcTemplate template;

    @Override
    public User createUser(User user){
        String sql = "INSERT INTO user (firstName, lastName, address, zip, phoneNumber, email, cpr) VALUES (?, ?, ?, ?, ?, ?, ?)";
	KeyHolder keyHolder = new GeneratedKeyHolder();
	
	    template.update(connection -> {
        PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, user.getFirstName());
        ps.setString(2, user.getLastName());
        ps.setString(3, user.getAddress());
        ps.setInt(4, user.getZip());
        ps.setInt(5, user.getPhoneNumber());
        ps.setString(6, user.getEmail());
        ps.setString(7, user.getCPR());
        return ps;
    }, keyHolder);
    
    // Set the auto-generated ID on the user object
    user.setId(keyHolder.getKey().intValue());
	return user;
    }

	public User getUserById(int id) {
		String sql = "SELECT * FROM user WHERE id=?";
        	RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
        	User user = template.queryForObject(sql, rowMapper, id);
       	 return user;
	}

}
