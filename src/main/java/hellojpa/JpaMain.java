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

            /*
            Member findMember1 = em.find(Member.class, 1L);
            Member findMember2 = em.find(Member.class, 1L);

            System.out.println("result = " + (findMember1 == findMember2));
             */

            /*
            Member member1 = new Member(150L, "A");
            Member member2 = new Member(160L, "B");

            //쓰기 지연 SQL 저장소에 저장
            em.persist(member1);
            em.persist(member2);
             */

            /*
            Member member = em.find(Member.class, 150L);
            member.setName("ZZZZZ");
             */

            //이 때 DB로 쿼리들이 flush 됨
            //tx.commit();

            Team team = new Team();
            team.setName("TeamA");
            em.persist(team);

            Member member = new Member();
            member.setUsername("member1");
            member.setTeam(team);
            em.persist(member);

            Member findMember = em.find(Member.class, member.getId());
            Team findTeam = findMember.getTeam();
            System.out.println("findTeam.getName() = " + findTeam.getName());

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
