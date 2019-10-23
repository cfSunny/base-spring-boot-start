package cn.pres.cf.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Dora
 * @date 2019/10/15 10:32
 **/
@Data
public class ExceptionResultEntity implements Serializable {
    private Integer code;

    private String message;

    private String url;

    public static ExceptionResultEntity error(int code, String message, String url) {
        ExceptionResultEntity resultVO=new ExceptionResultEntity();
        resultVO.setCode(code);
        resultVO.setMessage(message);
        resultVO.setUrl(url);
        return  resultVO;
    }
}
