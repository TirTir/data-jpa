package study.datajpa.repository;

import jakarta.persistence.EntityManager;
import study.datajpa.entity.Member;

import java.util.List;
import java.util.Optional;

public class MemberJpaRepository {
    private EntityManager em;

    public Member save(Member member) {
        em.persist(member); //영속성 컨텍스트에 추가
        return member;
    }

    public void delete(Member member){
        em.remove(member); //엔티티 삭제
    }

    public List<Member> findAll(){
        return em.createQuery("select m from Member m", Member.class) //JPQL 쿼리 생성
                .getResultList();
    }

    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id); //엔티티 조회
        return Optional.ofNullable(member);
    }

    public long count(){
        return em.createQuery("select count(m) from Member m", Long.class)
                .getSingleResult();
    }

    public Member find(Long id){
        return em.find(Member.class, id);
    }
}
