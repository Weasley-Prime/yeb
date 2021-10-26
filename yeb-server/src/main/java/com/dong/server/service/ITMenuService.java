package com.dong.server.service;

import com.dong.server.entity.TMenu;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wangzedong
 * @since 2021-10-11 23:09:24
 */
public interface ITMenuService extends IService<TMenu> {

    List<TMenu> getMenuByAdminId();

    List<TMenu> getMenuByRole();
}
