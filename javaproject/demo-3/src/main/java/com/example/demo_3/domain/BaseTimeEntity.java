package com.example.demo_3.domain;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseTimeEntity{

    @CreatedDate // 생성용
    @Column(updatable = false) // 수정 불가
    private LocalDateTime createdAt;

    @LastModifiedDate // 수정용
    private LocalDateTime updatedAt;


}