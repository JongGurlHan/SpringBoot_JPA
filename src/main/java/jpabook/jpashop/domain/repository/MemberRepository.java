package jpabook.jpashop.domain.repository;

import jpabook.jpashop.domain.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class MemberRepository {

    @PersistenceContext //스프링이 엔티티 매니저를 만들어서 주입해준다.
    private EntityManager em;

    //memeber저장
    public void save(Member member){
        em.persist(member);
    }

    //member 단건 조회 -jpa가 제공하는 find메소드 이용
    public Member findOne(Long id) {
        return em.find(Member.class, id); //단건조회(타입, PK)
    }

    //member 리스트로 조회, 전부다 찾을때는 JPQL을 작성해야한다.(JPQL, 반환타입)
    public List<Member> findAll(){
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }
    //SQL은 테이블을 대상으로 쿼리를짜지만,
    //JPQL은 엔티티 객체를 대상으로 쿼리를 짠다. from의 대상이 테이블이 아닌 엔티티가 된다.


    //이름으로 member조회
    public List<Member>findByName(String name){
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }

}
