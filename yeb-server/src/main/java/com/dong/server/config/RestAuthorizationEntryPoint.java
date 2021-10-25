package com.dong.server.config;

import com.dong.server.dto.CommonResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * <p>
 * 当未登录，或token失效时访问接口时，自定义的返回接口
 * </p>
 *
 * @author wangzedong
 * @since 2021/10/12
 */
@Component
public class RestAuthorizationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("application/json");
        PrintWriter out = httpServletResponse.getWriter();
        CommonResult commonResult = CommonResult.error("未登录，请登录");
        commonResult.setCode(401);
        out.write(new ObjectMapper().writeValueAsString(commonResult));
        out.flush();
        out.close();
    }
}
