package com.example.relation.domain.post;

import com.example.relation.domain.post.dto.*;
import com.example.relation.domain.tag.dto.TagRequestDto;
import com.example.relation.domain.user.entity.User;
import com.example.relation.global.response.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    // 특정 게시글 + 댓글 개수
    @GetMapping("/{id}/count-comment")
    public ResponseEntity<ApiResponse<List<PostWithCountCommentResponseDto>>> readPostWithCountComment(@PathVariable Long id) {
        List<PostWithCountCommentResponseDto> body = postService.readPostWithCountComment(id);
        return ResponseEntity.ok(
                ApiResponse.ok(body)
        );
    }

    // 모든 게시글 + 댓글 개수
    // DB에서 넘겨주는 값을 Entity에 받음
    @GetMapping("/count-comment")
    public ResponseEntity<ApiResponse<List<PostListWithCommentCountResponseDto>>> readPostWithCommentCount() {
        List<PostListWithCommentCountResponseDto> body = postService.readPostsWithCommentCount();
        return ResponseEntity.ok(
                ApiResponse.ok(body)
        );
    }

    // 모든 게시글 + 댓글 개수
    // DB에서 넘겨주는 값을 DTO에 받음
    @GetMapping("/count-comment-dto")
    public ResponseEntity<ApiResponse<List<PostListWithCommentCountProjection>>> readPostWithCommentCountDto() {
        List<PostListWithCommentCountProjection> body = postService.readPostsWithCommentCountDto();
        return ResponseEntity.ok(
                ApiResponse.ok(body)
        );
    }


    // 특정 게시글에 태그 추가
    @PostMapping("/{id}/tags")
    public ResponseEntity<ApiResponse<Class<Void>>> addTagToPost(
            @PathVariable Long id,
            @Valid @RequestBody TagRequestDto requestDto
    ) {
        postService.addTagToPost(id, requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.ok(Void.TYPE));

    }

    // (단건 게시글 + 태그) + (댓글) => DTO
    @GetMapping("/{id}/detail")
    public ResponseEntity<ApiResponse<PostWithCommentAndTagResponseDto>> readPostByIdWithCommentAndTag(@PathVariable Long id) {
        return ResponseEntity.ok(
                ApiResponse.ok(
                        postService.readPostByIdWithCommentAndTag(id)
                )
        );
    }

    //단건 게시글 + 댓글 + 태그 => DTO
    @GetMapping("/{id}/detail/v2")
    public ResponseEntity<ApiResponse<PostWithCommentAndTagResponseDtoV2>> readPostByIdWithCommentAndTagV2(@PathVariable Long id) {
        return ResponseEntity.ok(
                ApiResponse.ok(
                        postService.readPostByIdWithCommentAndTagV2(id)
                )
        );
    }

    // 다건 : 게시글 + 댓글 + 태그 => DTO
    @GetMapping("/detail")
    public ResponseEntity<List<PostWithCommentAndTagResponseDtoV2>> readPostsDetail() {
        return ResponseEntity.ok(
                postService.readPostDetail()
        );
    }

    // 게시글 생성
    // 다수 태그 저장 포함
    @PostMapping("/tags")
    public ResponseEntity<ApiResponse<PostWithCommentAndTagResponseDto>> createPostWithTags(@RequestBody PostCreateWithTagsRequestDto requestDto) {
        return ResponseEntity.ok(
                ApiResponse.ok(
                        postService.createPostWithTags(requestDto)
                )
        );
    }

    // 페이지네이션
    @GetMapping("/pages")
    public ResponseEntity<ApiResponse<List<PostListResponseDto>>> readPostsWithPage(Pageable pageable) {
        return ResponseEntity.ok(
                ApiResponse.ok(
                        postService.readPostsWithPage(pageable)
                )
        );
    }

    @GetMapping("/pages-detail")
    public ResponseEntity<ApiResponse<PostListWithPageResponseDto>> readPostsWithPageDetail(Pageable pageable) {
        return ResponseEntity.ok(
                ApiResponse.ok(
                        postService.readPostsWithPageDetail(pageable)
                )
        );
    }

    @GetMapping("/pages-detail-v2")
    public ResponseEntity<ApiResponse<List<PostWithCommentResponseDtoV2>>> readPostsWithPageDetailV2(Pageable pageable) {
        return ResponseEntity.ok(
                ApiResponse.ok(
                        postService.readPostsWithCommentPage(pageable)
                )
        );
    }

    // 이미지 처리
    @PostMapping("/images")
    public ResponseEntity<ApiResponse<PostWithImageResponseDto>> createPostWithImage(
            @RequestPart(value = "data") PostCreateRequestDto requestDto,
            @RequestPart(value = "image", required = false) MultipartFile image
    ) {
        return ResponseEntity.ok(ApiResponse.ok(
                postService.createPostWithImage(requestDto, image)
        ));
    }

    ///////////////////
    ////Post Version 2

    @PostMapping("/posts2")
    public ResponseEntity<ApiResponse<Post2ResponseDto>> createPost2(
            @Valid @RequestBody Post2CreateWithAuthorRequestDto requestDto,
            @AuthenticationPrincipal User user // security user 정보
    ) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(
                        ApiResponse.ok(
                                postService.createPost2(requestDto, user)
                        )
                );
    }
    @GetMapping("/posts2")
    public ResponseEntity<ApiResponse<List<Post2ResponseDto>>> readPosts2(){
        return ResponseEntity.ok(ApiResponse.ok(
                postService.readPosts2()
        ));
    }
}





