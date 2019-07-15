package cn.edoclub.house.exception;

import lombok.Data;

@Data
public class BaseException extends RuntimeException {
    private static final long serialVersionUID = 01344600033756250371572L;
    private String code;
    public BaseException() {
    }
    public BaseException(String code, String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code = code;
    }
    public BaseException(String code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }
    public BaseException(String code, String message) {
        super(message);
        this.code = code;
    }
    public BaseException(String message) {
        super(message);
    }
    public BaseException(Throwable cause) {
        super(cause);
    }

}
