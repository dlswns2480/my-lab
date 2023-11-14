package jpa.laboratory.jpalab.domain;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class EntityManegerTest {

    private EntityManager em;
    @Autowired
    public EntityManegerTest(EntityManager em) {
        this.em = em;
    }

    @Test
    void cache(){

        Member member = new Member();

        member.setName("injun");
        member.setEmail("123@gmail.com");
        em.persist(member);

        Member member1 = em.find(Member.class, 1L);


        Member member2 = em.find(Member.class, 1L);


        Assertions.assertThat(member1).isEqualTo(member2);

    }
}
