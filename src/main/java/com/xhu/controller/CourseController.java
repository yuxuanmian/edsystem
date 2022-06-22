package com.xhu.controller;

import com.alibaba.fastjson.JSON;
import com.xhu.common.vo.QueryPageWithTSCVo;
import com.xhu.common.vo.QueryVo;
import com.xhu.entity.Course;
import com.xhu.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//TODO:
@Controller
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;


    @RequestMapping("/updateExam")
    @ResponseBody
    public String updateExam(@RequestBody Course course){
        System.out.println(course);

        return JSON.toJSONString(courseService.updateExam(course));
    }

    @RequestMapping("/selectExamByStudentId")
    @ResponseBody
    /**
     * studentId,page,limit
     */
    public String selectExamByStudentId(@RequestBody QueryPageWithTSCVo queryPageWithTSCVo){
        return JSON.toJSONString(courseService.selectExamByStudentId(queryPageWithTSCVo));
    }

    @RequestMapping("/selectExamByTeacherId")
    @ResponseBody
    /**
     * teacherId,page,limit
     */
    public String selectExamByTeacherId(@RequestBody QueryPageWithTSCVo queryPageWithTSCVo){
        return JSON.toJSONString(courseService.selectExamByTeacherId(queryPageWithTSCVo));
    }

    @RequestMapping("/selectAllExam")
    @ResponseBody
    public String selctAllExam(@RequestBody QueryVo queryVo){
        return JSON.toJSONString(courseService.selectAllExam(queryVo));
    }

    @RequestMapping("/selectExamByName")
    @ResponseBody
    /**
     * courseName,page,limit
     */
    public String selectExamByName(@RequestBody QueryPageWithTSCVo queryPageWithTSCVo){
        return JSON.toJSONString(courseService.selectExamByName(queryPageWithTSCVo));
    }


}
