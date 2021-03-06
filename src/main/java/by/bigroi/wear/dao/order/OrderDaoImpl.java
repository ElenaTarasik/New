package by.bigroi.wear.dao.order;


import by.bigroi.wear.model.order.Order;
import by.bigroi.wear.model.order.OrderItem;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;


/**
 * Created by Paragvai on 02.10.2017.
 */
@Repository("orderDao")
public class OrderDaoImpl implements OrderDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void addOrderBasket(Order order) {

        sessionFactory.getCurrentSession().save(order);


        }

    @Override
    @Transactional
    public void addOrderItemsBasket(OrderItem orderItem) {

        sessionFactory.getCurrentSession().save(orderItem);


    }


    @Transactional
    public List<Order> getOrderById(long id) {

        Query query = sessionFactory.getCurrentSession().createQuery("from Order where ID_USER=:paramId");
        query.setParameter("paramId",id);

          return query.getResultList();
    }


  /*  @Override
    @Transactional
    public OrderItem getOrderItemById(long id) {

        Query query = sessionFactory.getCurrentSession().createQuery("from OrderItem where idorder_items=:paramId");
        query.setParameter("paramId",id);

        return (OrderItem) query.getSingleResult();
    }*/

}




