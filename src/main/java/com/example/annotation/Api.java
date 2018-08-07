package com.example.annotation;

import java.lang.annotation.*;

/**
* @ClassName: Api 
* @Description: 接口aop，controller 类中方法加了此注解的话则说明该方法是接口类型
* @author guokp
* @date 2017年3月20日 上午9:27:19 
*/

@Target(value = {ElementType.TYPE, ElementType.METHOD})
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
public @interface Api {

}
