package jpabook.jpashop.domain.item;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) //테이블 하나에 다 때려넣는 방식
@DiscriminatorColumn(name = "dtype") //한 테이블에 저장되니까 구분하기 위해서
@Getter @Setter
public abstract class Item {

    @Id
    @GeneratedValue
    @Column(name ="item_id")
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;

}
