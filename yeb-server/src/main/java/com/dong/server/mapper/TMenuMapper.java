package com.dong.server.mapper;

import com.dong.server.entity.TMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wangzedong
 * @since 2021-10-11 23:09:24
 */
@Mapper
public interface TMenuMapper extends BaseMapper<TMenu> {
    List<TMenu> getMenuByAdminId(@Param("id") Integer id);

    List<TMenu> getMenuByRole();
}
