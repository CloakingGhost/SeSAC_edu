package com.example.relation.domain.comment;

import com.example.relation.domain.comment.dto.CommentRequestDto;
import com.example.relation.domain.post.entity.Post;
import com.example.relation.global.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;



    @Builder
    public Comment(String content, Post post){
        this.content = content;
//        this.post = post;
        setPost(post);
    }

    // Comment가 생성 될 때
    // 일대다, 양방향 일 때
    // 주인에 입장에서 주인이 아닌 요소에게 주인은 나를 넣어 줄게
    public void setPost(Post post) {
        this.post = post;
        post.getComments().add(this);
    }

    public Comment update(CommentRequestDto requestDto) {
        this.content= requestDto.getContent();
        return this;
    }
}
