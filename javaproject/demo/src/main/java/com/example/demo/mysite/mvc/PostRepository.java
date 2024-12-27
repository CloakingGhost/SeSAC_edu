package com.example.demo.mysite.mvc;

import com.example.demo.mysite.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PostRepository {
    private final List<Post> posts = new ArrayList<>();
    private Long id = 0L;

    public Post save(Post newPost){

        String title = newPost.getTitle();
        String content = newPost.getContent();

        Post post = new Post(++id, title + " " + id, content + " " + id);
        posts.add(post);
        return post;
    }

    public List<Post> findAll(){
        return posts;
    }

    public Post findById(Long id){
        return posts.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }

    public Post modify(Long id, Post updatedPost){
        String newTitle = updatedPost.getTitle();
        String newContent = updatedPost.getContent();

        for (Post post : posts) {
            if(post.getId().equals(id)){
                post.setTitle(newTitle);
                post.setContent(newContent);
                return post;
            }
        }
        return null;
    }

    public boolean delete(Post post){
        return posts.remove(post);
    }

}