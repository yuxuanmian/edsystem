package com.xhu.service.impl;

import com.edsystem.mapper.StudentCourseMapper;
import com.edsystem.pojo.StudentCourse;
import com.edsystem.pojo.Teacher;
import com.edsystem.pojo.vo.TCourse;
import com.edsystem.result.QueryResult;
import com.edsystem.service.StudentCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service

public class StudentCourseServiceImpl implements StudentCourseService {
    @Autowired
    private StudentCourseMapper studentCourseMapper;

    public QueryResult query(Map map) {
        QueryResult queryResult = new QueryResult();
        List<TCourse> tCourseList = studentCourseMapper.query(map);

        //判断课程是否已选
        String studentId=(String)map.get("studentId");
        for (int i = 0; i < tCourseList.size(); i++) {
            String courseId= tCourseList.get(i).getCourseId();
            String teacherId= tCourseList.get(i).getTeacherId();
            StudentCourse studentCourse = studentCourseMapper.queryBySidAndCid(studentId, courseId,teacherId);
            if (studentCourse!=null){
                tCourseList.get(i).setCheck(true);
            }
        }

        queryResult.setList(tCourseList);
        queryResult.setCount(studentCourseMapper.queryConunt(map));


        return queryResult;
    }

    public QueryResult queryIsSelect(Map map) {
        QueryResult queryResult = new QueryResult();
        List<TCourse> tCourseList = studentCourseMapper.queryIsSelect(map);
        queryResult.setList(tCourseList);
        queryResult.setCount(studentCourseMapper.queryIsSelectConunt(map));
        return queryResult;
    }

    public QueryResult queryNoSelect(Map map) {
        QueryResult queryResult = new QueryResult();
        List<TCourse> tCourseList = studentCourseMapper.query(map);
        int queryConunt = studentCourseMapper.queryConunt(map);
        //判断课程是否已选
        String studentId=(String)map.get("studentId");
        for (int i = 0; i < tCourseList.size(); i++) {
            String courseId= tCourseList.get(i).getCourseId();
            String teacherId= tCourseList.get(i).getTeacherId();
            StudentCourse studentCourse = studentCourseMapper.queryBySidAndCid(studentId, courseId,teacherId);
            if (studentCourse!=null){
                tCourseList.remove(i);
                queryConunt--;
            }
        }
        queryResult.setList(tCourseList);
        queryResult.setCount(queryConunt);
        return queryResult;
    }

    public Teacher queryByTeacherName(String teacherName) {
        return studentCourseMapper.queryByTeacherName(teacherName);
    }

    public StudentCourse queryBySidAndCid(String studentId, String courseId,String teacherId) {
        return studentCourseMapper.queryBySidAndCid(studentId,courseId,teacherId);
    }

    public int selectStudentCourse(String lessonTime, StudentCourse studentCourse) {
        List<String> lessonTimeList = studentCourseMapper.queryLessonTime(studentCourse);
        if(lessonTimeList.contains(lessonTime)){
            return 0;
        }else {
            return studentCourseMapper.addStudentCourse(studentCourse);
        }
    }

    public int deleteStudentCourse(StudentCourse studentCourse) {
        return studentCourseMapper.deleteStudentCourse(studentCourse);
    }
}
