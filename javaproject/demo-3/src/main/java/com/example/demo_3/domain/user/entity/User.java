package com.example.demo_3.domain.user.entity;

import com.example.demo_3.global.common.ApiResponse;
import com.example.demo_3.domain.user.dto.requset.UserUpdateRequestDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class User extends ApiResponse.BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Column(nullable = false, unique = true, updatable = false, length = 20) // DB 제약조건
    private String username;

    @Setter
    @Email // 이메일 형식 검증
    @Column(nullable = false, unique = true) // DB 제약조건
    private String email;

    @Setter
    @Column(nullable = false, length = 10) // DB 제약조건
    private String nickname;

    @Setter
    private Integer age; // 코드 기본값

    @Setter
    @ColumnDefault("1") // DB 기본값 (MySQL에서는 true를 1로 표현)
    private Boolean isActive; // 코드 기본값

    @Builder
    public User(String username, String email, String nickname, Integer age) {
        this.username = username;
        this.email = email;
        this.nickname = nickname;
        this.age = age;
        this.isActive = true; // 기본값 처리
    }

    public void update(UserUpdateRequestDto requestDto) {
        this.email = requestDto.getEmail();
        this.nickname = requestDto.getNickname();
        this.age = requestDto.getAge();
    }
}
