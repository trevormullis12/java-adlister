package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;
import models.Config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLUsersDao implements Users{
    private Connection connection = null;

    public MySQLUsersDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

    @Override
    public User findByUsername(String username) {
        try {
            String sql = "SELECT * FROM users WHERE username LIKE ?";
            String searchUser = "%" + username + "%";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, searchUser);
            stmt.setString(1, searchUser);
        } catch() {

        }
        ResultSet rs = stmt.executeQuery();
        while(rs.next()) {
            // do something with the search results
        }
        return null;
    }

    @Override
    public Long insert(User user) {
        return null;
    }
}
