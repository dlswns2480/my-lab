package jpa.laboratory.jpalab;

import jakarta.annotation.PostConstruct;
import jpa.laboratory.jpalab.domain.Member;
import jpa.laboratory.jpalab.domain.Order;
import jpa.laboratory.jpalab.repository.MemberRepository;
import jpa.laboratory.jpalab.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class InitDb {
    private final InitService initService;

    @PostConstruct
    public void init() {
        initService.dbInit1();
        initService.dbInit2();
    }
    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService {
        private final MemberRepository memberRepository;
        private final OrderRepository orderRepository;
        public void dbInit1() {
            Member memberA = Member.builder()
                    .name("injun")
                    .email("123@gmail.com")
                    .build();
            Member savedMemberA = memberRepository.save(memberA);
            Order orderA = Order.builder()
                    .productName("itemA1")
                    .build();
            orderA.setMember(memberA);
            Order savedOrderA = orderRepository.save(orderA);
            Order orderB = Order.builder()
                .productName("itemA2")
                .build();
            orderB.setMember(memberA);
            Order savedOrderB = orderRepository.save(orderB);
        }
        public void dbInit2() {
            Member memberB = Member.builder()
                    .name("hyun")
                    .email("456@gmail.com")
                    .build();
            memberRepository.save(memberB);
            Order orderA = Order.builder()
                    .productName("itemB1")
                    .build();
            orderA.setMember(memberB);
            orderRepository.save(orderA);
            Order orderB = Order.builder()
                .productName("itemB2")
                .build();
            orderB.setMember(memberB);
            orderRepository.save(orderB);
        }

    }
}
