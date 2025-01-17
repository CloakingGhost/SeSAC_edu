package com.example.relation.domain.user.controller;

import com.example.relation.domain.post.dto.Post2ListWithPageResponseDto;
import com.example.relation.domain.user.dto.response.UserResponseDto;
import com.example.relation.domain.user.entity.User;
import com.example.relation.domain.user.service.UserService;
import com.example.relation.global.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;


    // 인증이 완료 됐으니까 들어온거임
    @GetMapping("/my/profile")
    public ResponseEntity<ApiResponse<UserResponseDto>> getMyProfile() {
        // 요청에 가져온 데이터 전처리
        // 헤더, 그 외 data
        Authentication authentication =
                SecurityContextHolder.getContext() // Holder 그 자체 임
                        .getAuthentication();
        User user = (User) authentication.getPrincipal();// 유저 정보, redux 비슷한 공용 공간에서 빼 옴
// 유저 정보를 리턴할 것임

        return ResponseEntity.ok(
                ApiResponse.ok(
                        userService.getMyProfile(user)
                )
        );
    }

    @GetMapping("/my/profile2")
    public ResponseEntity<ApiResponse<UserResponseDto>> getMyProfile2(
            @AuthenticationPrincipal User user
    ) {
        return ResponseEntity.ok(ApiResponse.ok(
                userService.getMyProfile(user)
        ));
    }


    @GetMapping("/my/posts")
    public ResponseEntity<ApiResponse<Post2ListWithPageResponseDto>> getMyPosts(@AuthenticationPrincipal User user, Pageable pageable) {
        return ResponseEntity.ok(
                ApiResponse.ok(
                        userService.getMyPosts(user, pageable)
                )
        );
    }
}
