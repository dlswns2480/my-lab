package jpa.laboratory.jpalab.service;

import jpa.laboratory.jpalab.domain.Order;
import jpa.laboratory.jpalab.dto.OrderResponse;
import jpa.laboratory.jpalab.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class OrderService {
    private final OrderRepository orderRepository;

    @Transactional
    public Long createOrder(String productName) {
        Order order = Order.builder().productName("itemA").build();
        Order save = orderRepository.save(order);
        return save.getId();
    }
    public Page<OrderResponse> findAll(Pageable pageable){
        Page<Order> all = orderRepository.findAll(pageable);
        List<OrderResponse> result = all.stream()
                .map(order -> new OrderResponse(order.getProductName(), order.getMember().getId()))
                .toList();
        return new PageImpl<>(result, pageable, all.getTotalElements());
    }
}
