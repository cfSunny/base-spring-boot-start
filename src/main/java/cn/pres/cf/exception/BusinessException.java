package cn.pres.cf.exception;

import lombok.Data;

/**
 * @author Dora
 * @date 2019/10/12 10:04
 **/
@Data
public class BusinessException extends RuntimeException {
     private  int code=453;

     private  String message;

    public BusinessException(String message,int code) {
        super(message);
        this.message = message;
        this.code=code;
    }

    public BusinessException(String message, Throwable cause, int code) {
        super(message, cause);
        this.message = cause.getMessage();
        this.code=code;
    }

    public BusinessException(String message) {
        super(message);
        this.message=message;
    }

}
