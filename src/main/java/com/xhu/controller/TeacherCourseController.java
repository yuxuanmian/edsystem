package com.xhu.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xhu.common.bo.SimplePage;
import com.xhu.entity.Student;
import com.xhu.entity.vo.TCourse;
import com.xhu.service.TeacherCourseService;
import com.xhu.utils.MapToPojoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/teacher")
public class TeacherCourseController extends BaseController {
    @Autowired
    private TeacherCourseService teacherCourseService;


    //teacher_id limit page
    @RequestMapping("/queryAll")
    public String query(@RequestBody Map<String, ?> jsonStr) {

        SimplePage simplePage = MapToPojoUtil.convert(SimplePage.class, jsonStr);
        String teacherId = jsonStr.get("teacherId").toString();
        Map<String, Object> map = new HashMap<>();
        map.put("teacherId", teacherId);

        IPage<TCourse> query = teacherCourseService.query(map, simplePage.getPage(), simplePage.getLimit());
        //构建返回成功结果
        return this.returnPages(query);

    }

    //查询选课学生
    //teacher_id course_id limit page
    @RequestMapping("/queryCheckStudent")
    public String queryCheckStudent(@RequestBody Map<String, ?> jsonStr) {
        SimplePage simplePage = MapToPojoUtil.convert(SimplePage.class, jsonStr);
        String teacherId = jsonStr.get("teacherId").toString();
        String courseId = jsonStr.get("courseId").toString();
        IPage<Student> iPage = teacherCourseService.queryCheckStudent(teacherId, courseId,
                simplePage.getPage(), simplePage.getLimit());

        return returnPages(iPage);

    }
}
