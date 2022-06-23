package com.xhu.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xhu.entity.StudentCourse;
import com.xhu.entity.Teacher;
import com.xhu.entity.vo.TCourse;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
public interface StudentCourseMapper {
    //查询全校课表
    IPage<TCourse> query(Map<String, ?> map, IPage<?> page);

    //查询全校课表总数
    int queryConunt(Map<String, ?> map);

    //通过courserID和studentId查询学生
    StudentCourse queryBySidAndCid(@Param("studentId") String studentId, @Param("courseId") String courseId, @Param("teacherId") String teacherId);

    //查询自己已选所有课
    IPage<TCourse> queryIsSelect(Map<String, ?> map, IPage<?> page);

    //查询总数
    int queryIsSelectConunt(Map<String, ?> map);

    //查询自己未选所有课
    IPage<TCourse> queryNoSelect(Map<String, ?> map, IPage<?> page);

    //查询总数
    int queryNoSelectCount(Map<String, ?> map);

    //通过老师名查询老师信息
    Teacher queryByTeacherName(String teacherName);

    //选课
    //查询自己所选所有课的时间
    List<String> queryLessonTime(@Param("studentCourse") StudentCourse studentCourse);

    //向学生课程表中添加记录
    int addStudentCourse(StudentCourse studentCourse);

    //退课
    int deleteStudentCourse(StudentCourse studentCourse);

}
