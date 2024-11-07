package hellojpa;

import jakarta.persistence.*;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        //트랜잭션 시작
        tx.begin();

        try {
            //멤버 데이터 저장
            /*
            Member member = new Member();
            member.setId(1L);
            member.setName("HelloA");

            em.persist(member);
             */

            //멤버 데이터 조회
            /*
            Member findMember = em.find(Member.class, 1L);
            System.out.println("findMember.id = " + findMember.getId());
            System.out.println("findMember.name = " + findMember.getName());
             */

            //멤버 데이터 수정
            /*Member findMember = em.find(Member.class, 1L);
            findMember.setName("HelloJPA");
             */

            //멤버 데이터 삭제
            /*
            Member findMember = em.find(Member.class, 1L);
            em.remove(findMember);
             */

            //트랜잭션 종료
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
