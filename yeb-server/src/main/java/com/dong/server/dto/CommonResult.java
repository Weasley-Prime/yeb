package com.dong.server.dto;

import lombok.Data;

/**
 * <p>
 *  公共返回类型
 * </p>
 *
 * @author wangzedong
 * @since 2021-10-11 23:09:24
 */
@Data
public class CommonResult {
    private long code;
    private String message;
    private Object object;

    public CommonResult(long code, String message, Object object) {
        this.code = code;
        this.message = message;
        this.object = object;
    }

    public CommonResult(long code, String message) {
        this.code = code;
        this.message = message;
    }

    public static CommonResult success(String message){
        return new CommonResult(200,message,null);
    }

    public static CommonResult success(String message, Object object){
        return new CommonResult(200,message,object);
    }

    public static CommonResult error(String message){
        return new CommonResult(500,message,null);
    }

    public static CommonResult error(String message, Object object){
        return new CommonResult(500,message,object);
    }
}
