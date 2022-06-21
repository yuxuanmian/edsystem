package com.xhu.controller;

import com.edsystem.pojo.vo.QueryVo;
import com.edsystem.result.QueryResult;
import com.edsystem.service.TeacherCourseService;
import com.edsystem.utils.JsonUtils;
import com.edsystem.utils.ResultUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

//TODO:
@RestController
@RequestMapping("/teacher")
public class TeacherCourseController {
    @Autowired
    private TeacherCourseService teacherCourseService;
    @RequestMapping("/queryAll")
    public String query(String teacherId,QueryVo queryVo) throws JsonProcessingException {
        try {
            Map map = new HashMap();
            map.put("teacherId",teacherId);
            map.put("page", queryVo.getStartIndex());
            map.put("size", queryVo.getLimit());
            QueryResult queryResult = teacherCourseService.query(map);
            //构建返回成功结果
            return JsonUtils.writerValueAsString(ResultUtils.buildSuccess(queryResult.getList(), queryResult.getCount()));
        } catch (Exception e) {
            //构建失败返回结果
            return JsonUtils.writerValueAsString(ResultUtils.buildFail(5000, "查询失败"));
        }
    }

    //查询选课学生
    @RequestMapping("/queryCheckStudent")
    public String queryCheckStudent(String teacherId, String courseId, QueryVo queryVo){
        QueryResult studentList = teacherCourseService.queryCheckStudent(teacherId, courseId, queryVo.getStartIndex(), queryVo.getLimit());
        return JsonUtils.writerValueAsString(ResultUtils.buildSuccess(studentList.getList(),studentList.getCount()));

    }
}
