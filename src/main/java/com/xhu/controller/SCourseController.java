package com.xhu.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xhu.common.ex.CustomRuntimeException;
import com.xhu.constant.ResultConstant;
import com.xhu.entity.StudentCourse;
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
public class SCourseController extends BaseController {

    @Autowired
    private SCourseService sCourseService;

    @RequestMapping("managerCherckAllStudetScore")
    public String managerCherckAllStudetScore(@RequestBody Map<String, String> map) {
        IPage<SCourse> studentCourseList = sCourseService.managerCherckAllStudetScore(map);
        return this.returnPages(studentCourseList);
    }

    @RequestMapping("/managerUpdateStudentScore")
    public String managerUpdateStudentScore(@RequestBody StudentCourse studentCourse) {
        if (sCourseService.managerUpdateStudentScore(studentCourse)) {
            return this.returnSuccessWithNoData("修改成功");
        } else {
            throw new CustomRuntimeException("系统繁忙", ResultConstant.FAILED);
        }
    }

    @RequestMapping("queryAllTeacher")
    public String queryTeacher(){
        return this.returnSuccessWithData("查询成功",sCourseService.queryAllTeacher());
    }

    @RequestMapping("queryAllCourse")
    public String queryAllCourse(){
        return this.returnSuccessWithData("查询成功",sCourseService.queryAllCourse());
    }

    @RequestMapping("teacherCherckAllStudetScore")
    public String teacherCherckAllStudetScore(@RequestBody Map<String, String> map) {
        IPage<SCourse> studentCourseList = sCourseService.teacherCherckAllStudetScore(map);
        return this.returnPages(studentCourseList);
    }

    @RequestMapping("/queryMyCourse")
    public String queryMyCourse(@RequestBody Map<String,String> map){
        String teacherId=map.get("teacherId");
        return this.returnSuccessWithData("查询成功",sCourseService.queryMyCourse(teacherId));
    }

    @RequestMapping("teacherAddStduentScore")
    public String teacherAddStduentScore(@RequestBody StudentCourse studentCourse) {
        if (sCourseService.teacherAddStduentScore(studentCourse)) {
            return this.returnSuccessWithNoData("修改成功");
        } else {
            throw new CustomRuntimeException("系统繁忙", ResultConstant.FAILED);
        }
    }

    @RequestMapping("/studentCheckMyScore")
    public String studentCheckMyScore(@RequestBody Map<String, String> map) {
        return this.returnPages(sCourseService.studentCheckMyScore(map));
    }
}
