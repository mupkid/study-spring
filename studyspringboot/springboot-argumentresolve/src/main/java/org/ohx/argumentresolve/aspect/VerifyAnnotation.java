package org.ohx.argumentresolve.aspect;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER})
public @interface VerifyAnnotation {
    boolean needVerify() default true;
}
