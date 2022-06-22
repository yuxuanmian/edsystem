package com.xhu.service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xhu.common.vo.ResultVo;
import com.xhu.entity.StudentCourse;
import com.xhu.entity.vo.SCourse;

import java.util.Map;

public interface SCourseService {

    /**
     *包含很多数据，
     * @return
     */
    IPage<SCourse> findStudentCourseList(Map<String,String> map);

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
