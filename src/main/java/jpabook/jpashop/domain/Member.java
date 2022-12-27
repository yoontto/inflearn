package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {
    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;
    private String name;
    
    @Embedded
    private Address address;    //내장타입을 사용했음을 나타내주는 어노테이션

    @OneToMany
    private List<Order> orders = new ArrayList<>(); //회원-주문은 일대다관계

}