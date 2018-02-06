package com.baizhi.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * @author 李老湿
 * @date 2017年8月14日
 */

//指定该注解作用在方法上
@Target(ElementType.METHOD)
//指定生命时长
@Retention(RetentionPolicy.RUNTIME)
public @interface Detail {
	String value();
}
