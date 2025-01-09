package com.example.relation.domain.post.entity;

import com.example.relation.domain.tag.dto.Tag;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@EntityListeners(AuditingEntityListener.class)// Entity 의 CRUD 감지
public class PostTag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tag_id")
    private Tag tag;

    @CreatedDate
    @Column(updatable = false) // 수정불가
    private LocalDateTime createdAt;

    public void addPost(Post post) {
        this.post = post;
    }

    public void addTag(Tag tag) {
        this.tag = tag;
    }
}
