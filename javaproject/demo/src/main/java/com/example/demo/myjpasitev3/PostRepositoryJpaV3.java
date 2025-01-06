package com.example.demo.myjpasitev3;


import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor

public class PostRepositoryJpaV3 {
    private final EntityManager em;

    public PostJpaV3 save(PostJpaV3 post) {
        em.persist(post);
        return post;
    }

    public List<PostJpaV3> findAll() {
        return em.createQuery("SELECT p FROM PostJpaV3 p", PostJpaV3.class).getResultList();
    }

    public PostJpaV3 findById(Long id) {
        return em.find(PostJpaV3.class, id);
    }

    public void delete(PostJpaV3 post) {
        em.remove(post);
    }
}
