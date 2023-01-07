package jpabook.jpashop.domain;

import jpabook.jpashop.domain.item.Item;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Category {

    @Id @GeneratedValue
    @Column(name = "category_id")
    private Long id;

    private String name;

    @ManyToMany //다대다관계
    @JoinTable(name = "category_item",
            joinColumns = @JoinColumn(name = "category_id"),    //중간 테이블에 있는 컬럼
            inverseJoinColumns = @JoinColumn(name="item_id")//category_item 테이블에 아이템으로 들어가는 애
    )  //다대다 관계는 중간테이블 매핑을 해줘야함
    private List<Item> items = new ArrayList<>();



    // 셀프로 양방향 연관관계 걸어주는 작업
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="parent_id")
    private Category parent;

    @OneToMany(mappedBy = "parent")
    private List<Category> child = new ArrayList<>();


    //==연관관계 메서드==//
    public void addChildCategory(Category child){
        this.child.add(child);
        child.setParent(this);
    }

}
