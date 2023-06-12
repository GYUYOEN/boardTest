package com.company.board.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

import com.company.board.common.Types;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface DataSource {
	String value() default "";
	Types.DataSourceType type() default Types.DataSourceType.COMMON;
}