package com.example.annotation;

import java.lang.annotation.*;

/**
* @ClassName: Login 
* @Description: 需要登录的切面
* @author guokp
* @date 2017年3月20日 上午9:30:17
*/
@Target(value = {ElementType.TYPE, ElementType.METHOD})
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
public @interface Login {

}
