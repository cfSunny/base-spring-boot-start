package cn.pres.cf;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.Objects;

/**
 * @author Dora
 * @date 2019/10/25 16:05
 **/
public class SpringUtils implements ApplicationContextAware {
    public static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if(null==SpringUtils.applicationContext){
            SpringUtils.applicationContext=applicationContext;
        }
    }

    public static Object getBean(String name){
        return applicationContext.getBean(name);
    }

    public static  <T> T  getBean(Class<T> c){
        return applicationContext.getBean(c);
    }


}
