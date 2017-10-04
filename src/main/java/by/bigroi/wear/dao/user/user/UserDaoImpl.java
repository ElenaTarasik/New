package by.bigroi.wear.dao.user.user;

import by.bigroi.wear.model.user.User;
import by.bigroi.wear.model.user.UserRole;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository("userDao")
public class UserDaoImpl implements UserDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void saveUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    @Transactional
    public User findByUserEmail(String email) {
        Query query = sessionFactory.getCurrentSession().createQuery("from User u where u.email =:paramEmail");
        query.setParameter("paramEmail", email);
        return (User) query.getSingleResult();
    }

    @Override
    @Transactional
    public UserRole getRoleById(int id) {
        Query query = sessionFactory.getCurrentSession().createQuery("from UserRole ur where ur.id =:paramId");
        query.setParameter("paramId", id);
        return (UserRole) query.getSingleResult();
    }

    @Override
    @Transactional
    public List<User> listUsers() {
        return sessionFactory.getCurrentSession().createQuery("from User").list();
    }

    @Override
    @Transactional
    public void deleteUserByMail(String email) {
        Query query = sessionFactory.getCurrentSession().createQuery("delete User u where u.email =:paramEmail");
        query.setParameter("paramEmail", email);
        query.executeUpdate();
    }

    @Override
    @Transactional
    public void updateUser(User user, String oldEmail) throws Exception {
        Query query = sessionFactory.getCurrentSession().createQuery("update User u set " +
                "u.surname =:newSurname, " +
                "u.name =:newName, " +
                "u.email =:newEmail, " +
                "u.password =:newPassword,  " +
                "u.phone =:newPhone, " +
                "u.address =:newAddress " +
                "where u.email =:oldEmail");
        query.setParameter("newSurname", user.getSurname());
        query.setParameter("newName", user.getName());
        query.setParameter("newEmail", user.getEmail());
        query.setParameter("newPassword", user.getPassword());
        query.setParameter("newPhone", user.getPhone());
        query.setParameter("newAddress", user.getAddress());
        query.setParameter("oldEmail", oldEmail);
        query.executeUpdate();
    }

   /* @Override
    @Transactional
    public void updateUser(User user, String oldEmail) throws Exception{
        sessionFactory.getCurrentSession().update(user);
    }*/

    @Override
    @Transactional
    public List<Integer> findRoleId(Long userId){
        Query query = sessionFactory.getCurrentSession()
                .createNativeQuery("select id_role from user_user_role where id_user =:paramId");
        query.setParameter("paramId", userId);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void cleanRow(Long id){
        Query query = sessionFactory.getCurrentSession().createNativeQuery("delete from user_user_role where id_user =:paramId");
        query.setParameter("paramId", id);
        query.executeUpdate();
    }

    @Override
    @Transactional
    public void updatePassword(User user) {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("update User u set u.password =:newPassword where u.email =:paramEmail");
        query.setParameter("newPassword", user.getPassword());
        query.setParameter("paramEmail", user.getEmail());
        query.executeUpdate();
    }
}
