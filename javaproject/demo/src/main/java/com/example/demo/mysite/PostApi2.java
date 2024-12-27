package com.example.demo.mysite;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PostApi2 {
    // CRUD를 통해 Post를 관리하는 필드
    // DB의 엔티티
    public static final List<Post> posts = new ArrayList<>();

    // 계시글 생성에서 id 생성을 위한 장치
    // 나중에 DB에서 자동으로 할 건데 실습이니까
    private Long id = 0L;

    {
        for (int i = 0; i < 3; i++) {
            posts.add(new Post(++id, "제목 " + id, "내용 " + id));
        }

    }

    // create
    // post / 내용 / url
//    @GetMapping("/posts/create")
    // /posts / method POST
    @PostMapping("/v2/posts")
    public Post createPost() {
        Post post = new Post(++id, "제목 " + id, "내용 " + id);
        posts.add(post);

        return post;
    }

    // read
    // posts/ get /
    @GetMapping("/v2/posts")
    public List<Post> readPosts() {
        return posts;
    }

    @GetMapping("/v2/posts/{id}")
    public Post readPost(@PathVariable Long id) {
        for (Post post : posts) {
            if (post.getId().equals(id)) {
                return post;
            }
        }
        return null;
    }

//    @GetMapping("/posts/{id}/update")
    @PutMapping("/v2/posts/{id}")
    // /posts/{id} / method PUT(전체) | PATCH(일부)
    public Post updatePost(@PathVariable Long id) {
        for (Post post : posts) {
            if (post.getId().equals(id)) {
                post.setTitle("수정된 " + post.getTitle());
                post.setTitle("수정된 " + post.getContent());
                return post;
            }
        }
        return null;
    }

//    @GetMapping("/posts/{id}/delete")
    // /posts/{id} method DELETE
    @DeleteMapping("/v2/posts/{id}")
    public boolean deletePost(@PathVariable Long id) {
        for (Post post : posts) {
            if (post.getId().equals(id)) {
                return posts.remove(post);
            }
        }
        return false;
    }
}
