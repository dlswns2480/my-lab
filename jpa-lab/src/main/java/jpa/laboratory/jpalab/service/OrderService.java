package jpa.laboratory.jpalab.service;

import jpa.laboratory.jpalab.domain.Order;
import jpa.laboratory.jpalab.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public List<Order> findAll(){
        return orderRepository.findAll();
    }
}
