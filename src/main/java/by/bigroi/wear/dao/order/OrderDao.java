package by.bigroi.wear.dao.order;

import by.bigroi.wear.model.order.Order;
import by.bigroi.wear.model.order.OrderItem;

/**
 * Created by Paragvai on 02.10.2017.
 */
public interface OrderDao{

    void addOrderBasket (Order order);
    void addOrderItemsBasket(OrderItem orderItem);
    Order getOrderById(long id);


}
