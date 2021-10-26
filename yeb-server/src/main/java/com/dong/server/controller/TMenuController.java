package com.dong.server.controller;


import com.dong.server.entity.TAdmin;
import com.dong.server.entity.TMenu;
import com.dong.server.service.ITMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wangzedong
 * @since 2021-10-11 23:09:24
 */
@RestController
@Api("菜单管理")
@RequestMapping("/t-menu")
public class TMenuController {
    private final ITMenuService service;

    public TMenuController(ITMenuService service) {
        this.service = service;
    }

    @ApiOperation(value="菜单管理")
    @GetMapping("/menus")
    public List<TMenu> getMenuByAdminId(
    ){
        return service.getMenuByAdminId();
    }

}
