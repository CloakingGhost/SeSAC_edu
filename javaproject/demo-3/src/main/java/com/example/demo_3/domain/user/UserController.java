package com.example.demo_3.domain.user;

import com.example.demo_3.global.common.ApiResponse;
import com.example.demo_3.domain.user.dto.requset.UserCreateRequestDto;
import com.example.demo_3.domain.user.dto.requset.UserUpdateRequestDto;
import com.example.demo_3.domain.user.dto.response.UserListResponseDto;
import com.example.demo_3.domain.user.dto.response.UserResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @PostMapping
    public ResponseEntity<ApiResponse<UserResponseDto>> createUser(@Valid @RequestBody UserCreateRequestDto requestDto) {
        ApiResponse<UserResponseDto> body = ApiResponse.ok("Created", "CREATED", userService.createUser(requestDto));
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(body);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<UserListResponseDto>>> readUsers() {
        ApiResponse<List<UserListResponseDto>> body = ApiResponse.ok(userService.readUsers());
        return ResponseEntity.ok(body);
    }

    @GetMapping("/{id}")
    public UserResponseDto readUser(@PathVariable Long id) {
        return userService.readUser(id);
    }

    @PutMapping("/{id}")
    public UserResponseDto updateUser(@PathVariable Long id, @Valid @RequestBody UserUpdateRequestDto requestDto) {
        return userService.updateUser(id, requestDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeUser(@PathVariable Long id) {
        userService.removeUser(id);
    }

    @GetMapping("/search")
    public List<UserResponseDto> search(
            @RequestParam(required = false) String nickname,
            @RequestParam(required = false) Integer minAge,
            @RequestParam(required = false) Integer maxAge,
            @RequestParam(required = false) Boolean active,
            @RequestParam(required = false) String email
    ) {
        List<UserResponseDto> users = userService.searchUsers(nickname, minAge, maxAge, active, email);
        return users;
    }
}
