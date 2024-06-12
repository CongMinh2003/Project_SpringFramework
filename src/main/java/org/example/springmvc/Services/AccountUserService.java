package org.example.springmvc.Services;

import org.example.springmvc.Model.AccountUser;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Service
public class AccountUserService extends DatabaseService {

    public boolean registerUser(AccountUser user) {
        try (Connection conn = getDataSource().getConnection()) {
            String query = "INSERT INTO users (username, password, email, phone) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getPhone());
            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
