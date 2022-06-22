package com.xhu.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xhu.entity.vo.SCourse;
import com.xhu.service.SCourseService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

//TODO:
@RestController
@RequestMapping("/score")
public class SCourseController extends BaseController{

    @Autowired
    private SCourseService sCourseService;

    @RequestMapping("findStudentCourseList")
    public String findStudentCourseList(@RequestBody Map<String,String> map){
        IPage<SCourse> studentCourseList = sCourseService.findStudentCourseList(map);
        return this.returnPages(studentCourseList);
    }

}
