package com.example.relation.global.security.service;

import com.example.relation.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    // 사람마다 서비스가 다르기 때문에 상위 객체를 리턴함
    // 나는 User를 만들었지만 UserDetails를 리턴함
    // 다운캐스팅이 필요할 수 있음
    @Override
    public UserDetails loadUserByUsername(String username)  {
        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
