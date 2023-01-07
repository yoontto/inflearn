package jpabook.jpashop.domain;

import jpabook.jpashop.domain.item.Item;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class OrderItem {

    @Id @GeneratedValue
    @Column(name = "order_item_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id") //item_id를 foreignKey로 가지고 있음 (연관관계 주인)
    private Item item;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")  //order_id를 foreignKey로 가지고 있음 (연관관계 주인)
    private Order order;

    //주문가격
    private int orderPrice;

    //주문수량
    private int count;

}
