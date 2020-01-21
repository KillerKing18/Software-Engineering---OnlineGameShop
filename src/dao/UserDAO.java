package dao;

import transfer.User;

import java.util.List;

public interface UserDAO
{

    User getUserByCredentials(String username, String pass);
    User getUserbyId(int id);
    List<User> getAllUsers();
    int insertUser(User user);
    boolean updateUser(User user);
    boolean deleteUser(int id);

}
