package jpabook.jpashop.domain;

import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable //내장 값 타입 -> 값 타입은 엔티티가 아니다. 엔티티가 가진 값일 뿐
@Getter
public class Address {

    private String city;
    private String street;
    private String zipcode;

    protected Address() {
    }
    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}
