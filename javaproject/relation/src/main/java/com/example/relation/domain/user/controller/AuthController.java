package com.example.relation.domain.user.controller;


import com.example.relation.domain.user.dto.requset.LoginRequestDto;
import com.example.relation.domain.user.dto.requset.SignupRequestDto;
import com.example.relation.domain.user.dto.response.SignupResponseDto;
import com.example.relation.domain.user.dto.response.TokenResponseDto;
import com.example.relation.domain.user.service.AuthService;
import com.example.relation.global.response.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<ApiResponse<SignupResponseDto>> signup(
            @Valid @RequestBody SignupRequestDto requestDto
    ) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ApiResponse.ok(authService.signup(requestDto))
                );
    }

    // JWT 만들자 / return JWT
    @PostMapping("/login")
    public ResponseEntity<ApiResponse<TokenResponseDto>> login(@Valid @RequestBody LoginRequestDto requestDto) {
        return ResponseEntity.ok(ApiResponse.ok(
                        authService.login(requestDto)
                )
        );
    }

    // SecurityConfig에 필터를 통과하도록 추가 설정
    //시큐리티 필터를 통과하는지 확인 가능
    @GetMapping("/verify")
    public void verify(){}

}
