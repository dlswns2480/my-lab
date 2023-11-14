package jpa.laboratory.jpalab.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Objects;


@Entity
@Getter @Setter
@NoArgsConstructor
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

    @Builder
    public Member(String name, String email){
        this.name = name;
        this.email = email;
    }

//    @Override
//    public boolean equals(Object object) {
//        if (this == object) return true;
//        if (object == null || getClass() != object.getClass()) return false;
//        Member member = (Member) object;
//        return Objects.equals(id, member.id);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id);
//    }
}
