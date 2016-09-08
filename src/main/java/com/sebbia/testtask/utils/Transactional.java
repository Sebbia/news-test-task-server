package com.sebbia.testtask.utils;


import com.sebbia.testtask.error.ApiException;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@org.springframework.transaction.annotation.Transactional(rollbackFor = {ApiException.class, RuntimeException.class})
public @interface Transactional {

}
