package com.xhu.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.edsystem.mapper.TeacherCourseMapper;
import com.edsystem.pojo.vo.TCourse;
import com.edsystem.result.QueryResult;
import com.edsystem.service.TeacherCourseService;
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
    public IPage<TCourse> query(Map<String,?> map) {
        IPage<TCourse> iPage = teacherCourseMapper.query(map);
        for (int i = 0; i < allCourseList.size(); i++) {
            String teacherId=allCourseList.get(i).getTeacherId();
            String courseId=allCourseList.get(i).getCourseId();
            int checkCount = teacherCourseMapper.queryCheckCount(courseId, teacherId);
            allCourseList.get(i).setCheckCount(checkCount);
        }
        queryResult.setList(allCourseList);
        queryResult.setCount(teacherCourseMapper.queryConunt(map));
        return iPage;
    }

    @Override
    public IPage<TCourse> queryCheckStudent(String teacherId, String courseId, int page, int size) {
        QueryResult queryResult = new QueryResult();
        queryResult.setList(teacherCourseMapper.queryCheckStudent(teacherId,courseId,page,size));
        queryResult.setCount(teacherCourseMapper.queryCheckStudentCount(teacherId,courseId));
        return queryResult;
    }
}
