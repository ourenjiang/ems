package org.example;

/*
 *  我们主要从使用场景出发，对注解有一个大致认识
 * */

import jakarta.validation.*;
import org.example.learn.annotation.usagescenarios.validation.User;

import java.util.Set;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Validator validator;
        try (ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory()) {
            validator = validatorFactory.getValidator();
        }

        User user = new User();
        user.setId(42L);
//        user.setName("a");
//        user.setEmail("kkk");

        Set<ConstraintViolation<User>> validate = validator.validate(user);
        if (!validate.isEmpty()) {
            validate.forEach(v ->
                    System.out.println(v.getPropertyPath() + ": " + v.getMessage())
            );

            throw new ConstraintViolationException("校验失败", validate);
        }
    }
}