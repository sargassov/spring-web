package com.geekbrains.spring.web.controllers;

import com.geekbrains.spring.web.dto.JwtRequest;
import com.geekbrains.spring.web.dto.JwtResponse;
import com.geekbrains.spring.web.dto.OrderResponce;
import com.geekbrains.spring.web.entities.User;
import com.geekbrains.spring.web.services.CartService;
import com.geekbrains.spring.web.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<?> createOrder(@RequestBody String username){
        return ResponseEntity.ok(new OrderResponce(orderService.createOrder(username)));
    }
}
