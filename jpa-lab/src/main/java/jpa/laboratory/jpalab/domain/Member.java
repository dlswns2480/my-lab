package jpa.laboratory.jpalab.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Entity
@Getter @Setter
@NoArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;
    private String dummy;

    private String name;

    private String email;
    private int postcode;

    @JsonIgnore
    @OneToMany(mappedBy = "member")
    private List<Order> order = new ArrayList<>();

    @Builder
    public Member(String name, String email, int postcode){
        this.name = name;
        this.email = email;
        this.postcode = postcode;
    }

}
