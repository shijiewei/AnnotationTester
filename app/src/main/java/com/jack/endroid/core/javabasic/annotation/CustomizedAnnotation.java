package com.jack.endroid.core.javabasic.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Target：限定了该注解可以使用的范围，不加时可以在任何地方使用。TYPE-可以使用在类上，METHOD-可以使用在方法上
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.SOURCE)
/**
 * 注解的定义：@interface
 * - Target/Retention：元注解，即用在注解上的注解。它们都定义在自定义注解 CustomizedAnnotation 上，所以是元注解。
 */
public @interface CustomizedAnnotation {
	/*
	 * "value" 是默认的名字，如果注解中仅含这一个元素，则使用时可以直接 CustomizedAnnotation(0) 这样写，
	 * 但如果改了别的名字，比如 "age"，则必须写成 CustomizedAnnotation(age = 0)。
	 * 如果注解中含有多个元素时，使用时就必须所有元素都写成"键值对"
	 */
    int value();
    // 这里设置了 default 默认值，使用时就可以不传参，否则必须传参
    String id() default "x";
}
