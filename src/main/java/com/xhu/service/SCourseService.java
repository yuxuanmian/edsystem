package com.xhu.service;
import com.xhu.common.vo.ResultVo;
import com.xhu.entity.StudentCourse;

public interface SCourseService {

    /**
     * 查询课程总记录数
     * @return
     */
    Integer countStudentCourseTotalSize();

    /**
     *
     * @param page
     * @param limit
     * @return
     */
    ResultVo<?> findStudentCourseList(Integer page, Integer limit);

    //添加学生成绩
    ResultVo<?> addStudentCourse(StudentCourse studentCourse);


    /*根据课程查询选课学生成绩*/
    ResultVo<?> selectBycouseID(String courseId);

    /*根据序号Id查询学生成绩信息*/
    ResultVo<?> selectByID(Integer Id);

    /*根据序号修改学生成绩信息*/
    ResultVo<?> updateByID(StudentCourse studentCourse);

    /*根据Id删除学生信息 */
    ResultVo<?> deleteByID(Integer Id);

    ResultVo<?> findStudentCourseByStudentList(String studentId, Integer page, Integer limit);

    ResultVo<?> findStudentCourseByTeacherList(String teacherId, Integer page, Integer limit);


    ResultVo<?> glyselect(String studentId, String teacherId, String courseId, Integer page, Integer limit);

    ResultVo<?> lsselect(String studentId, String courseId, Integer page, Integer limit);

    ResultVo<?> xsselect(String courseId, Integer page, Integer limit);



}
