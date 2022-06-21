package com.xhu.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xhu.entity.Student;
import com.xhu.entity.vo.TCourse;
import com.xhu.mapper.TeacherCourseMapper;
import com.xhu.service.TeacherCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TeacherCourseServiceImpl implements TeacherCourseService {
    @Autowired
    private TeacherCourseMapper teacherCourseMapper;

    @Override
    public IPage<TCourse> query(Map<String, Object> map, int page, int limit) {
        IPage<TCourse> iPage = teacherCourseMapper.query(map, new Page<>(page,limit));
        List<TCourse> allCourseList = iPage.getRecords();

        allCourseList.forEach(tCourse -> {
            String teacherId = tCourse.getTeacherId();
            String courseId = tCourse.getCourseId();
            int checkCount = teacherCourseMapper.queryCheckCount(courseId, teacherId);
            tCourse.setCheckCount(checkCount);
        });

        return iPage;
    }

    @Override
    public IPage<Student> queryCheckStudent(String teacherId, String courseId, int page, int size) {
        IPage<Student> iPage = new Page<>(page, size);
        iPage = teacherCourseMapper.queryCheckStudent(teacherId, courseId, iPage);
        return iPage;
    }
}
