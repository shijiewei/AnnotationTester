package com.jack.endroid.compiler;

import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Messager;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;

// 指定该注解处理程序仅处理 CustomizedAnnotation 注解（不处理诸如 @Override、@Nullable 等其他注解）
@SupportedAnnotationTypes("com.jack.endroid.core.javabasic.annotation.CustomizedAnnotation")
public class CustomizedProcessor extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        Messager messager = processingEnv.getMessager();
        messager.printMessage(Diagnostic.Kind.NOTE, "=========== 注解日志测试 ========== " + roundEnvironment.toString());
        // 打印日志
        // 做http请求
        // 任何事都可以
        return false;
    }
}
