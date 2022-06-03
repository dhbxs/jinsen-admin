package top.dhbxs.jinsen.admin.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 工具类
 * 从Spring容器中手动获得所需要的类和对象
 */
@Component // 通过注解将对象实例化到SpringBoot容器中
public class SpringContextUtil implements ApplicationContextAware {
    private SpringContextUtil() {
    }

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext){
        SpringContextUtil.applicationContext = applicationContext;
    }

    public static <T> T getBean(Class<T> clazz) {
        return applicationContext.getBean(clazz);
    }
}
