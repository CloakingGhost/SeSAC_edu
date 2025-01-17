package com.example.relation.domain.post;

import com.example.relation.domain.post.dto.PostListWithCommentCountProjection;
import com.example.relation.domain.post.entity.Post;
import com.example.relation.domain.post.entity.Post2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface Post2Repository extends JpaRepository<Post2, Long> {


    // 쿼리 메소드
    Page<Post2> findAllByAuthorId(Long authorId, Pageable pageable);
}
