package com.example.demo.myjpasitev3;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jpa/v3/posts")
@RequiredArgsConstructor
public class PostControllerJpaV3 {
    private final PostServiceJpaV3 postServiceJpaV3;

    @PostMapping
    public PostJpaV3 createPost(@RequestBody PostJpaV3 postJpaV3){
        return postServiceJpaV3.createPost(postJpaV3);
    }

    @GetMapping
    public List<PostJpaV3> readPosts(){
        return postServiceJpaV3.readPosts();
    }

    @GetMapping("/{id}")
    public PostJpaV3 readPostById(@PathVariable Long id) {
        return postServiceJpaV3.readPostById(id);
    }
//
//    @PutMapping("/{id}")
//    public PostJpaV3 updatePost(@PathVariable Long id, @RequestBody PostJpaV3 postJpaV3) {
//        return postServiceJpaV3.updatePost(id, postJpaV3);
//    }
//
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remove(@PathVariable Long id){
        postServiceJpaV3.delete(id);
    }


}
