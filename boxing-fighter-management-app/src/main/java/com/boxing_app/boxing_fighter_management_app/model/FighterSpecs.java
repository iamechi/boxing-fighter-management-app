package com.boxing_app.boxing_fighter_management_app.model;

import org.springframework.data.jpa.domain.Specification;

public class FighterSpecs {
    public static Specification<Fighter> findById(Long providedID) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("fighterID"),providedID);
    }

    public static Specification<Fighter> firstNameStartsWith(String providedName) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("first_name"), providedName + "%");
    }

    public static Specification<Fighter> lastNameStartsWith(String providedName) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("last_name"), providedName + "%");
    }
}
