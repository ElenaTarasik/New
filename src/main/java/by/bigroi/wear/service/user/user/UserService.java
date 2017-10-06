package by.bigroi.wear.service.user.user;

import by.bigroi.wear.model.user.User;
import by.bigroi.wear.model.user.UserRole;
import javassist.NotFoundException;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public interface UserService {


        public String addUser(User user);
        public User findByUserEmail(String email);
        public List<User> getAllUsers();
        public String deleteUser(String mail);
        public String updateUserByEmail(User user, String oldEmail) throws Exception;
        public Set<UserRole> getRoles(Long userId);
        public String checkPass(User user, String oldPass, String new1Pass, String new2Pass);
        public void updateUserPassword(User user, String newPass);
        public User getCurrentUser() throws Exception;
}
