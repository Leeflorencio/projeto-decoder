package com.ead.authuser.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UsernameConstraintImpl.class)
@Target({ElementType.METHOD, ElementType.FIELD}) // onde sera utilizado a anotacao (metodo e campo)
@Retention(RetentionPolicy.RUNTIME) //define a validacao em tempo de execucao
public @interface UsernameConstraint {

    //parametros default
    String message() default "Invalid username"; //mensagem de erro
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {}; //nivel do erro
}
