package com.xhu.controller;

import com.edsystem.pojo.StudentCourse;
import com.edsystem.service.SCourseService;
import com.edsystem.utils.CountUtils;
import com.edsystem.utils.JsonUtils2;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//TODO:
@Controller
@RequestMapping("/StudentCourse")
public class SCourseController {

    @Autowired
    private SCourseService sCourseService;

    @RequestMapping("/findStudentCourseList")
    @ResponseBody
    public CountUtils findStudentCourseList(Integer page, Integer limit){
        return sCourseService.findStudentCourseList(page,limit);
    }

    @RequestMapping("/countStudentCourseTotalSize")
    @ResponseBody
    public Integer countStudentCourseTotalSize(){
        return sCourseService.countStudentCourseTotalSize();

    }

    @RequestMapping("/addStudentCourse")
    @ResponseBody
    public JsonUtils2 addStudentCourse(StudentCourse studentCourse){
        return sCourseService.addStudentCourse(studentCourse);

    }


 /*   @RequestMapping("/selectByStudentID")
    @ResponseBody
    public JsonResult selectByStudentID(@Param("studentId")String studentId,Integer param1, Integer param2){
        return studentCourseService.selectByStudentID(studentId,param1,param2);

    }*/

    @RequestMapping("/selectBycouseID")
    @ResponseBody
    public JsonUtils2 selectBycouseID(String courseId){
        return sCourseService.selectBycouseID(courseId);

    }

    @RequestMapping("/selectByID")
    @ResponseBody
    public JsonUtils2 selectByID(Integer Id){
        return sCourseService.selectByID(Id);

    }

    @RequestMapping("/updateByID")
    @ResponseBody
    public JsonUtils2 updateByID(@RequestBody StudentCourse studentCourse){
        return sCourseService.updateByID(studentCourse);

    }

    @RequestMapping("/deleteByID")
    @ResponseBody
    public JsonUtils2 deleteByID(Integer id){
        System.out.println(id);
        return sCourseService.deleteByID(id);

    }
    @RequestMapping("/findStudentCourseByStudentList")
    @ResponseBody
    public CountUtils findStudentCourseByStudentList(@Param("studentId")String studentId, Integer page, Integer limit){
        System.out.println(studentId);
        return sCourseService.findStudentCourseByStudentList(studentId,page,limit);

    }

    @RequestMapping("/findStudentCourseByTeacherList")
    @ResponseBody
    public CountUtils findStudentCourseByTeacherList(@Param("teacherId")String teacherId, Integer page, Integer limit){
        System.out.println(teacherId+page+limit);

        return sCourseService.findStudentCourseByTeacherList(teacherId,page,limit);

    }
    @RequestMapping("/glyselect")
    @ResponseBody
    public CountUtils glyselect(@Param("studentId")String studentId, @Param("teacherId")String teacherId, @Param("courseId")String courseId, Integer page, Integer limit){
        System.out.println(studentId+" "+teacherId+" "+courseId+" "+page+" "+limit+" ");
        return sCourseService.glyselect(studentId,teacherId,courseId,page,limit);

    }

    @RequestMapping("/lsselect")
    @ResponseBody
    public CountUtils lsselect(@Param("studentId")String studentId, @Param("courseId")String courseId, Integer page, Integer limit){
        System.out.println(studentId+" "+courseId+" "+page+" "+limit+" ");
        return sCourseService.lsselect(studentId,courseId,page,limit);

    }

    @RequestMapping("/xsselect")
    @ResponseBody
    public CountUtils xsselect(@Param("courseId")String courseId, Integer page, Integer limit){

        return sCourseService.xsselect(courseId,page,limit);

    }

}
