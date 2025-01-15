package com.example.relation.global.security.jwt;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtTokenProvider jwtTokenProvider;
    private final UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, // 톰캣에서 서블랫으로 요청을 받음
                                    HttpServletResponse response, // 톰캣에서 서블랫으로 응담을 보냄
                                    FilterChain filterChain) throws ServletException, IOException {
        // 1. 요청으로 부터 JWT 가져오기
        String token = getTokenFromRequest(request);

        // 2. 토큰에 값이 있는지 확인 &&
        if (
                StringUtils.hasText(token)
                        && jwtTokenProvider.validateToken(token) // 위조여부 판단
        ) {
            //3. 토큰의 payload에서 username 가져오기
            String username = jwtTokenProvider.getUsername(token);
            //4. userRepository에서 username을 통해 데이터 가져오기
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);

            //5. user data를 바탕으로 "authentication", 인증 객체 만들기
            //인증 정보
            Authentication authentication =
                    new UsernamePasswordAuthenticationToken(
                            userDetails, // 유저 식별을 위한 기본 정보
                            null, // 비밀번호
                            userDetails.getAuthorities()// 권한
                    );

            //6. 123123123123
            //SecurityContext 의 클래스
            // 인증이 들어있는 공간
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        filterChain.doFilter(request, response);
    }

    private String getTokenFromRequest(HttpServletRequest request) {
        // 1. 요청의 header로부터 "Authorization" 이라는 key 값을 가지는 value를 가지고 온다.
        String bearerToken = request.getHeader("Authorization");
        // 2. 그 value가 비어있지 않고 && Bearer로 시작하면 뒤에 이는 token을 return할게
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }
}