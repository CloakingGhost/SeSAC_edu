package com.example.relation.global.config;

import com.example.relation.global.security.SecurityPathConfig;
import com.example.relation.global.security.handler.CustomAccessDeniedHandler;
import com.example.relation.global.security.handler.JwtAuthenticationEntryPoint;
import com.example.relation.global.security.jwt.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity // Security On!
@RequiredArgsConstructor
public class SecurityConfig {
    private final CustomAccessDeniedHandler accessDeniedHandler;
    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .cors(cors -> cors.configurationSource(corsConfigurationSource())) // CORS 설정 연결
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/auth/verify").authenticated() // 어떤 페이지 던 한번씩 app.jsx에서 들어옴
                        .requestMatchers(
                                "/auth/**",
                                "/error", // 스프링의 에러처리 경로
                                "/images/**"
                        ).permitAll() // /auth 모든 경로 허용
                        .requestMatchers(
                                HttpMethod.GET, // GET 요청에 대한
                                SecurityPathConfig.PUBLIC_GET_URLS) // 이곳에 기록된 URL을 허용
                        .permitAll()
                        .anyRequest().authenticated() // 나머지 로그인하고 들어와
                )
                // User~~~ 이전에 jwtAuth~~ 먼저 실행
                // jwt 필터를 거지치 않으면 그 다음 필터 실행o
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling(exception -> exception
                        .accessDeniedHandler(accessDeniedHandler)
                        .authenticationEntryPoint(jwtAuthenticationEntryPoint)
                );

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(
            // 1. UserDetailsService를 필요로 한다. DI 해야함 -> service를 만들어 줘야 함 -> global/security/CustomUserDetailsService
            UserDetailsService userDetailsService, // 인증관련된 정보가 들어 있음, DB에서 정보를 가져와야 함
            PasswordEncoder passwordEncoder // 비밀번호 암호화, 어떤 알고리즘으로 암호화를 했는지 알려주기 위해
    ) {
        // 유저 식별 장치
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder);

        // 유저를 가지고 오는 능력
        // 패스워드 인코딩하는 능력
        // 이 객체로 유저를 식별한다.
        return new ProviderManager(authProvider);
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.addAllowedOrigin("http://localhost:5173");
        configuration.addAllowedMethod("*");
        configuration.addAllowedHeader("*");
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

}
