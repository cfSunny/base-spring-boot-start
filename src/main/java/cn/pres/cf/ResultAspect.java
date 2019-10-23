package cn.pres.cf;

import cn.pres.cf.entity.ResultEntity;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author Dora
 * @date 2019/10/22 19:26
 **/

@Aspect
@Component
@Slf4j
public class ResultAspect {
    @Pointcut("@within(org.springframework.web.bind.annotation.RestController) || @annotation(org.springframework.web.bind.annotation.RestController)")
    public void pointcut() {

    }

    @SneakyThrows
    @Around("pointcut()")
    public  Object around(ProceedingJoinPoint joinPoint){
        // 引入
        long startTime = System.currentTimeMillis();
        Object target = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        long timeDifference = endTime - startTime;
        // 接口响应 检测
        if(timeDifference>3000){
            if (log.isWarnEnabled()) {
                log.warn("Inefficient operation:{},时间为:{}",joinPoint,timeDifference);
            }
        }

        return ResultEntity.ok(target);
    }

    @After("pointcut()")
    public void after() {}

    @AfterThrowing(pointcut = "pointcut()", throwing = "ex")
    public void doAfter(JoinPoint joinPoint, Exception ex) {
        if (log.isWarnEnabled()) {
            log.warn("after throw :{},\t {}", joinPoint, ex.getLocalizedMessage());
        }
    }

}
