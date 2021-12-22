package jpabook.jpashop;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class MemberRepository {

    @PersistenceContext //JPA를 사용하기때문에 엔티티메니저가 필요하다. 스프링부트가 엔티티메너지를 주입해준다.
    private EntityManager em;

    //멤버저장
    public Long save(Member member){
        em.persist(member);
        return member.getId();
    }

    //멤버 조회(아이디로)
    public Member find(Long id){
        return em.find(Member.class, id);
    }
}
