package jpabook.jpashop.domain.item;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Getter @Setter
//DB에 저장할때 구분지을 수 있게 만드는 카테고리 같은 개념(자식에는 value)
@DiscriminatorValue("B") //"B"입력 안하면 "Book"으로 기본 값으로 들어감
public class Book extends Item {

    private String author;
    private String isbn;
}
