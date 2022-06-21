package com.xhu.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xhu.common.vo.TCourse;
import com.xhu.entity.*;
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

    public IPage<TCourse> queryAll(Map map,IPage<TCourse> iPage) {
        IPage<TCourse> allCourseList = managerCourseMapper.query(map,iPage);
        for (int i = 0; i < allCourseList.getRecords().size(); i++) {
            String teacherId=allCourseList.getRecords().get(i).getTeacherId();
            String courseId=allCourseList.getRecords().get(i).getCourseId();
            int checkCount = managerCourseMapper.queryCheckCount(courseId, teacherId);
            allCourseList.getRecords().get(i).setCheckCount(checkCount);
        }
        int count = managerCourseMapper.queryConunt(map);
        return allCourseList;
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
    public IPage<Course> queryCourse(Map map,IPage<Course> iPage) {
        IPage<Course> courseIPage = managerCourseMapper.queryCourse(map,iPage);
        return courseIPage;
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
