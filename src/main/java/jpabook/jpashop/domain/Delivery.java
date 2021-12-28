package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter@Setter
public class Delivery {

    @Id
    @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;

    @OneToOne(mappedBy = "delivery")
    private Order order;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING) //디폴트는 Ordinary인데, 1,2,3..으로 숫자로 들어간다.
                                //문제는 다른 상태가 생기면 숫자가 밀려서 오류난다.
    private DeliveryStatus status; //READY, COMP
}
