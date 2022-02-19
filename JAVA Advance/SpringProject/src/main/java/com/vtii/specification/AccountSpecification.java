package com.vtii.specification;

import com.vtii.entity.Account;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class AccountSpecification implements Specification<Account> {
    private static final long serialVersionUID = 1L;
    //Truong can search
    private String field;
    //Toan tu trong sql(LIKE, AND, EQUAL...)
    private String operator;
    //Gia tri can search
    private Object value;

    public AccountSpecification(String field, String operator, Object value) {
        this.field = field;
        this.operator = operator;
        this.value = value;
    }

    @Override
    public Predicate toPredicate(Root<Account> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        if (operator.equalsIgnoreCase("LIKE")){
            if (field.equalsIgnoreCase("department.name")){
                return criteriaBuilder.like(root.get("department").get("name"), "%" + value.toString() + "%");
            }
            else {
                return criteriaBuilder.like(root.get(field), "%" + value.toString() + "%");
            }
        }
        return null;
    }
}
