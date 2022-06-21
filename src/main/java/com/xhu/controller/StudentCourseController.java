package com.xhu.controller;

import com.edsystem.pojo.StudentCourse;
import com.edsystem.pojo.vo.QueryVo;
import com.edsystem.result.QueryResult;
import com.edsystem.service.StudentCourseService;
import com.edsystem.utils.JsonUtils;
import com.edsystem.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

//TODO:
@RestController
@RequestMapping("/student")
public class StudentCourseController {
    @Autowired
    private StudentCourseService studentCourseService;

    @RequestMapping("/queryAll")
    public String query(String studentId,String courseId, String courseName, String teacherName, QueryVo queryVo) {
        try {
            Map map = new HashMap();
            map.put("studentId",studentId);
            map.put("courseId", courseId);
            map.put("courseName", courseName);
            map.put("teacherName", teacherName);
            map.put("page", queryVo.getStartIndex());
            map.put("size", queryVo.getLimit());
            QueryResult queryResult = studentCourseService.query(map);
            //构建返回成功结果
            return JsonUtils.writerValueAsString(ResultUtils.buildSuccess(queryResult.getList(), queryResult.getCount()));
        } catch (Exception e) {
            //构建失败返回结果
            return JsonUtils.writerValueAsString(ResultUtils.buildFail(5000, "查询失败"));
        }
    }

    @RequestMapping("/queryIsSelect")
    public String queryIsSelect(String studentId, QueryVo queryVo) {
        try {
            Map map = new HashMap();
            map.put("studentId",studentId);
            map.put("page", queryVo.getStartIndex());
            map.put("size", queryVo.getLimit());
            QueryResult queryResult = studentCourseService.queryIsSelect(map);
            //构建返回成功结果
            return JsonUtils.writerValueAsString(ResultUtils.buildSuccess(queryResult.getList(), queryResult.getCount()));
        } catch (Exception e) {
            //构建失败返回结果
            return JsonUtils.writerValueAsString(ResultUtils.buildFail(5000, "查询失败"));
        }
    }

    @RequestMapping("/queryNoSelect")
    public String queryNoSelect(String studentId, QueryVo queryVo) {
        try {
            //构建map
            Map map = new HashMap();
            map.put("studentId",studentId);
            map.put("page", queryVo.getStartIndex());
            map.put("size", queryVo.getLimit());
            QueryResult queryResult = studentCourseService.queryNoSelect(map);
            //构建返回成功结果
            return JsonUtils.writerValueAsString(ResultUtils.buildSuccess(queryResult.getList(), queryResult.getCount()));
        } catch (Exception e) {
            //构建失败返回结果
            return JsonUtils.writerValueAsString(ResultUtils.buildFail(5000, "查询失败"));
        }
    }

    @RequestMapping("/queryBySidAndCid")
    public String queryBySidAndCid(String studentId, String courseId,String teacherId) {
        try {
            StudentCourse studentCourse = studentCourseService.queryBySidAndCid(studentId, courseId,teacherId);
            return JsonUtils.writerValueAsString(ResultUtils.buildSuccess(studentCourse));
        } catch (Exception e) {
            return JsonUtils.writerValueAsString(ResultUtils.buildFail(5000, "查询失败"));
        }
    }

    @RequestMapping("/selectStudentCourse")
    public String selectStudentCourse(StudentCourse studentCourse,String lessonTime){
        System.out.println(studentCourse.toString());
        try {
             if(studentCourseService.selectStudentCourse(lessonTime,studentCourse)==0){
                 return JsonUtils.writerValueAsString(ResultUtils.buildFail(3000, "课程冲突！"));
             }else {
                 return JsonUtils.writerValueAsString(ResultUtils.buildSuccess());
             }
        } catch (Exception e) {
            return JsonUtils.writerValueAsString(ResultUtils.buildFail(5000, "系统繁忙"));
        }
    }

    @RequestMapping("/deleteStudentCourse")
    public String deleteStudentCourse(StudentCourse studentCourse){
        try {
            if (studentCourseService.deleteStudentCourse(studentCourse) == 0) {
                return JsonUtils.writerValueAsString(ResultUtils.buildFail(3000, "违法访问！"));
            } else {
                return JsonUtils.writerValueAsString(ResultUtils.buildSuccess());
            }
        }catch (Exception e){
            return JsonUtils.writerValueAsString(ResultUtils.buildFail(3000, "系统繁忙"));
        }
    }


}
