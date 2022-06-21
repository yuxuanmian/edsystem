package com.xhu.service.impl;

import com.mysql.cj.QueryResult;
import com.xhu.mapper.ManagerCourseMapper;
import com.xhu.service.ManagerCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ManagerCourseServiceImpl implements ManagerCourseService {
    @Autowired
    private ManagerCourseMapper managerCourseMapper;

    public QueryResult queryAll(Map map) {
        List<TCourse> allCourseList = managerCourseMapper.query(map);
        for (int i = 0; i < allCourseList.size(); i++) {
            String teacherId=allCourseList.get(i).getTeacherId();
            String courseId=allCourseList.get(i).getCourseId();
            int checkCount = managerCourseMapper.queryCheckCount(courseId, teacherId);
            allCourseList.get(i).setCheckCount(checkCount);
        }
        int count = managerCourseMapper.queryConunt(map);
        QueryResult queryResult = new QueryResult();
        queryResult.setList(allCourseList);
        queryResult.setCount(count);
        return queryResult;
    }

    public StudentCourse queryBySidCidTid(StudentCourse studentCourse) {
        return managerCourseMapper.queryBySidCidTid(studentCourse);
    }

    @Override
    public Student queryStudentBySid(String studentId) {
        return managerCourseMapper.queryStudentBySid(studentId);
    }

    public int selectStudentCourse(String lessonTime, StudentCourse studentCourse) {
        List<String> lessonTimeList = managerCourseMapper.queryLessonTime(studentCourse);
        if(lessonTimeList.contains(lessonTime)){
            return 0;
        }else {
            return managerCourseMapper.addStudentCourse(studentCourse);
        }
    }

    public int deleteStudentCourse(StudentCourse studentCourse) {
        return managerCourseMapper.deleteStudentCourse(studentCourse);
    }


    public int addCourse(Course course) {
        return managerCourseMapper.addCourse(course);
    }

    public int addTeacherCourse(TeacherCourse teacherCourse) {
        //teacherCourse.setTeacherId(managerCourseMapper.queryByTeacherName(teacherName).getTeacherId());
        return managerCourseMapper.addTeacherCourse(teacherCourse);
    }

    @Override
    public QueryResult queryCourse(Map map) {
        QueryResult queryResult = new QueryResult();
        queryResult.setList(managerCourseMapper.queryCourse(map));
        queryResult.setCount(managerCourseMapper.queryCourseCount(map));
        return queryResult;
    }

    @Override
    public String getMaxCid() {
        return managerCourseMapper.getMaxCid();
    }

    @Override
    public List<Teacher> queryNoTeachByCid(String courseId) {
        return managerCourseMapper.queryNoTeachByCid(courseId);
    }


}
