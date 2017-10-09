package by.bigroi.wear.service.basket;

import by.bigroi.wear.model.order.Basket;
import by.bigroi.wear.model.order.BasketDel;
import by.bigroi.wear.model.order.Order;
import by.bigroi.wear.model.product.Product;
import by.bigroi.wear.model.user.User;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Map;

/**
 * Created by Paragvai on 27.09.2017.
 */
public interface BasketService {

     Map<Long,Integer> quantity(Basket basket, Map<Long, Integer> quan);
     List<Product> basketProduct(Map<Long, Integer> quan);
     String addOrder(Map<Long, Integer> quan);
     List<Order> userOrders(User user);
     public Map<Long, Integer> delOrder(Map<Long, Integer> quan, BasketDel basketDel);

}
