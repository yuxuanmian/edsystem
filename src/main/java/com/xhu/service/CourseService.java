package com.xhu.service;


import com.xhu.common.vo.QueryPageWithTSCVo;
import com.xhu.common.vo.QueryVo;
import com.xhu.common.vo.ResultVo;
import com.xhu.pojo.Course;

public interface CourseService {

    ResultVo<?> updateExam(Course course);

    /**
     * 通过学生id查询成绩
     * @param queryPageWithTSCVo 包含学生id，page，limit
     * @return
     */
    ResultVo<?> selectExamByStudentId(QueryPageWithTSCVo queryPageWithTSCVo);

    /**
     * 根据老师id查询
     * @param queryPageWithTSCVo 包含老师id，page，limit
     * @return
     */
    ResultVo<?> selectExamByTeacherId(QueryPageWithTSCVo queryPageWithTSCVo);

    /**
     * 查询成绩
     * @param queryVo 包含page，limit
     * @return
     */
    ResultVo<?> selectAllExam(QueryVo queryVo);

    /**
     * 通过课程名查询
     * @param queryPageWithTSCVo 包含courseName，page，limit
     * @return
     */
    ResultVo<?> selectExamByName(QueryPageWithTSCVo queryPageWithTSCVo);
}
