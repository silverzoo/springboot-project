package com.elice.project.ch1105.practice3.controller;

import com.elice.project.ch1105.practice3.order.model.OrderRequest;
import com.elice.project.ch1105.practice3.order.model.OrderResponse;
import com.elice.project.ch1105.practice3.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class OrderController {

    private final OrderService orderService;

    /**
     * 입력 데이터 예시
     * OrderRequest orderRequest = new OrderRequest( "BOOK-001","엘리스 강의", 3);
     */
    @PostMapping("/order")
    public OrderResponse saveOrder(@RequestBody OrderRequest orderRequest) {
        return orderService.saveOrder(orderRequest);
    }
}
