package org.prohire.dao;

import org.prohire.model.Credentials;
import org.prohire.util.DatabaseConnectionUtil;

import java.sql.*;

public class UserAuthentication {
    Connection c= DatabaseConnectionUtil.getConnection();
    public void createUser()  {
        Statement statement = null;
        try {
            statement = c.createStatement();
            statement.execute("create table credentials (username varchar(100),password varchar(100))");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public boolean athenticate(Credentials credentials){
        String query = "SELECT COUNT(*) FROM credentials WHERE username = ? AND password = ?";
        try {
             PreparedStatement stmt = c.prepareStatement(query);
            stmt.setString(1, credentials.getUsername());
            stmt.setString(2, credentials.getPassword());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
