package dao;

import transfer.User;

import java.sql.*;
import java.util.List;

public class DerbyUserDAO implements UserDAO
{

    @Override
    public User getUserByCredentials(String username, String pass)
    {

        try(Connection connection = DerbyDAOFactory.getConnection()) {

            PreparedStatement stmt = connection.prepareStatement(
                    "SELECT * FROM users WHERE username = ? AND pass = ?"
            );

            stmt.setString(1, username);
            stmt.setString(2, pass);

            ResultSet result = stmt.executeQuery();

            if(result.next()) {
            	User user = new User();
                user.setId(result.getInt("id"));
                user.setUsername(result.getString("username"));
                user.setPass(result.getString("pass"));
                user.setDob(result.getDate("dob"));
                return user;
            }

            return null;

        }
        catch(SQLException e)
        {
            throw new RuntimeException("SQL query error", e);
        }

    }

    @Override
    public User getUserbyId(int id)
    {
        return null;
    }

    @Override
    public List<User> getAllUsers()
    {
        return null;
    }

    @Override
    public int insertUser(User user)
    {
        return 0;
    }

    @Override
    public boolean updateUser(User user)
    {
        return false;
    }

    @Override
    public boolean deleteUser(int id)
    {
        return false;
    }
}
