package com.example.relation.domain.post;

import com.example.relation.domain.comment.Comment;
import com.example.relation.domain.comment.CommentRepository;
import com.example.relation.domain.post.dto.*;
import com.example.relation.domain.post.entity.Post;
import com.example.relation.domain.post.entity.PostTag;
import com.example.relation.domain.tag.TagController;
import com.example.relation.domain.tag.TagRepository;
import com.example.relation.domain.tag.dto.Tag;
import com.example.relation.domain.tag.dto.TagRequestDto;
import com.example.relation.global.exception.ResourceNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostService {
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;
    private final TagRepository tagRepository;
    private final PostTagRepository postTagRepository;


    @Transactional
    public PostResponseDto createPost(PostCreateRequestDto requestDto) {
        Post post = postRepository.save(requestDto.toEntity());
        return PostResponseDto.from(post);
    }

    public List<PostListResponseDto> readPosts() {
        return postRepository.findAll().stream()
                .map(PostListResponseDto::from)
                .toList();
    }

    public PostWithCommentResponseDto readPostById(Long id) {
        Post post = postRepository.findById(id).orElseThrow(ResourceNotFoundException::new);

        List<Comment> comments = commentRepository.findByPostId(id);
        return PostWithCommentResponseDto.from(post, comments);
    }

    public PostWithCommentResponseDtoV2 readPostByIdV2(Long id){
//        post, comment를 한번에 가져오고 싶다.
        Post post = postRepository.findByIdWithComment(id).orElseThrow(ResourceNotFoundException::new);
        return PostWithCommentResponseDtoV2.from(post);
    }

    @Transactional
    public PostResponseDto updatePost(Long id, PostUpdateRequestDto requestDto) {
        Post post = postRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
        post = post.update(requestDto);

        return PostResponseDto.from(post);
    }

    @Transactional
    public void deletePost(Long id) {
        Post post = postRepository.findById(id).orElseThrow(ResourceNotFoundException::new);

        postRepository.delete(post);
    }

    public List<PostWithCountCommentResponseDto> readPostWithCountComment(Long id){
        List<Object[]> postWithCountComment = postRepository.findByIdWithCountComment(id);
        return postWithCountComment.stream().map(result -> {
            Post post = (Post) result[0];
            Long count = ((Number) result[1]).longValue();
            return PostWithCountCommentResponseDto.from(post, count);
        }).toList();
    }
    public List<PostListWithCommentCountResponseDto> readPostsWithCommentCount(){
        List<Object[]> results = postRepository.findAllWithCommentCount();
        return results.stream().map(
                result -> {
                    // 이부분을 JPQL에 위임할 수 있을
                    Post post = (Post) result[0];
                    Long commentCount = (Long) result[1]; // post.getComments().size() 대신 사용하려고 N + 1 방지
                    return new PostListWithCommentCountResponseDto(
                            post.getId(),
                            post.getTitle(),
                            post.getCreatedAt(),
                            commentCount
                    );
                }
        ).toList();
    }

    public List<PostListWithCommentCountProjection> readPostsWithCommentCountDto() {
        return postRepository.findAllWithCommentCountDTO();

    }

    @Transactional
    public void addTagToPost(Long id, TagRequestDto requestDto) {
        Post post = postRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
        Tag tag = tagRepository.findByName(requestDto.getName()).orElseThrow(ResourceNotFoundException::new);

        PostTag postTag = new PostTag();
        postTag.addTag(tag);
        postTag.addPost(post);

        postTagRepository.save(postTag);
    }
}
