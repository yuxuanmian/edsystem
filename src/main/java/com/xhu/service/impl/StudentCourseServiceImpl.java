package com.xhu.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xhu.common.bo.SimplePage;
import com.xhu.common.ex.CustomRuntimeException;
import com.xhu.entity.StudentCourse;
import com.xhu.entity.Teacher;
import com.xhu.entity.vo.TCourse;
import com.xhu.mapper.StudentCourseMapper;
import com.xhu.service.StudentCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service

public class StudentCourseServiceImpl implements StudentCourseService {

    @Autowired
    private StudentCourseMapper studentCourseMapper;

    @Override
    public IPage<TCourse> query(Map<String, Object> map, SimplePage page) {
        IPage<TCourse> iPage = studentCourseMapper.query(map, new Page<>(page.getPage(), page.getLimit()));
        List<TCourse> tCourseList = iPage.getRecords();

        //判断课程是否已选
        String studentId = (String) map.get("studentId");
        for (TCourse tCourse : tCourseList) {
            String courseId = tCourse.getCourseId();
            String teacherId = tCourse.getTeacherId();
            StudentCourse studentCourse = studentCourseMapper.queryBySidAndCid(studentId, courseId, teacherId);
            if (studentCourse != null) {
                tCourse.setCheck(true);
            }
        }

        iPage.setRecords(tCourseList);
        return iPage;
    }

    @Override
    public IPage<TCourse> queryIsSelect(Map<String, Object> map, SimplePage page) {

        IPage<TCourse> iPageQu = new Page<>(page.getPage(), page.getLimit());

        return studentCourseMapper.queryIsSelect(map, iPageQu);
    }

    @Override
    public IPage<TCourse> queryNoSelect(Map<String, Object> map, SimplePage page) {

        IPage<TCourse> iPage = studentCourseMapper.query(map, new Page<>(page.getPage(), page.getLimit()));
        List<TCourse> tCourseList = iPage.getRecords();
        //判断课程是否已选
        String studentId = (String) map.get("studentId");
       for (int i = 0; i < tCourseList.size(); i++) {
            String courseId = tCourseList.get(i).getCourseId();
            String teacherId = tCourseList.get(i).getTeacherId();
            StudentCourse studentCourse = studentCourseMapper.queryBySidAndCid(studentId, courseId, teacherId);
            if (studentCourse != null) {
                tCourseList.remove(i);
                i--;
            }
        }

        iPage.setRecords(tCourseList);
        return iPage;
    }

    @Override
    public Teacher queryByTeacherName(String teacherName) {
        return studentCourseMapper.queryByTeacherName(teacherName);
    }

    @Override
    public StudentCourse queryBySidAndCid(String studentId, String courseId, String teacherId) {
        return studentCourseMapper.queryBySidAndCid(studentId, courseId, teacherId);
    }

    @Override
    public void selectStudentCourse(String lessonTime, StudentCourse studentCourse) {
        List<String> lessonTimeList = studentCourseMapper.queryLessonTime(studentCourse);
        if (lessonTimeList.contains(lessonTime)) {
            throw new CustomRuntimeException("课程冲突", 3000);
        }
        studentCourseMapper.addStudentCourse(studentCourse);
    }

    @Override
    public void deleteStudentCourse(StudentCourse studentCourse) {
        int res = studentCourseMapper.deleteStudentCourse(studentCourse);
        if (res == 0) {
            throw new CustomRuntimeException("违法访问", 3000);
        }
    }
}
