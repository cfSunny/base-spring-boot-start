package cn.pres.cf;

import cn.pres.cf.entity.ExceptionResultEntity;
import cn.pres.cf.enums.ResultCodeEnum;
import cn.pres.cf.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Dora
 * @date 2019/10/22 19:26
 **/
@ResponseBody
@ControllerAdvice
@Slf4j
public class WebExceptionHandler {

    @ExceptionHandler({Exception.class})
    public ExceptionResultEntity handler(HttpServletRequest request,Exception e){

        if(e instanceof BusinessException){
            // 返回异常信息
            ExceptionResultEntity resultVO=new ExceptionResultEntity();
            resultVO.setCode(((BusinessException) e).getCode());
            resultVO.setUrl(request.getRequestURI());
            resultVO.setMessage(e.getMessage());
            return resultVO;
        }else{
            e.printStackTrace();
        }
        return ExceptionResultEntity.error(ResultCodeEnum.UNDEFINE.getCode(),ResultCodeEnum.UNDEFINE.getMessage(),request.getRequestURI());
    }

}