package org.example.springmvc.Services;

import org.example.springmvc.Model.AccountUser;
import org.example.springmvc.Model.User;
import org.springframework.stereotype.Service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class UserLoginService extends DatabaseService {

    public boolean authenticate(AccountUser user) {
        String query = "SELECT * FROM users WHERE username=? AND password=?";
        try (Connection connection = getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

//        if ("CongMinh".equals(user.getUsername()) && "2003".equals(user.getPassword())) {
//            return true;
//        }
//        return false;
    }
}
