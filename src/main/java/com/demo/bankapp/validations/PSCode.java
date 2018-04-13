package com.demo.bankapp.validations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = PSCodeConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface PSCode {

    String value() default "PS";

    String message() default "PS Code Should Start with PS";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
