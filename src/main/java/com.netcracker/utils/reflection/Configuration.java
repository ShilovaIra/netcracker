package com.netcracker.utils.reflection;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Configuration {
    /**
     *  Field contain array of packages which have paths to classes which can be inject
     * @return array of packages
     */
    String[] packages();

}
