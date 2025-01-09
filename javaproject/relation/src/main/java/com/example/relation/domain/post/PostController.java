package com.example.relation.domain.post;

import com.example.relation.domain.post.dto.*;
import com.example.relation.domain.tag.dto.TagRequestDto;
import com.example.relation.global.response.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping
    public ResponseEntity<ApiResponse<PostResponseDto>> createPost(@Valid @RequestBody PostCreateRequestDto requestDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(
                        ApiResponse.ok("게시글이 성공적으로 작성되었습니다", "CREATED",
                                postService.createPost(requestDto)
                        )
                );
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<PostListResponseDto>>> readPosts() {
        ApiResponse<List<PostListResponseDto>> response = ApiResponse.ok(postService.readPosts());

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<PostWithCommentResponseDto>> readPostById(@PathVariable Long id) {
        // post와 comment를 담고 있는 DTO로 바꿈
        ApiResponse<PostWithCommentResponseDto> response = ApiResponse.ok(postService.readPostById(id));
        return ResponseEntity.ok(response);

    }

    @GetMapping("/v2/{id}")
    public ResponseEntity<ApiResponse<PostWithCommentResponseDtoV2>> readPostByIdV2(@PathVariable Long id) {
        // post와 comment를 담고 있는 DTO로 바꿈
        ApiResponse<PostWithCommentResponseDtoV2> response = ApiResponse.ok(postService.readPostByIdV2(id));
        return ResponseEntity.ok(response);

    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<PostResponseDto>> updatePost(@PathVariable Long id, @RequestBody PostUpdateRequestDto requestDto) {
        ApiResponse<PostResponseDto> response = ApiResponse.ok("게시글이 성공적으로 수정되었습니다", "UPDATED", postService.updatePost(id, requestDto));

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        ApiResponse<Void> response = ApiResponse.ok("게시글이 성공적으로 삭제되었습니다", "DELETED", null);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);

    }


    @GetMapping("/{id}/count-comment")
    public ResponseEntity<ApiResponse<List<PostWithCountCommentResponseDto>>> readPostWithCountComment(@PathVariable Long id) {
        List<PostWithCountCommentResponseDto> body = postService.readPostWithCountComment(id);
        return ResponseEntity.ok(
                ApiResponse.ok(body)
        );
    }

    @GetMapping("/count-comment")
    public ResponseEntity<ApiResponse<List<PostListWithCommentCountResponseDto>>> readPostWithCommentCount() {
        List<PostListWithCommentCountResponseDto> body = postService.readPostsWithCommentCount();
        return ResponseEntity.ok(
                ApiResponse.ok(body)
        );
    }

    @GetMapping("/count-comment-dto")
    public ResponseEntity<ApiResponse<List<PostListWithCommentCountProjection>>> readPostWithCommentCountDto() {
        List<PostListWithCommentCountProjection> body = postService.readPostsWithCommentCountDto();
        return ResponseEntity.ok(
                ApiResponse.ok(body)
        );
    }

    @PostMapping("/{id}/tags")
    public ResponseEntity<ApiResponse<Class<Void>>> addTagToPost(
            @PathVariable Long id,
            @Valid @RequestBody TagRequestDto requestDto
    ) {
        postService.addTagToPost(id, requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.ok(Void.TYPE));

    }

    // 게시글을 댓글과 태그들과 함께 조회
    @GetMapping("/{id}/detail")
    public ResponseEntity<ApiResponse<PostWithCommentAndTagResponseDto>> readPostByIdWithCommentAndTag(@PathVariable Long id) {
        return ResponseEntity.ok(
                ApiResponse.ok(
                        postService.readPostByIdWithCommentAndTag(id)
                )
        );
    }

    @GetMapping("/{id}/detail/v2")
    public ResponseEntity<ApiResponse<PostWithCommentAndTagResponseDtoV2>> readPostByIdWithCommentAndTagV2(@PathVariable Long id) {
        return ResponseEntity.ok(
                ApiResponse.ok(
                        postService.readPostByIdWithCommentAndTagV2(id)
                )
        );
    }
}





