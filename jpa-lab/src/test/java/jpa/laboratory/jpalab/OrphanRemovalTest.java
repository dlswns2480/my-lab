package jpa.laboratory.jpalab;

import jakarta.persistence.EntityManager;
import java.util.Optional;
import jpa.laboratory.jpalab.domain.Member;
import jpa.laboratory.jpalab.domain.Order;
import jpa.laboratory.jpalab.repository.MemberRepository;
import jpa.laboratory.jpalab.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class OrphanRemovalTest {
    private final MemberRepository memberRepository;
    private final OrderRepository orderRepository;
    @Autowired
    public OrphanRemovalTest(MemberRepository memberRepository, OrderRepository orderRepository) {
        this.memberRepository = memberRepository;
        this.orderRepository = orderRepository;
    }
    @Autowired
    EntityManager entityManager;

    @Test
    void remove(){
        //given
        Order order = orderRepository.findById(1L).orElseThrow();
        Member member = memberRepository.findById(1L).orElseThrow();
        //when
        memberRepository.delete(member);
        entityManager.flush();
    }

    @Test
    void removeMapping(){
        //given
        Order order = orderRepository.findById(1L).orElseThrow();
        Member member = memberRepository.findById(1L).orElseThrow();
        //when
        order.deleteMember(member);

        entityManager.flush();
    }
}
