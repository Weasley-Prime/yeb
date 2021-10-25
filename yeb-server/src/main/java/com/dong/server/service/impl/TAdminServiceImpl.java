package com.dong.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dong.server.config.JwtTokenUtil;
import com.dong.server.dto.CommonResult;
import com.dong.server.entity.AdminLoginParam;
import com.dong.server.entity.TAdmin;
import com.dong.server.mapper.TAdminMapper;
import com.dong.server.service.ITAdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.jsonwebtoken.Jwt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wangzedong
 * @since 2021-10-11 23:09:23
 */
@Service
public class TAdminServiceImpl extends ServiceImpl<TAdminMapper, TAdmin> implements ITAdminService {
    @Autowired
    private TAdminMapper mapper;
    @Autowired
    private UserDetailsService userDetailsService;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Override
    public TAdmin getAdminByUserName(String username) {
        return mapper.selectOne(new QueryWrapper<TAdmin>().eq("username",username).eq("enabled",true));
    }

    @Override
    public CommonResult login(String username, String password,String code, HttpServletRequest request) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        String captcha = (String) request.getSession().getAttribute("captcha");
        if(null == captcha || !captcha.equalsIgnoreCase(code)){
            return CommonResult.error("验证码错误");
        }
        if(null == userDetails || !passwordEncoder.matches(password,userDetails.getPassword())){
            return CommonResult.error("用户名或密码错误");
        }
        if(!userDetails.isEnabled()){
            return CommonResult.error("账号被禁用，请联系管理员。");
        }
        //更新security登录用户对象
        UsernamePasswordAuthenticationToken authenticationToken = new
                UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());

        String token = jwtTokenUtil.generateToken(userDetails);
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token",token);
        tokenMap.put("tokenHead",tokenHead);
        return CommonResult.success("登录成功",tokenMap);
    }
}
