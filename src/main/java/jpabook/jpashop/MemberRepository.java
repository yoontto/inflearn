package jpabook.jpashop;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class MemberRepository {

    @PersistenceContext
    private EntityManager em;

    //멤버 저장하는 코드
    public Long save(Member member){
        em.persist(member);
        return member.getId();
    }

    //멤버 불러오는 코드
    public Member find(Long id) {
        return em.find(Member.class, id);
    }
}
