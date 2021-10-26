package com.dong.server.config;

import com.dong.server.entity.TAdmin;
import com.dong.server.service.ITAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * <p>
 * Security配置类
 * </p>
 *
 * @author wangzedong
 * @since 2021/10/12
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private ITAdminService adminService;
    @Autowired
    private RestAuthorizationEntryPoint restAuthorizationEntryPoint;
    @Autowired
    private RestfulAccessDeniedHandler restfulAccessDeniedHandler;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
    }

    private PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public JwtAuthencationTokenFilter jwtAuthencationTokenFilter(){
        return new JwtAuthencationTokenFilter();
    }

    //不走拦截
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //使用jwt不需要csrf
        http.csrf()
                .disable()
                .sessionManagement()
                .sessionCreationPolicy((SessionCreationPolicy.STATELESS))
                .and()
                .authorizeRequests()
                .antMatchers(
                "/login"
                ,"/logout"
                ,"/doc.html"
                ,"/v2/api-docs/**"
                ,"/css/**"
                ,"/js/**"
                ,"/webjars/**"
                ,"/v2/api-docs",
                "/swagger-resources/**"
                        ,"/swagger-ui.html"
                        ,"/captcha"
        ).permitAll()

//                //除了上面都要认证
                .anyRequest()
                .authenticated()
                .and()
                .headers()
                .cacheControl()
                ;
//        添加jwt登录授权过滤器
        http.addFilterBefore(jwtAuthencationTokenFilter(), UsernamePasswordAuthenticationFilter.class);
//        //添加自定义未授权，未认证结果返回
        http.exceptionHandling()
                .accessDeniedHandler(restfulAccessDeniedHandler)
                .authenticationEntryPoint(restAuthorizationEntryPoint);

    }
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring().antMatchers(
//                "/login"
//                ,"/logout"
//                ,"/doc.html"
//                ,"/v2/api-docs/**"
//                ,"/css/**"
//                ,"/js/**"
//                ,"/webjars/**"
//                ,"/v2/api-docs",
//                "/swagger-resources/**",
//                "/swagger-ui.html"
//        );
//}
//
    @Override
    @Bean
    public UserDetailsService userDetailsService(){
        return username->{
            TAdmin admin = adminService.getAdminByUserName(username);
            if(admin != null){
                return admin;
            }
            return null;
        };
    }
}
