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

    @Embedded //내장 타입을 포함했다는 어노테이션
    private Address address;

    @OneToMany//Member입장에서 리스트는 하나의 회원이 여러개의 상품을 주문하기 때문에 1대 다 관계다.
    private List<Order> orders = new ArrayList<>();

}
