package cn.edoclub.house.aop;


import cn.edoclub.house.bean.Result;
import cn.edoclub.house.constant.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;


@RestControllerAdvice
@Slf4j
public class ControllerAdvice {


    @ExceptionHandler(value = BindException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public Result argsErrorHandler(BindException msg) {
        log.error(msg.getMessage());
        return getRestResult("参数校验错误：{paraName:"+msg.getBindingResult().getFieldError().getField()+";errorMsg:"+msg.getBindingResult().getFieldError().getDefaultMessage(),ResultCode.ARGS_FAIL_CODE);
    }


    @ExceptionHandler(value = ConstraintViolationException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public Result argsErrorHandler(ConstraintViolationException msg) {

        ConstraintViolation node = msg.getConstraintViolations().iterator().next();
        log.error(msg.getMessage());
        return getRestResult("参数校验错误：{paramName:"+node.getPropertyPath()+";errorMsg:"+node.getMessage(),ResultCode.ARGS_FAIL_CODE);
    }



    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public Result argsMissingExceptionHandler(MissingServletRequestParameterException msg) {
        log.error(msg.getMessage());
        return getRestResult("缺失参数:{paramName:"+ msg.getParameterName()+";paramType："+ msg.getParameterType(),ResultCode.ARGS_FAIL_CODE);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public Result methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException msg) {
        List<ObjectError> errors =msg.getBindingResult().getAllErrors();
        String error =errors.get(0).getDefaultMessage();
        log.error(msg.getMessage());
        return getRestResult("缺失参数:{paramName:"+ "paramType："+ error,ResultCode.ARGS_FAIL_CODE);
    }

    @ExceptionHandler(value = RuntimeException.class)
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    public Result runtimeExceptionHandler(RuntimeException msg) {
        String error = msg.getMessage();
        this.printError(msg);
        return getRestResult("系统错误："+error, ResultCode.FAIL_CODE);
    }



    public Result getRestResult(String msg,String code){
        Result rs = new Result();
       rs.setMessage(msg);
        rs.setRlt(false);
        return rs;
    }

    private void printError(Exception e){
        log.error("错误日志",e);
    }
}
