package com.souche.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/***
 *@author fanmiao
 *@date 2020/5/17 3:14 下午 
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ElementType.FIELD})
public @interface LagerThanZero {
    boolean value() default true;
}
