package com.example.relation.domain.user.service;

import com.example.relation.domain.user.UserRepository;
import com.example.relation.domain.user.dto.requset.LoginRequestDto;
import com.example.relation.domain.user.dto.requset.SignupRequestDto;
import com.example.relation.domain.user.dto.response.SignupResponseDto;
import com.example.relation.domain.user.dto.response.TokenResponseDto;
import com.example.relation.domain.user.entity.User;
import com.example.relation.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;

    //JWT 생성
    //1. DTO를 받습니다.
    public TokenResponseDto login(LoginRequestDto requestDto) {
        //3. 객체로 만든 것을 manager에게 통과시켜 인증 정보가 들어있는 "authentication"객체를 만듭니다.
        //4. ""authenticationManager"를 활용하기 위해 DI를 해줍니다 => security config로 이동
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        //2. DTO로 부터 온 정보를 객체로 만듭니다.
                        requestDto.getUsername(),
                        requestDto.getPassword()
                )
        );
        // 5. 사용자 인정되었다는 정보가 들어있는 "authentication"를 활용해서
        // securityContext라는 곳에 인증정보를 저장한다.
        // 인증이 된 사람의 정보를 이곳에 저장하여
//        SecurityContextHolder.getContext().setAuthentication(authentication);

        // "jwtTokenProvider" DI
        String jwt = jwtTokenProvider.createToken(authentication);
        return new TokenResponseDto(jwt);
    }

    @Transactional
    public SignupResponseDto signup(SignupRequestDto requestDto) {
        // 유저네임 있어?
        if (userRepository.existsByUsername(requestDto.getUsername())) {
            throw new IllegalArgumentException("이미 사용중인 아이디입니다.");
        }
        // 이메일 있어?
        if (userRepository.existsByEmail(requestDto.getEmail())) {
            throw new IllegalArgumentException("이미 사용중인 이메일입니다.");
        }

        String encodedPassword = passwordEncoder.encode(requestDto.getPassword());

        User user = userRepository.save(requestDto.toEntity(encodedPassword));
        return SignupResponseDto.from(user);


    }


}
