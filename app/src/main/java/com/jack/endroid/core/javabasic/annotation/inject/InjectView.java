package com.jack.endroid.core.javabasic.annotation.inject;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import androidx.annotation.IdRes;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface InjectView {
	// value 接收一个资源ID，因此给它加上 @IdRes 注解（自动语法检查）会更好
    @IdRes int value();
}
