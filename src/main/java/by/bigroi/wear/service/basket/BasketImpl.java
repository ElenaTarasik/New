package by.bigroi.wear.service.basket;

import by.bigroi.wear.dao.order.OrderDao;
import by.bigroi.wear.dao.user.product.ProductDao;
import by.bigroi.wear.model.order.Basket;
import by.bigroi.wear.model.order.Order;
import by.bigroi.wear.model.order.OrderItem;
import by.bigroi.wear.model.product.Product;
import by.bigroi.wear.model.user.User;
import by.bigroi.wear.service.user.user.UserService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.transaction.Transactional;
import java.util.*;

/**
 * Created by Paragvai on 27.09.2017.
 */
@Service
public class BasketImpl implements BasketService {

    @Autowired
    ProductDao productDao;

    @Autowired
    OrderDao orderDao;

    @Autowired
    UserService userService;

    @Override
    public Map<Long, Integer> quantity(Basket basket, Map<Long, Integer> quan) {

        if (quan == null) {
            quan = new HashMap();
            quan.put(basket.getArticul(), basket.getQuantity());
        } else {
            if (quan.containsKey(basket.getArticul())) {
                quan.put(basket.getArticul(), (quan.get(basket.getArticul())) + 1);
            } else {
                quan.put(basket.getArticul(), basket.getQuantity());
            }
        }
        return quan;
    }


    @Override
    public List<Product> basketProduct(Map<Long, Integer> quan) {

        List<Product> products = new ArrayList<>();

        if (quan != null) {
            for (long key : quan.keySet()) {
                products.add(productDao.getProductByID(key));
            }

            return products;

        } else {
            return null;
        }
    }

    @Override
    public String addOrder(Map<Long, Integer> quan) {

        List<Product> products = basketProduct(quan);


        int quantity = 0;
        double p = 0;
        Order order = new Order();
        try {
            userService.getCurrentUser().getId();
        } catch (Exception e) {
            /*e.printStackTrace();*/
            return "Please login or register.";

        }
        /*if (user == null) {
        return "login or register";
        } else {*/
            if (quan != null) {
                for (long key : quan.keySet()) {

                    for (int i = 0; i < products.size(); i++) {

                        if (products.get(i).getId() == key) {
                            p += (products.get(i).getPrice() * quan.get(key));
                            quantity+=quan.get(key);
                        }

                    }

                }

                order.setDate(new Date());
                order.setQuantity(quantity);
                order.setPrice(p);
                orderDao.addOrderBasket(order);
                for (long key : quan.keySet()) {

                    for (int i = 0; i < products.size(); i++) {

                        if (products.get(i).getId() == key) {

                            OrderItem orderItem = new OrderItem();
                            orderItem.setQuantity(quan.get(key));
                            orderItem.setOrder(order);
                            orderItem.setProduct(products.get(i));
                            orderDao.addOrderItemsBasket(orderItem);
                        }

                    }


                }
                /*quan=null;*/

                return "Your order is issued";

            }else{return "The basket is empty";}
       /* }*/


    }


}
