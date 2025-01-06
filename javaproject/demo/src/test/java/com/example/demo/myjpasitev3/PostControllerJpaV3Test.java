package com.example.demo.myjpasitev3;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@Transactional
class PostControllerJpaV3Test {

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private ObjectMapper objectMapper;

    private MockMvc mockMvc;

    @BeforeEach
    void setupMockMvc() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    @DisplayName("POST /jpa/v3/posts - Create Post")
    @Rollback
    void createPostTest() throws Exception {
        // Given
        PostJpaV3 post = new PostJpaV3();
        post.setTitle("Test Title");
        post.setContent("Test Content");

        // When
        ResultActions result = mockMvc.perform(post("/jpa/v3/posts")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(post)));

        // Then
        result.andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Test Title"))
                .andExpect(jsonPath("$.content").value("Test Content"));
    }

    @Test
    @DisplayName("GET /jpa/v3/posts - Read All Posts")
    @Rollback
    void readPostsTest() throws Exception {
        // When
        ResultActions result = mockMvc.perform(get("/jpa/v3/posts")
                .contentType(MediaType.APPLICATION_JSON));

        // Then
        result.andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
    }

    @Test
    @DisplayName("GET /jpa/v3/posts/{id} - Read Post By ID")
    @Rollback
    void readPostByIdTest() throws Exception {
        // Given
        Long id = 1L;

        // When
        ResultActions result = mockMvc.perform(get("/jpa/v3/posts/{id}", id)
                .contentType(MediaType.APPLICATION_JSON));

        // Then
        result.andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(id));
    }

    @Test
    @DisplayName("DELETE /jpa/v3/posts/{id} - Delete Post")
    @Rollback
    void deletePostTest() throws Exception {
        // Given
        Long id = 1L;

        // When
        ResultActions result = mockMvc.perform(delete("/jpa/v3/posts/{id}", id)
                .contentType(MediaType.APPLICATION_JSON));

        // Then
        result.andExpect(status().isNoContent());
    }
}
