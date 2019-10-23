package cn.pres.cf;

import cn.pres.cf.entity.ExceptionResultEntity;
import cn.pres.cf.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Dora
 * @date 2019/10/22 19:26
 **/
@ResponseBody
@ControllerAdvice
@Slf4j
public class WebExceptionHandler {

    @ExceptionHandler({Exception.class})
    public ExceptionResultEntity handler(Exception e){

        if(e instanceof BusinessException){
            // 返回异常信息
            ExceptionResultEntity resultVO=new ExceptionResultEntity();
            resultVO.setCode(((BusinessException) e).getCode());

            resultVO.setMessage(e.getMessage());
            // 把这边改了
            return resultVO;
        }else{
            e.printStackTrace();
        }
        return ExceptionResultEntity.error(5000,"未知异常","ces");
    }

}