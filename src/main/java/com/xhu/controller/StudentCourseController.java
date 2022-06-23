package com.xhu.controller;

import com.xhu.common.bo.SimplePage;
import com.xhu.entity.StudentCourse;
import com.xhu.service.StudentCourseService;
import com.xhu.utils.MapToPojoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 学生课表管理
 */
@RestController
@RequestMapping("/student")
public class StudentCourseController extends BaseController {
    @Autowired
    private StudentCourseService studentCourseService;

    //studentId,courseId,courseName,teacherName,page,limit
    @RequestMapping("/queryAll")
    public String query(@RequestBody Map<String, Object> map) {

        SimplePage page = MapToPojoUtil.convert(SimplePage.class, map);
        return this.returnPages(studentCourseService.query(map, page));

    }

    //studentId,page,limit
    @RequestMapping("/queryIsSelect")
    public String queryIsSelect(@RequestBody Map<String, Object> map) {
        SimplePage page = MapToPojoUtil.convert(SimplePage.class, map);
        return this.returnPages(studentCourseService.queryIsSelect(map, page));
    }

    //studentId,page,limit
    @RequestMapping("/queryNoSelect")
    public String queryNoSelect(@RequestBody Map<String, Object> map) {
        SimplePage page = MapToPojoUtil.convert(SimplePage.class, map);
        return this.returnPages(studentCourseService.queryNoSelect(map, page));
    }

    //studentId courseId  teacherId
    @RequestMapping("/queryBySidAndCid")
    public String queryBySidAndCid(@RequestBody Map<String, String> map) {
        StudentCourse res = studentCourseService.queryBySidAndCid
                (map.get("studentId"), map.get("courseId"), map.get("teacherId"));
        return this.returnSuccessWithData("查询成功", res);
    }

    //studentId courseId  teacherId lessonTime
    @RequestMapping("/selectStudentCourse")
    public String selectStudentCourse(@RequestBody Map<String, Object> map) {
        StudentCourse studentCourse = MapToPojoUtil.convert(StudentCourse.class, map);
        String lessonTime = map.get("lessonTime").toString();
        studentCourseService.selectStudentCourse(lessonTime, studentCourse);
        return returnSuccessWithNoData("选课成功");
    }

    //studentId courseId  teacherId
    @RequestMapping("/deleteStudentCourse")
    public String deleteStudentCourse(@RequestBody Map<String, Object> map) {
        StudentCourse studentCourse = MapToPojoUtil.convert(StudentCourse.class, map);
        studentCourseService.deleteStudentCourse(studentCourse);
        return returnSuccessWithNoData("删除成功");
    }


}
