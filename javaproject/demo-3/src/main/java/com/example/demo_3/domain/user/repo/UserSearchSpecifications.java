package com.example.demo_3.domain.user.feature;

import com.example.demo_3.domain.user.entity.User;
import org.springframework.data.jpa.domain.Specification;

public class UserSearchSpecifications {

    public static Specification<User> hasNickname(String nickname) {
        // root == User
        return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("nickname"), nickname));
    }

    public static Specification<User> hasAge(Integer minAge, Integer maxAge) {
        return ((root, query, criteriaBuilder) -> criteriaBuilder.between(root.get("age"), minAge, maxAge));

    }

    public static Specification<User> isActiveStatus(boolean b) {
        return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("isActive"), b));
    }

    public static Specification<User> hasEmailContaining(String email) {
        return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("email"), String.format("%%s%", email)));
    }


}
