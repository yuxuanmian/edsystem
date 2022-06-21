package com.xhu.mapper;

import com.edsystem.pojo.StudentCourse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SCourseMapper {


    //计算总页数
    Integer countStudentCourseTotalSize();


    //分页显示
    List<StudentCourse> findStudentCourseList(Integer param1, Integer param2);

    //添加成绩
    Integer addStudentCourse(StudentCourse studentCourse);

    //根据学号查询成绩
    List<StudentCourse> selectByStudentID(@Param("studentId")String studentId,Integer param1, Integer param2);

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
