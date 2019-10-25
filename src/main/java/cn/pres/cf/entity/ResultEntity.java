package cn.pres.cf.entity;

import cn.pres.cf.enums.ResultCodeEnum;
import com.google.gson.annotations.Until;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

/**
 * @author Dora
 * @date 2019/10/10 19:07
 **/
@Data
public class ResultEntity<T> implements Serializable {
    private Integer code;

    private String message;

    private T data;


    public static <T> ResultEntity<T> ok(T data){

        ResultEntity resultVO = new ResultEntity();
        resultVO.setData(data);
        if (Objects.isNull(data)) {
            resultVO.setData(new ArrayList<>());
        }
        resultVO.setCode(ResultCodeEnum.OK.getCode());
        resultVO.setMessage(ResultCodeEnum.OK.getMessage());
        return resultVO;
    }


    public static <T> ResultEntity<T> ok(ResultCodeEnum code, Object data){
        ResultEntity resultVO = new ResultEntity();
        resultVO.setData(data);
        if (Objects.isNull(data)) {
            resultVO.setData(new ArrayList<>());
        }
        resultVO.setCode(code.getCode());
        resultVO.setMessage(code.getMessage());
        return resultVO;
    }

    public static <T> ResultEntity<T> ok(ResultCodeEnum code, String message, Object data){
        ResultEntity resultVO = new ResultEntity();
        resultVO.setData(data);
        if (Objects.isNull(data)) {
            resultVO.setData(new ArrayList<>());
        }
        resultVO.setCode(code.getCode());
        resultVO.setMessage(message);
        return resultVO;
    }


    // 1.第一个版本 我只是想让我返回的时候是有一个固定的格式 √完成

    // 2.第二个版本  只想在RestController 中调用,返回的时候自动加上返回值 加入了日志监听 √

    // 3.第三个版本  我想在有异常的时候 把详细的异常信息返回给前端 √

    // 4.第四个版本  封装成starter √

    // 5.第五个版本  把docker放到
}
