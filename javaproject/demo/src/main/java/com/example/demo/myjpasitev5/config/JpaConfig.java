package com.example.demo.myjpasitev5.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration // 엔티티의 생성과 수정을 추적하는 기능
@EnableJpaAuditing
public class JpaConfig {
}
