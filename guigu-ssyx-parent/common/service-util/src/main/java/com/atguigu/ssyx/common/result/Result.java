package com.atguigu.ssyx.common.result;

import lombok.Data;

@Data
public class Result<T> {

    // status code
    private Integer code;
    // status message
    private String message;
    // data
    private T data;

    // constructor
    private Result() {}

    // result building function
    public static <T> Result<T> build(T data, ResultCodeEnum resultCodeEnum) {
        // create result object, set the value and return the object
        Result<T> result = new Result<>();

        // check if the data is needed in the result(like the CURD of DB, don't need data in result)
        if (data != null) {
            // set the data
            result.setData(data);
        }

        // set other values
        result.setMessage(resultCodeEnum.getMessage());
        result.setCode(resultCodeEnum.getCode());

        // return the object
        return result;
    }

    // success result building function
    public static <T> Result<T> ok(T data) {
        Result<T> result = build(data, ResultCodeEnum.SUCCESS);
        return result;
    }

    // fail result building function
    public static <T> Result<T> fail(T data) {
        Result<T> result = build(data, ResultCodeEnum.FAIL);
        return result;
    }
}
