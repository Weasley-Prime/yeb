package com.dong.server.service.impl;

import com.dong.server.entity.RespBean;
import com.dong.server.entity.UmsAdmin;
import com.dong.server.mapper.UmsAdminMapper;
import com.dong.server.service.IUmsAdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 后台用户表 服务实现类
 * </p>
 *
 * @author wangzedong
 * @since 2021-10-10 22:33:59
 */
@Service
public class UmsAdminServiceImpl extends ServiceImpl<UmsAdminMapper, UmsAdmin> implements IUmsAdminService {

    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public RespBean login(String username, String password, HttpServletRequest httpServletRequest) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        if(null==userDetails||!passwordEncoder.matches(password,userDetails.getPassword())){
            return RespBean.error("用户密码不正确");
        }
        if(!userDetails.isEnabled()){
            return RespBean.error("账号被禁用");
        }
        return null;
    }
}
