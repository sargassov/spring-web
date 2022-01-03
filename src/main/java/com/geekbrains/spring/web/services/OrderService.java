package com.geekbrains.spring.web.services;

import com.geekbrains.spring.web.entities.Order;
import com.geekbrains.spring.web.entities.User;
import com.geekbrains.spring.web.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrderService {
    private OrderRepository orderRepository;
    private CartService cartService;
    private UserService userService;


    @Transactional
    public String createOrder(String username) {
        Order order = new Order();
        order.setUser((User) userService.loadUserByUsername(username));
        order.setTotalPrice(cartService.getCurrentCart().getTotalPrice());
        order.setAddress("Example address street, 20");
        order.setPhone("+79001234567");
        return "Order was created";
    }
}
