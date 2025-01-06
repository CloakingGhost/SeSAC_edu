package com.example.demo_3.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class User extends BaseTimeEntity {

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
    @Column(nullable = false, unique = true, length = 10) // DB 제약조건
    private String nickname;

    @Setter
    @ColumnDefault("-1") // DB 기본값
    private Integer age = -1; // 코드 기본값

    @Setter
    @ColumnDefault("1") // DB 기본값 (MySQL에서는 true를 1로 표현)
    private boolean isActive = true; // 코드 기본값

    @Builder
    public User(String username, String email, String nickname, Integer age, Boolean isActive) {
        this.username = username;
        this.email = email;
        this.nickname = nickname;
        this.age = age != null ? age : -1; // 기본값 처리
        this.isActive = isActive != null ? isActive : true; // 기본값 처리
    }
}
