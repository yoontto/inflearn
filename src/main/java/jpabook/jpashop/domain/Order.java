package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter @Setter
public class Order {
    @Id @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="member_id")   //조인에 이용되는 컬럼 명시(foreignKey 지정, 연관관계 주인)
    private Member member;          //주문-회원은 다대일 관계

    // mappedBy : 연관관계 소속
    // cascade : 연관관계 영속성 전이 -> 부모가 영속화될때 자식 엔티티도 같이 영속화, 부모 삭제시 자식도 삭제됨
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems = new ArrayList<>();

    // cascade : order 저장할 때 delivery도 persist 같이 해줌
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="delivery_id")
    private Delivery delivery;

    //만약 Date 타입 쓰면 날짜 관련 어노테이션 맵핑 필요함
    private LocalDateTime orderDate;  //LcoalDateTime : 어노테이션 필요 없음(자바 8이상)

    //Enum type
    @Enumerated(EnumType.STRING)    //꼭 string으로 지정해서 중간에 값 들어가도 지장 없도록 해줌
    private OrderStatus status; //주문상태 [ORDER, CANCEL]

    //==연관관계 메서드==//
    public void setMember(Member member) {
        this.member = member;
        member.getOrders().add(this);
    }
    public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
        orderItem.setOrder(this);
    }
    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
        delivery.setOrder(this);
    }
}
