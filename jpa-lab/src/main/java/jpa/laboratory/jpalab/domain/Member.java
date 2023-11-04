package jpa.laboratory.jpalab.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Entity
@Getter @Setter
public class Member{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;


    private String name;

    @Embedded
    private Address address;

    private String email;
    private Integer postcode;

    @JsonIgnore
    @OneToMany(mappedBy = "member")
    private List<Order> order;

}
