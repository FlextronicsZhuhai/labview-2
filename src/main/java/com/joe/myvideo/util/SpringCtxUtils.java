package com.joe.myvideo.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 获取spring容器
 * 当一个类实现了这个接口ApplicationContextAware之后，这个类就可以方便获得ApplicationContext中的�?有bean�?
 * 换句话说，这个类可以直接获取spring配置文件中所有有引用到的bean对象
 * 前提条件�?作为�?个普通的bean在spring的配置文件中进行注册 
 * 如： <bean id="springCtxUtils" class="cn.pconline.framework.base.util.SpringCtxUtils"/>
 */
public class SpringCtxUtils implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringCtxUtils.applicationContext = applicationContext;
    }


    public static <T> T getBean(Class<T> type) {
        try {
            return applicationContext.getBean(type);
        } catch (NoUniqueBeanDefinitionException e) {   //出现多个，
            String beanName = applicationContext.getBeanNamesForType(type)[0];
            return applicationContext.getBean(beanName, type);
        }
    }

    public static <T> T getBean(String beanName, Class<T> type) {
        return applicationContext.getBean(beanName, type);
    }
}

