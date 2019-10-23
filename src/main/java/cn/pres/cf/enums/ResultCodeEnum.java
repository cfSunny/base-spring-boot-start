package cn.pres.cf.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * @author Dora
 * @date 2019/10/10 16:05
 **/
@Getter
@AllArgsConstructor
public enum ResultCodeEnum {
    /**
     * 成功
     *
     * @author dora
     * @return
     * @date 2019/10/10
     **/
    OK(2000, "成功"),
    /**
     * 没有权限
     *
     * @author dora
     * @return
     * @date 2019/10/10
     **/
    UNAUTHORIZED(401, "用户没有权限"),
    /**
     * 未知异常
     * @author dora 
     * @return   
     * @date 2019/10/23
    **/
    UNDEFINE(5000,"未知异常");
    private Integer code;

    private String message;

    public static ResultCodeEnum getValue(Integer code) {
        return Arrays.asList(ResultCodeEnum.values())
                .stream()
                .filter(result -> result.code.equals(code))
                .findFirst().orElse(null);

    }
}
