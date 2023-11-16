package jpa.laboratory.jpalab.domain;

import jpa.laboratory.jpalab.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberTest {

    private final MemberRepository memberRepository;
    @Autowired
    MemberTest(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    @Test
    void equals(){
        Member member = Member.builder().name("injun").email("123@gmai.com").build();
        Order order = Order.builder().productName("itemA").build();
        Member save = memberRepository.save(member);
        Optional<Member> result = memberRepository.findById(member.getId());

        assertThat(member).isEqualTo(result.get());

    }

}