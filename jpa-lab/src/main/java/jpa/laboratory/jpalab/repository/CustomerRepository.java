package jpa.laboratory.jpalab.repository;

import jpa.laboratory.jpalab.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
