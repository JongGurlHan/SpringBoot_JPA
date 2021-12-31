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

    //카테고리는 list로 Item을 가지고, 아이템도 list로 카테고리를 가진다.
    @ManyToMany
    @JoinTable(name = "category_item",
            joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name="item_id"))
                                        //category와 itme을 조인하는 테이블을 매핑해줘야한다.
                                        //하지만 실전에선 쓰지 않는걸 권장 이 이상의 필드를 추가하기가 힘들기 때문
    private List<Item> items = new ArrayList<>();

    //셀프로 양방향 연관관계를 걸었다.
    //마치 다른 엔티티에 매핑한것 처럼 연관관게 설정
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Category parent;

    @OneToMany(mappedBy = "parent")
    private List<Category>child = new ArrayList<>();
}
