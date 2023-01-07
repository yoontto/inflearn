package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Delivery {

    @Id
    @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;

    @OneToOne(mappedBy = "delivery", fetch = FetchType.LAZY)
    private Order order;

    @Embedded   //내장타입
    private Address address;

    @Enumerated(EnumType.STRING)    //꼭 string으로 지정해서 중간에 값 들어가도 지장 없도록 해줌
    private DeliveryStatus status;  //[READY, COMP : enum으로 만들어줌]


    
}
