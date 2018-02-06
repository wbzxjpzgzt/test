package com.baizhi.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//指定该注解的作用范围
@Target(ElementType.FIELD)
//指定声明时长  指定生命时长  CLASS:编译时有效  Source:写代码时有效  RUntime:运行有效
@Retention(RetentionPolicy.RUNTIME)
public @interface Comment {
	//定义一个属性
	String value();
}
