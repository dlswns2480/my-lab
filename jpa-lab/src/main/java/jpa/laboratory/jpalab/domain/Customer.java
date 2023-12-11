package jpa.laboratory.jpalab.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Customer {
    @Id
    private Long id;
    private String firstName;
    private String dummys;
    private String test;
    private String lastNames;

}
