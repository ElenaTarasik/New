package by.bigroi.wear.controller;

import by.bigroi.wear.model.order.Basket;
import by.bigroi.wear.model.user.User;
import by.bigroi.wear.service.basket.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by Paragvai on 27.09.2017.
 */
@Controller
public class BasketController {

    @Autowired
    BasketService basketService;


    @PostMapping("/basketPage")
    public @ResponseBody
    boolean basket(@RequestBody Basket basket, HttpSession session,Model model) {

        Map<Long,Integer>  quan = (Map<Long, Integer>) session.getAttribute("mapBasket");
        session.setAttribute("mapBasket",basketService.quantity(basket,quan));
        return true;
    }

    @GetMapping("/basket/basket")
    public String basketPage(Model model,  HttpSession session) {
        Map<Long,Integer> quan = (Map<Long, Integer>)session.getAttribute("mapBasket");
        model.addAttribute("basketOrder",basketService.basketProduct(quan));
        model.addAttribute("quantity",quan);
        return "/basket/basket";

    }

    @GetMapping("/basket/addOrder")
       public String basketAdd (HttpSession session,Model model){
        Map<Long,Integer> quan = (Map<Long, Integer>)session.getAttribute("mapBasket");
        model.addAttribute("basketMessage",basketService.addOrder(quan));
        session.setAttribute("mapBasket",null);
        return "basket/basket";
    }

}
