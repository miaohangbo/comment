package com.example.annotation;

import java.lang.annotation.*;

/**
* @ClassName: Guest 
* @Description: 游客标识
* @author guokp
* @date 2017年3月20日 上午9:30:17
*/
@Target(value = {ElementType.TYPE, ElementType.METHOD})
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
public @interface Guest {

}
