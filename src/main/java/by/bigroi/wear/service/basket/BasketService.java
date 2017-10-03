package by.bigroi.wear.service.basket;

import by.bigroi.wear.model.order.Basket;
import by.bigroi.wear.model.product.Product;

import java.util.List;
import java.util.Map;

/**
 * Created by Paragvai on 27.09.2017.
 */
public interface BasketService {

     Map<Long,Integer> quantity(Basket basket, Map<Long, Integer> quan);
     List<Product> basketProduct(Map<Long, Integer> quan);
     void addOrder(Map<Long, Integer> quan);

}
