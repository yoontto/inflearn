package jpabook.jpashop.domain.item;

import jpabook.jpashop.domain.Category;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//추상클래스로 지정 : 구현체를 가지고 실행할거니까
@Entity
@Getter @Setter
//DB에 저장할때 구분지을 수 있게 만드는 카테고리 같은 개념(부모에는 Column)
@DiscriminatorColumn(name = "dtype")
//상속관계 - 전략관계 지정 : 부모클래스에
// inheritanceType : 전략관계 타입으로 3개가 있음
// singleTable : 한 테이블에 모든 자식들의 컬럼을 다 넣는것
// joined : 가장 정규화된 테이블
// table per class : 자식 클래스 하나당 테이블 하나씩 만들어줌
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Item {

    @Id
    @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;  //재고수량

    @ManyToMany(mappedBy = "items")
    private List<Category> categories = new ArrayList<>();

}
