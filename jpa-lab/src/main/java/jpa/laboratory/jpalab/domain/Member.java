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
@NoArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;


    private String name;

    private String email;
    private Integer postcode;

    @JsonIgnore
    @OneToMany(mappedBy = "member")
    private List<Order> order;

    @Builder
    public Member(String name, String email){
        this.name = name;
        this.email = email;
    }

}
