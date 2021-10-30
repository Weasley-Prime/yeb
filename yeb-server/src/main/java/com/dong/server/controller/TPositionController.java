package com.dong.server.controller;


import com.baomidou.mybatisplus.extension.conditions.update.UpdateChainWrapper;
import com.dong.server.dto.CommonResult;
import com.dong.server.entity.TPosition;
import com.dong.server.service.ITPositionService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Wrapper;
import java.time.LocalDateTime;
import java.util.Arrays;
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
@RequestMapping("/t-position")
public class TPositionController {

    @Autowired
    private ITPositionService positionService;

    @ApiOperation(value = "获取所有职位信息")
    @GetMapping("/AllPosition")
    public List<TPosition> getAllPosition(){
        return positionService.list();
    }

    @ApiOperation(value = "添加职位信息")
    @PostMapping("/addPosition")
    public CommonResult addPosition(@RequestBody TPosition position){
        position.setCreateDate(LocalDateTime.now());
        if(positionService.save(position)){
            return CommonResult.success("添加成功");
        }
        return CommonResult.error("添加失败");
    }

    @ApiOperation(value = "更新职位信息")
    @PostMapping("/updatePosition")
    public CommonResult updatePosition(@RequestBody TPosition position){
        if(positionService.updateById(position)){
            return CommonResult.success("更新成功");
        }
        return CommonResult.error("更新失败");
    }

    @ApiOperation(value = "删除职位信息")
    @DeleteMapping("/deletePosition")
    public CommonResult deletePosition(Integer id){
        if(positionService.removeById(id)){
            return CommonResult.success("删除成功");
        }
        return CommonResult.error("删除失败");
    }

    @ApiOperation(value = "批量删除职位信息")
    @DeleteMapping("/deletePositions")
    public CommonResult deletePositions(Integer[] ids){
        if(positionService.removeByIds(Arrays.asList(ids))){
            return CommonResult.success("删除成功");
        }
        return CommonResult.error("删除失败");
    }
}
