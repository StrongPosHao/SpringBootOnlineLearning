package com.example.eduservice.controller;


import com.example.eduservice.entity.EduTeacher;
import com.example.eduservice.service.EduTeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author HaoZhang
 * @since 2020-09-03
 */
@Api(tags = "讲师管理")
@RestController
@RequestMapping("/eduservice/teacher")
public class EduTeacherController {

    // 1 查询讲师表中所有数据
    // rest风格
    @Autowired
    private EduTeacherService teacherService;

    @ApiOperation(value = "所有讲师列表")
    @GetMapping("findAll")
    public List<EduTeacher> findAllTeacher() {
        return teacherService.list(null);
    }

    // 2.逻辑删除讲师的方法
    @ApiOperation(value = "逻辑删除讲师")
    @DeleteMapping("{id}")
    public boolean removeTeacher(@ApiParam(name = "id", value = "讲师ID", required = true) @PathVariable String id) {
        return teacherService.removeById(id);
    }

}

