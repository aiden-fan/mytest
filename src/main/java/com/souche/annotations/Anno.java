package com.souche;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/***
 *@author fanmiao
 *@date 2020/1/9 15:49 
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ElementType.FIELD,ElementType.TYPE,ElementType.METHOD})
public @interface annotations {

    String receiveItemCode() default "";
    String refundItemCode() default "";
}
