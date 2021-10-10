package com.dong.server.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 公共返回对象
 *
 * @author: wangzedong
 * @since: 1.0.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RespBean {
    private Long code;
    private String message;
    private Object object;

    /**
     * 成功返回结果
     * @param message
     * @return
     */
    public static RespBean success(String message){
        return new RespBean(200L,message,null);
    }

    /**
     * 成功返回结果
     * @param message
     * @return
     */
    public static RespBean success(String message,Object object){
        return new RespBean(200L,message,object);
    }

    /**
     * 失败返回结果
     * @param message
     * @return
     */
    public static RespBean error(String message){
        return new RespBean(500L,message,null);
    }

    /**
     * 失败返回结果
     * @param message
     * @return
     */
    public static RespBean error(String message,Object object){
        return new RespBean(500L,message,object);
    }
}
