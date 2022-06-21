package com.xhu.controller;


import com.edsystem.pojo.Teacher;
import com.edsystem.result.JsonResult;
import com.edsystem.result.R;
import com.edsystem.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//TODO:
@Controller
@RequestMapping("/teacher")
public class SysTeacherController {
    @Autowired
    private TeacherService teacherService;


    @RequestMapping("/findAllList")
    @ResponseBody
    public JsonResult findAllList(Integer page,Integer limit){
        return teacherService.findAllList(page,limit);
    }

    @RequestMapping("/searchTeacher")
    @ResponseBody
    public R searchTeacher(String SearchId){

        System.out.println("==SearchId=="+SearchId);
        return teacherService.searchTeacher(SearchId);
    }
    @RequestMapping("/addTeacherjobsign")
    @ResponseBody
    public R addTeacherjobsign(String teacherId,String jobsign){
        System.out.println(teacherId+jobsign);
        return teacherService.addTeacherjobsign(teacherId,jobsign);
    }

    @RequestMapping("/addTeacherList")
    @ResponseBody
    public R addTeacherList(@RequestBody Teacher teacher){
        System.out.println("==controller=="+teacher);
        return teacherService.addTeacherList(teacher);
    }

    @RequestMapping("/deleteTeacherList")
    @ResponseBody
    public R deleteTeacherList(String teacherId){
        return teacherService.deleteTeacherList(teacherId);
    }
    @RequestMapping("/updateTeacherList")
    @ResponseBody
    public R updateTeacherList(@RequestBody Teacher teacher){


        System.out.println("Controller=:"+teacher);
        return teacherService.updateTeacherList(teacher);
    }
}
