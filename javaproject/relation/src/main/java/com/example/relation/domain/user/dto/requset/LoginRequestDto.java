package com.example.relation.domain.user.dto.requset;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LoginRequestDto {
    @NotBlank(message = "아이디 필수")
    private String username;
    @NotBlank(message = "비밀번호 필수")
    private String password;


}
