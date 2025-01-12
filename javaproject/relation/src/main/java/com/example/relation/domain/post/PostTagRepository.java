package com.example.relation.domain.post;

import com.example.relation.domain.post.entity.Post;
import com.example.relation.domain.post.entity.PostTag;
import com.example.relation.domain.tag.dto.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostTagRepository extends JpaRepository<PostTag, Long> {
    boolean existsByPostAndTag(Post post, Tag tag);
}
