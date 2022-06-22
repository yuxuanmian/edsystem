package com.xhu.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xhu.entity.StudentCourse;
import com.xhu.entity.vo.SCourse;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

@Repository
public interface SCourseMapper {
    //分页显示
    IPage<SCourse> findStudentCourseList(@Param("map") Map<String,String> map, IPage<SCourse> iPage);

    //添加成绩
    Integer addStudentCourse(StudentCourse studentCourse);

    //根据学号查询成绩
    List<StudentCourse> selectByStudentID(@Param("studentId")String studentId, Integer param1, Integer param2);

    Integer countByStudentID(@Param("studentId")String studentId);
    //根据学号查询成绩
    StudentCourse selectBycouseID(String courseId);

    StudentCourse selectByID(Integer id);

    Integer updateByID(StudentCourse studentCourse);

    Integer deleteByID(Integer id);

    List<StudentCourse> findStudentCourseByStudentList(@Param("studentId")String studentId, Integer page, Integer limit);

    Integer countStudentCourseByStudentTotalSize(@Param("studentId")String studentId);

    List<StudentCourse> findStudentCourseByTeacherList(@Param("teacherId")String teacherId, Integer page, Integer limit);

    Integer countStudentCourseByTeacherTotalSize(@Param("teacherId")String teacherId);

    /*管理员查询*/
    List<StudentCourse> glyselect(@Param("studentId")String studentId,@Param("teacherId")String teacherId,@Param("courseId")String courseId, @Param("page") Integer page, @Param("limit") Integer limit);

    Integer countglyselect(@Param("studentId")String studentId,@Param("teacherId")String teacherId,@Param("courseId")String courseId);

    List<StudentCourse> lsselect(@Param("studentId")String studentId,@Param("courseId")String courseId, @Param("page") Integer page, @Param("limit") Integer limit);

    Integer countlsselect(@Param("studentId")String studentId,@Param("courseId")String courseId);

    List<StudentCourse> xsselect(@Param("courseId")String courseId,@Param("page") Integer page, @Param("limit") Integer limit);

    Integer countxsselect(@Param("courseId")String courseId);


}
