package com.example.util.common;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationBeanNameGenerator;

/**
 * 防止三方库里bean重复
 * @author shihb    
 * @version 1.0  
 * @created 2017年8月4日 上午9:18:56
 */
public class AnnotationBeanExtNameGenerator extends AnnotationBeanNameGenerator {
    @Override
    public String generateBeanName(BeanDefinition definition, BeanDefinitionRegistry registry) {
        String beanName = super.generateBeanName(definition, registry);
        beanName = definition.getBeanClassName() + "$" + beanName;
        return beanName;
    }
}
