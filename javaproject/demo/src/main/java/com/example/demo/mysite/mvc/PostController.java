package com.example.demo.mysite.mvc;

import com.example.demo.mysite.Post;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mvc/posts")
public class PostController {

    PostService postService = new PostService();

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Post createPost(@RequestBody Post newPost) {
        return postService.createPost(newPost);

    }

    @GetMapping
    public List<Post> readPost() {
        return postService.readPosts();
    }

    @GetMapping("/{id}")
    public Post readPostById(@PathVariable Long id) {
        return postService.readPostById(id);
    }

    @PutMapping("/{id}")
    public Post updatePost(@PathVariable Long id, @RequestBody Post updatedPost) {
        return postService.updatePost(id, updatedPost);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // 응답값이 아예 없음, 상태코드만 넘겨 줌
    public boolean deletePost(@PathVariable Long id) {
        return postService.deletePost(id);
    }


//    @DeleteMapping("/{id}")
//    public ResponseEntity<Boolean> deletePost(@PathVariable Long id){
//        ResponseEntity<Boolean> responseEntity = new ResponseEntity<>(postService.deletePost(id), HttpStatus.NO_CONTENT);
//        return responseEntity;
//    }
}
