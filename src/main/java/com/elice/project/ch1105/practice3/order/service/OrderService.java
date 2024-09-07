package com.elice.project.ch1105.practice3.order.service;

import com.elice.project.ch1105.practice3.book.domain.Book;
import com.elice.project.ch1105.practice3.common.enums.ChatCode;
import com.elice.project.ch1105.practice3.common.enums.ErrorCode;
import com.elice.project.ch1105.practice3.common.event.AlarmEvent;
import com.elice.project.ch1105.practice3.common.exception.OutOfStockException;
import com.elice.project.ch1105.practice3.order.domain.Order;
import com.elice.project.ch1105.practice3.order.model.OrderRequest;
import com.elice.project.ch1105.practice3.order.model.OrderResponse;
import com.elice.project.ch1105.practice3.repository.BookRepository;
import com.elice.project.ch1105.practice3.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class OrderService {

    /**
     * [지시사항 4-1]
     * Spring ApplicationContext publisher 의존성 주입
     */
    private final ApplicationEventPublisher eventPublisher;
    private final OrderRepository orderRepository;
    private final BookRepository bookRepository;

    public OrderResponse saveOrder(OrderRequest orderRequest) {

        //재고 조회
        if (!isStockSufficient(orderRequest)) {
            /**
             * [지시사항 4-2]
             * 1. 이벤트 발행
             *   - 파라미터는 AlarmEvent, ChatCode, ErrorCode 참고

             * [지시사항 4-3]
             * 2. OutOfStockException 예외 throw
             */
            eventPublisher.publishEvent(new AlarmEvent(ChatCode.ORDER_ISSUE.getChatUuid(), ErrorCode.OUT_OF_STOCK));
            throw new OutOfStockException();
        }

        Order order = new Order(orderRequest.getBookCode(), orderRequest.getBookName(), orderRequest.getQuantity());
        orderRepository.save(order);

        return new OrderResponse(order.getUuid(), true);
    }

    private boolean isStockSufficient(OrderRequest orderRequest) {
        Book book = bookRepository.findByBookCode(orderRequest.getBookCode());
        return orderRequest.getQuantity() <= book.getQuantity();
    }

}

