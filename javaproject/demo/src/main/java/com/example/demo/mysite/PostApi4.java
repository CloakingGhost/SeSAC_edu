package com.example.demo.mysite;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v4/posts")
public class PostApi4 {
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
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Post createPost(@RequestBody Post newPost) {
        System.out.println("newPost = " + newPost);
        String title = newPost.getTitle();
        String content = newPost.getContent();
        System.out.println("newPost.getTitle() = " + title);
        System.out.println("newPost.getContent() = " + content);

        if(title == null || title.isBlank()) throw new RuntimeException("input title");
        if(content == null || content.isBlank()) throw new IllegalArgumentException("input content");

        Post post = new Post(++id, title + " " + id, content + " " + id);
        posts.add(post);

        return post;
    }

    // read
    // posts/ get /
    @GetMapping
    public List<Post> readPosts() {
        return posts;
    }

    @GetMapping("/{id}")
    public Post readPost(@PathVariable Long id) {
        for (Post post : posts) {
            if (post.getId().equals(id)) {
                return post;
            }
        }
        return null;
    }

    //    @GetMapping("/posts/{id}/update")
    @PutMapping("/{id}")
    // /posts/{id} / method PUT(전체) | PATCH(일부)
    public Post updatePost(@PathVariable Long id, @RequestBody Post updatedPost) {
        for (Post post : posts) {
            if (post.getId().equals(id)) {
                post.setTitle("수정된 " + updatedPost.getTitle());
                post.setTitle("수정된 " + updatedPost.getContent());
                return post;
            }
        }
        return null;
    }

    //    @GetMapping("/posts/{id}/delete")
    // /posts/{id} method DELETE
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public boolean deletePost(@PathVariable Long id) {
        for (Post post : posts) {
            if (post.getId().equals(id)) {
                return posts.remove(post);
            }
        }
        return false;
    }

    @GetMapping("/paged")
    public List<Post> getPagedPosts(@RequestParam String key) {
        System.out.println("key = " + key);
        return posts;
    }
}
