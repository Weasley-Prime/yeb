package com.dong.server.config;

import com.dong.server.dto.CommonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

/**
 * <p>
 * 全局异常处理
 * </p>
 *
 * @author wangzedong
 * @since 2021/10/27
 */
@RestControllerAdvice
public class GlobalException {
    @ExceptionHandler(SQLException.class)
    public CommonResult mySqlException(SQLException e){
        if(e instanceof SQLIntegrityConstraintViolationException){
            return CommonResult.error("该数据有关联数据，操作失败");
        }
        return CommonResult.error("数据库异常，操作失败");
    }
}
