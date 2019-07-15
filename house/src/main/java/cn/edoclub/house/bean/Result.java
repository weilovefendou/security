package cn.edoclub.house.bean;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

@Slf4j
@Data
public class Result<T> implements Serializable {

    private static final long serialVersionUID = -4745703790022338793L;
    private boolean rlt;//操作 是否成功
    private String message;//返回消息
    private String code;//状态码
    private T data;//返回附加信息 可以是String、List、JSON、Map 类型
    public static final String SUCCESS = "1";
    public static final String FAIL = "0";

    public interface Command<D> {
        D execute();
    }

    public interface CommandVoid {
        void execute();
    }

    public static <D> Result<D> build(Command<D> cmd) {
        Result<D> result = new Result<>();
            D data = cmd.execute();
            result.setRlt(true);
            result.setMessage("操作成功！");
            result.setCode(SUCCESS);
            result.setData(data);
            log.debug("执行结果:{}", result);

        return result;
    }

    public static Result build(CommandVoid cmdVoid) {
        Result result = new Result();
            cmdVoid.execute();
            result.setRlt(true);
            result.setMessage("操作成功！");
            result.setCode(SUCCESS);

        return result;
    }


}
