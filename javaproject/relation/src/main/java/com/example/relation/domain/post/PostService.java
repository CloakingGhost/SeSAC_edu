package com.example.relation.domain.post;

import com.example.relation.domain.comment.Comment;
import com.example.relation.domain.comment.CommentRepository;
import com.example.relation.domain.post.dto.*;
import com.example.relation.domain.post.entity.Post;
import com.example.relation.domain.post.entity.PostTag;
import com.example.relation.domain.tag.TagRepository;
import com.example.relation.domain.tag.dto.Tag;
import com.example.relation.domain.tag.dto.TagRequestDto;
import com.example.relation.global.exception.DuplicateEntityException;
import com.example.relation.global.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

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

    public PostWithCommentResponseDtoV2 readPostByIdV2(Long id) {
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

    public List<PostWithCountCommentResponseDto> readPostWithCountComment(Long id) {
        List<Object[]> postWithCountComment = postRepository.findByIdWithCountComment(id);
        return postWithCountComment.stream().map(result -> {
            Post post = (Post) result[0];
            Long count = ((Number) result[1]).longValue();
            return PostWithCountCommentResponseDto.from(post, count);
        }).toList();
    }

    public List<PostListWithCommentCountResponseDto> readPostsWithCommentCount() {
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
//        Tag tag = tagRepository.findByName(requestDto.getName()).orElseThrow(ResourceNotFoundException::new);

        Tag tag = tagRepository.findByName(requestDto.getName())
                .orElseGet(() -> tagRepository.save(
                        new Tag(requestDto.getName()))
                );

        if(postTagRepository.existsByPostAndTag(post, tag)){
            throw new DuplicateEntityException();
        }

        PostTag postTag = new PostTag();
        postTag.addTag(tag);
        postTag.addPost(post);

        // 연관관계 편의 메소드
//        addPost(post) 안에서 할 수도 있음
//        단, post.getComments == null 예외 발생할 수 있음
        post.getPostTags().add(postTag);

        postTagRepository.save(postTag);
    }

    //
    public PostWithCommentAndTagResponseDto readPostByIdWithCommentAndTag(Long id) {
        //post 가져오자
//        Post post = postRepository.findByIdWithCommentAndTag(id).orElseThrow(ResourceNotFoundException::new);
        Post post = postRepository.findByIdWithTag(id).orElseThrow(ResourceNotFoundException::new);
        List<Comment> comments = commentRepository.findByPostId(id);

        return PostWithCommentAndTagResponseDto.from(post, comments);
    }

    // batch_size
    public PostWithCommentAndTagResponseDtoV2 readPostByIdWithCommentAndTagV2(Long id) {
        Post post = postRepository.findByIdWithCommentAndTag(id).orElseThrow(ResourceNotFoundException::new);

        return PostWithCommentAndTagResponseDtoV2.from(post);
    }

    public List<PostWithCommentAndTagResponseDtoV2> readPostDetail() {
        return postRepository.findWithCommentAndTag().stream()
                .map(PostWithCommentAndTagResponseDtoV2::from)
                .toList();
    }

    public Stream<PostListResponseDto> readPostsByTag(String tagName) {
        List<Post> posts = postRepository.findAllByTagName(tagName);
        return posts.stream().map(
                PostListResponseDto::from
        );
    }


    @Transactional
    public PostWithCommentAndTagResponseDto createPostWithTags(PostCreateWithTagsRequestDto requestDto) {
        Post post = postRepository.save(requestDto.toEntity()); // @OneToMany 초기화 안해서 에러났음
        List<String> tagNames = requestDto.getTags();

        for (String tagName : tagNames) {
            Tag tag = tagRepository.findByName(tagName).orElseGet(() -> {
                Tag newTag = new Tag(tagName);
                return tagRepository.save(newTag);
            });
            PostTag postTag = new PostTag(post, tag);
//            postTagRepository.save(postTag); //  Post에 cascade 적용 시 생략 가능
            post.getPostTags().add(postTag); // 연관관계 편의메소드

        }
        return PostWithCommentAndTagResponseDto.from(post, new ArrayList<>());
    }

}
