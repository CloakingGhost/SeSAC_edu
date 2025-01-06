package com.example.demo.myjpasitev2;

import com.example.demo.myjpasite.PostJpa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceUnit;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor

public class PostRepositoryJpaV2 {
    @PersistenceUnit
    private final EntityManagerFactory emf;

    public PostJpaV2 save(PostJpaV2 post) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try (em) {

            // DB 소통하기 위해
            tx.begin();
            em.persist(post); // 저장 쿼리 실행
            tx.commit(); // 쿼리의 결과 저장

            return post;
        } catch (Exception e) {
            tx.rollback(); // 쿼리 취소
            throw e;
        }
    }

    public PostJpaV2 findById(Long id) {
        try (EntityManager em = emf.createEntityManager()) {
            return em.find(PostJpaV2.class, id);
        } catch (Exception ignored) {

        }
        return null;
    }

    public List<PostJpaV2> findAll() {
        try (EntityManager em = emf.createEntityManager()) {
            return em.createQuery("SELECT p FROM PostJpaV3 p", PostJpaV2.class).getResultList();
        }

    }

    public PostJpaV2 update(Long id, PostJpaV2 updated) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            PostJpaV2 post = em.find(PostJpaV2.class, id);

            String title = updated.getTitle();
            String content = updated.getContent();
            post.update(title, content);
            tx.commit();

            return post;
        } catch (Exception e) {
            tx.rollback();
            throw e;
        } finally {
            em.close();
        }

    }

    public void delete(Long id){
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            PostJpaV2 post = em.find(PostJpaV2.class, id);
            em.remove(post);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            em.close();
        }
    }

}
