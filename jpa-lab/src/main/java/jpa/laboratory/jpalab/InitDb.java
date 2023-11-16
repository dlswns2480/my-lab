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
                    .postcode(123321)
                    .build();
            memberRepository.save(memberA);
            Order orderA = Order.builder()
                    .productName("itemA")
                    .build();
            orderA.setMember(memberA);
            orderRepository.save(orderA);
        }
        public void dbInit2() {
            Member memberB = Member.builder()
                    .name("hyun")
                    .email("456@gmail.com")
                    .postcode(98765)
                    .build();
            memberRepository.save(memberB);
            Order orderB = Order.builder()
                    .productName("itemB")
                    .build();
            orderB.setMember(memberB);
            orderRepository.save(orderB);
        }

    }
}
