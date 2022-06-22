package com.xhu.mapper;

import com.xhu.entity.Course;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseMapper {
    //添加考试安排
    Integer updateExam(Course course);
    //根据学生id查询考试安排
    List<Course> selectExamByStudentId(String studentId,Integer page,Integer limit);
    //根据教师id查询考试安排
    List<Course> selectExamByTeacherId(String teacherId,Integer page,Integer limit);
    //根据课程名查询
    List<Course> selectExamByName(String courseName,Integer page,Integer limit);
    Integer totalSizeByName(@Param("courseName") String courseName);
    //根据学生id查询记录总条数
    Integer totalSizeByStudentId(@Param("studentId") String studentId);
    //根据教师id查询记录总条数
    Integer totalSizeByTeacherId(@Param("teacherId") String teacherId);
    //查询所有
    List<Course> selectAllExam(Integer page,Integer limit);
    Integer totalSize();
}
