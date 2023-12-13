package jpa.laboratory.jpalab.domain;

import static jakarta.persistence.CascadeType.ALL;
import static jakarta.persistence.GenerationType.AUTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@Getter
@NoArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "member_id")
    private Long id;
    private String name;
    private String email;
    @OneToMany(mappedBy = "member", cascade = ALL, orphanRemoval = true)
    private List<Order> order = new ArrayList<>();

    @Builder
    public Member(String name, String email){
        this.name = name;
        this.email = email;
    }
}
