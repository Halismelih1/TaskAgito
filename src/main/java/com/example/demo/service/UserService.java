package com.example.demo.service;


import com.example.demo.dto.UserRegisterRequest;
import com.example.demo.repository.UserRepository;
import com.example.demo.entities.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    private final JdbcTemplate jdbcTemplate;

    public UserService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<Users> getUserById(Integer userId) {
        return userRepository.findById(userId);
    }


    //Oracle PL/SQL prosedürleri çağır
    public void registerUser(UserRegisterRequest userRegisterRequest) {
        String sql = "{ call RegisterPackage.RegisterUser(?, ?, ?, ?, ?, ?) }";
        jdbcTemplate.update(sql, userRegisterRequest.getUsername(), userRegisterRequest.getUserPassword(),userRegisterRequest.getFirstname(),userRegisterRequest.getLastname(),userRegisterRequest.getEmail(),userRegisterRequest.getPhone());
    }

    public void resetPassword(String email, String oldPassword, String newPassword) {
        String sql = "{ call ChangePasswordPackage.resetPassword(?, ?, ?) }";
        jdbcTemplate.update(sql, email, oldPassword, newPassword);
    }

}
