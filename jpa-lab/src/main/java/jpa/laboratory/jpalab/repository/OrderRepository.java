package jpa.laboratory.jpalab.repository;

import jakarta.persistence.Entity;
import jpa.laboratory.jpalab.domain.Order;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
//    @Query("select o from Order o join fetch o.member m")
    @EntityGraph(attributePaths = "member")
    List<Order> findAll();
}
