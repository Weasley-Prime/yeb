package com.dong.server.controller;


import com.dong.server.dto.CommonResult;
import com.dong.server.entity.TJoblevel;
import com.dong.server.service.ITJoblevelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@Api(tags = "职称管理")
@RequestMapping("/t-joblevel")
public class TJoblevelController {

    @Autowired
    private ITJoblevelService service;

    @ApiOperation(value = "获取全部职称")
    @GetMapping("/getAllJoblever")
    public List<TJoblevel> getAllJoblever(){
        return service.list();
    }

    @ApiOperation(value = "增加职称")
    @PostMapping("/addJoblever")
    public CommonResult addJoblever(TJoblevel joblevel){
        joblevel.setCreateDate(LocalDateTime.now());
        if (service.save(joblevel)) {
            return CommonResult.success("添加成功");
        }
        else return CommonResult.error("添加失败");
    }

    @ApiOperation(value = "修改职称")
    @PostMapping("/updateJoblever")
    public CommonResult updateJoblever(TJoblevel joblevel){
        if (service.updateById(joblevel)) {
            return CommonResult.success("修改成功");
        }
        else return CommonResult.error("修改失败");
    }

    @ApiOperation(value = "删除职称")
    @DeleteMapping("/deleteJoblever")
    public CommonResult deleteJoblever(Integer id){
        if (service.removeById(id)) {
            return CommonResult.success("删除成功");
        }
        else return CommonResult.error("删除失败");
    }

    @ApiOperation(value = "批量删除职称")
    @DeleteMapping("/deleteJoblevers")
    public CommonResult deleteJoblevers(Integer[] id){
        if (service.removeByIds(Arrays.asList(id))) {
            return CommonResult.success("批量删除成功");
        }
        else return CommonResult.error("批量删除失败");
    }
}
