package com.example.relation.domain.user.service;

import com.example.relation.domain.post.Post2Repository;
import com.example.relation.domain.post.dto.Post2ListWithPageResponseDto;
import com.example.relation.domain.post.entity.Post2;
import com.example.relation.domain.user.UserRepository;
import com.example.relation.domain.user.dto.response.UserResponseDto;
import com.example.relation.domain.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final Post2Repository post2Repository;

    public UserResponseDto getMyProfile(User user) {
        // repository 안쓰는 이유 컨트롤러에서 컨텍스트에 저장된 데이터를 가져왔기 때문
        // UserDetails는 User에 모든 것을 할 수 있다. 간소화 되었을 뿐임
        return UserResponseDto.from(user);
    }

    // Post 중 내가 작성한 것 찾기 : spring 권장 검색 방식
    public Post2ListWithPageResponseDto getMyPosts(User user, Pageable pageable) {
        Page<Post2> postsByAuthorId = post2Repository.findAllByAuthorId(user.getId(), pageable);
        return Post2ListWithPageResponseDto.from(postsByAuthorId);
    }

}
