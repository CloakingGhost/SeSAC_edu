package com.example.demo.myjpasitev2;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jpa/v2/posts")
@RequiredArgsConstructor
public class PostControllerJpaV2 {
    private final PostServiceJpaV2 postServiceJpaV2;

    @PostMapping
    public PostJpaV2 createPost(@RequestBody PostJpaV2 postJpaV2){
        return postServiceJpaV2.createPost(postJpaV2);
    }

    @GetMapping
    public List<PostJpaV2> readPosts(){
        return postServiceJpaV2.readPosts();
    }

    @GetMapping("/{id}")
    public PostJpaV2 readPostById(@PathVariable Long id) {
        return postServiceJpaV2.readPostById(id);
    }

    @PutMapping("/{id}")
    public PostJpaV2 updatePost(@PathVariable Long id, @RequestBody PostJpaV2 postJpaV2) {
        return postServiceJpaV2.updatePost(id, postJpaV2);
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable Long id){
        postServiceJpaV2.delete(id);
    }


}
