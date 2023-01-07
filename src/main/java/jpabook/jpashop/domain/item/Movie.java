package jpabook.jpashop.domain.item;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Getter @Setter
//DB에 저장할때 구분지을 수 있게 만드는 카테고리 같은 개념(자식에는 value)
@DiscriminatorValue("M")
public class Movie extends Item {

    private String director;
    private String actor;

}
