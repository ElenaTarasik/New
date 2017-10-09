package by.bigroi.wear.dao.user.user;

import by.bigroi.wear.model.user.User;
import by.bigroi.wear.model.user.UserRole;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {

    public void saveUser(User user) throws Exception;
    public User findByUserEmail(String email);
    public UserRole getRoleById(int id);
    public List<User> listUsers();
    public void deleteUserByMail(String email);
    public void updateUser(User user, String oldEmail) throws Exception;
    public List<Integer> findRoleId(Long userId);
    public void cleanRow(Long id);
    public void updatePassword(User user);
}
