package com.example.demo_3.domain.user.requset;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Getter
@NoArgsConstructor
public class UserUpdateRequestDto {

    @Email(message = "인증가능한 이메일을 입력해야 합니다.") // 유효성 검사, null 확인 안함
    @NotBlank(message = "이메일은 필수 입력 사항입니다.") // 유효성 검사
    private String email;

    @Length(min = 2, max = 10, message = "닉네임은 2자 이상 10자 이하여야 합니다.") // 유효성 검사
    private String nickname;

    @Min(0) // 최소값 검증
    @Max(150) // 최대값 검증
    private Integer age;


}
