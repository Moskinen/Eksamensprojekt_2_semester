package com.example.eksamensprojekt_2_semester.repository;

import com.example.eksamensprojekt_2_semester.model.User;

public interface UserRepository {

    User createUser(User user);

    User getUserById(int id);
}
