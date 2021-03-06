package by.bigroi.wear.service.user.user;

import by.bigroi.wear.dao.user.user.UserDao;
import by.bigroi.wear.model.user.User;
import by.bigroi.wear.model.user.UserRole;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String addUser(User user) throws Exception {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Set<UserRole> roles = new HashSet<>();
        roles.add(userDao.getRoleById(2));  // id = 1 ADMIN  /  id = 2 CUSTOMER
        user.setRoles(roles);
        user.setRegDate(new Date());
        userDao.saveUser(user);
        return "User saved to database";
    }

    @Override
    public User findByUserEmail(String email) {
        return userDao.findByUserEmail(email);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.listUsers();
    }

    @Override
    public String deleteUser(String email) {
        User user = userDao.findByUserEmail(email);
        if(user != null){
            userDao.cleanRow(user.getId());
            userDao.deleteUserByMail(email);
            return "User " + user.getName() + " " + user.getSurname() + " deleted from database";
        } else {
            return "User didn't find";
        }
    }

    @Override
    public String updateUserByEmail(User user, String oldEmail) throws Exception {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDao.updateUser(user, oldEmail);
        return "User updated successfully";
    }

    @Override
    public Set<UserRole> getRoles(Long userId){
        Set<UserRole> userRoles = new HashSet<>();
        for (Integer id: userDao.findRoleId(userId)) {
            userRoles.add(userDao.getRoleById(id));
        }
     return userRoles;
    }

    @Override
    public String checkPass(User user, String oldPass, String new1Pass, String new2Pass) {
    if (oldPass == null || new1Pass == null || new2Pass == null) {
            return "Fill in the blank fields";
    } else {
        System.out.println("пароль с бд кодированный " + user.getPassword());
        System.out.println("пароль старый кодированный с юай " + passwordEncoder.encode(oldPass));
        System.out.println("пароль новый1 кодированный " + passwordEncoder.encode(new1Pass));
        System.out.println("пароль новый2 кодированный " + passwordEncoder.encode(new2Pass));
            if (!passwordEncoder.encode(oldPass).equals(user.getPassword())) {
                return "User with such password does not exist";
            } else {
                if (!new1Pass.equals(new2Pass)) {
                    return "The second password does not match the first one";
                } else {
                    return "Ok";
                }
            }
        }
    }

    @Override
    public void updateUserPassword(User user, String newPass){
        user.setPassword(passwordEncoder.encode(newPass));
        userDao.updatePassword(user);
    }

    @Override
    public UserRole getRole(int id){
        return userDao.getRoleById(id);
    }

    @Override
    public void updateRoles(User user){
      userDao.updateUserRoles(user);
    }

    @Override
    public User getCurrentUser() throws Exception {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth == null) {
            throw new Exception("");
        }

        Object obj = auth.getPrincipal();
        String userEmail = "";

        if (obj instanceof UserDetails) {
            userEmail = ((UserDetails) obj).getUsername();
        } else {
            userEmail = obj.toString();
        }

        User u = userDao.findByUserEmail(userEmail);
        return u;
    }


}
