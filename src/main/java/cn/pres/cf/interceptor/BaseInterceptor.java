package cn.pres.cf.interceptor;

import cn.pres.cf.SpringUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Objects;

/**
 * @author Dora
 * @date 2019/10/25 13:50
 **/
public class BaseInterceptor  implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod methodHandle = (HandlerMethod) handler;
        Authentication beanAnnotation =  methodHandle.getBeanType().getAnnotation(Authentication.class);
        Authentication methodAnnotation = methodHandle.getMethod().getAnnotation(Authentication.class);
        if (Objects.isNull(methodAnnotation) &&Objects.isNull(beanAnnotation)) {
            return true;
        }

        Authenticator authenticator = SpringUtils.getBean(Authenticator.class);
        if (!Objects.isNull(authenticator)) {
            authenticator.authenticate(request);
        }

        //执行权限接口
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }


}