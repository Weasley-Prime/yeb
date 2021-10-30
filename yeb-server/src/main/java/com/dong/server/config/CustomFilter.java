package com.dong.server.config;

import com.dong.server.entity.TMenu;
import com.dong.server.entity.TRole;
import com.dong.server.service.ITMenuService;
import org.apache.catalina.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.List;
import java.lang.Integer;

/**
 * <p>
 * 根据请求url分析请求所需的角色
 * </p>
 *
 * @author wangzedong
 * @since 2021/10/26
 */
@Component
public class CustomFilter implements FilterInvocationSecurityMetadataSource {
    @Autowired
    private ITMenuService service;
    AntPathMatcher antPathMatcher = new AntPathMatcher();
    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        String requestUrl = ((FilterInvocation) o).getRequestUrl();
        List<TMenu> menus = service.getMenuByRole();
        for (TMenu menu : menus) {
           if(antPathMatcher.match(menu.getUrl(),requestUrl)){
               String[] str = menu.getRoles().stream().map(TRole::getName).toArray(String[]::new);
               return null;
           }
        }
        return null;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }
}
