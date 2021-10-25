package com.dong.server.config;

import com.dong.server.dto.CommonResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * <p>
 * 当无权限时，自定返回结果
 * </p>
 *
 * @author wangzedong
 * @since 2021/10/12
 */
@Component
public class RestfulAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("application/json");
        PrintWriter out = httpServletResponse.getWriter();
        CommonResult commonResult = CommonResult.error("权限不足，请联系管理员");
        commonResult.setCode(403);
        out.write(new ObjectMapper().writeValueAsString(commonResult));
        out.flush();
        out.close();
    }
}
