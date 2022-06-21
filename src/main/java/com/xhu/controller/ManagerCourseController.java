package com.xhu.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xhu.common.vo.QueryPageWithTSCVo;
import com.xhu.common.vo.QueryVo;
import com.xhu.common.vo.ResultVo;
import com.xhu.common.vo.TCourse;
import com.xhu.constant.ResultConstant;
import com.xhu.entity.StudentCourse;
import com.xhu.service.ManagerCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//TODO:
@RestController
@RequestMapping("/managers")
public class ManagerCourseController extends BaseController {
    @Autowired
    public ManagerCourseService managerCourseService;

    //查询全校课表
    @RequestMapping("/queryAll")
    /**
     * String courseId, String courseName, String teacherName, QueryVo queryVo
     */
    public String queryAll(@RequestBody QueryPageWithTSCVo queryPageWithTSCVo) {
        Map<String, Object> map = new HashMap<>();
        map.put("courseId", queryPageWithTSCVo.getCourseId());
        map.put("courseName", queryPageWithTSCVo.getCourseName());
        map.put("teacherName", queryPageWithTSCVo.getTeacherName());
        IPage iPage = new Page();
        iPage.setCurrent(queryPageWithTSCVo.getStartIndex());
        iPage.setSize(queryPageWithTSCVo.getLimit());
        IPage<TCourse> tCourseIPage = managerCourseService.queryAll(map,iPage);

        return JSON.toJSONString(this.returnPages(tCourseIPage));
    }

    //查询当前学生是否选择该课程
    @RequestMapping("/queryBySidCidTid")
    /**
     *
     */
    public String queryBySidCidTid(@RequestBody StudentCourse studentCourse) {
        ResultVo<?> resultVo= new ResultVo<>();
        if (managerCourseService.queryStudentBySid(studentCourse.getStudentId()) == null) {
            resultVo.setCode(ResultConstant.NOTFOUND);
            resultVo.setMessage("学生不存在");
        }
        if (managerCourseService.queryBySidCidTid(studentCourse) == null) {
            resultVo.setCode(ResultConstant.NOTCHECK);
            resultVo.setMessage("当前学生未选择该门课程");
        } else {
            return JSON.toJSONString(this.returnSuccessWithNoData("当前学生已选择该门课程"));
        }

        return JSON.toJSONString(resultVo);
    }

    //为当前学生选课
    @RequestMapping("/selectStudentCourse")
    public String selectStudentCourse(StudentCourse studentCourse, String lessonTime) {
        System.out.println(studentCourse.toString());
        try {
            if (managerCourseService.selectStudentCourse(lessonTime, studentCourse) == 0) {
                return JsonUtils.writerValueAsString(ResultUtils.buildFail(3000, "课程冲突！"));
            } else {
                return JsonUtils.writerValueAsString(ResultUtils.buildSuccess());
            }
        } catch (Exception e) {
            return JsonUtils.writerValueAsString(ResultUtils.buildFail(5000, "系统繁忙"));
        }
    }

    //删除学生课程
    @RequestMapping("/deleteStudentCourse")
    public String deleteStudentCourse(StudentCourse studentCourse) {
        try {
            if (managerCourseService.deleteStudentCourse(studentCourse) == 0) {
                return JsonUtils.writerValueAsString(ResultUtils.buildFail(3000, "违法访问！"));
            } else {
                return JsonUtils.writerValueAsString(ResultUtils.buildSuccess());
            }
        } catch (Exception e) {
            return JsonUtils.writerValueAsString(ResultUtils.buildFail(3000, "系统繁忙"));
        }
    }

    //添加课程
    @RequestMapping("/addCourse")
    public String addCourse(@RequestBody Course course) {
        try {
            if (managerCourseService.addCourse(course) == 0) {
                return JsonUtils.writerValueAsString(ResultUtils.buildFail(3000, "课程存在！"));
            } else {
                return JsonUtils.writerValueAsString(ResultUtils.buildSuccess());
            }
        } catch (Exception e) {
            return JsonUtils.writerValueAsString(ResultUtils.buildFail(3000, "课程存在！"));
        }
    }

    //添加任课教师信息
    @RequestMapping("/addTeacherCourse")
    public String addTeacherCourse(@RequestBody TeacherCourse teacherCourse) {
        try {
            if (managerCourseService.addTeacherCourse(teacherCourse) == 0) {
                return JsonUtils.writerValueAsString(ResultUtils.buildFail(3000, "与其他课程冲突"));
            } else {
                return JsonUtils.writerValueAsString(ResultUtils.buildSuccess());
            }
        } catch (Exception e) {
            return JsonUtils.writerValueAsString(ResultUtils.buildFail(3000, "与其他课程冲突！"));
        }
    }

    //获取所有课程
    @RequestMapping("/queryCourse")
    public String queryCourse(QueryVo queryVo) {
        HashMap map = new HashMap();
        map.put("page", queryVo.getStartIndex());
        map.put("size", queryVo.getLimit());
        QueryResult queryResult = managerCourseService.queryCourse(map);
        return JsonUtils.writerValueAsString(ResultUtils.buildSuccess(queryResult.getList(), queryResult.getCount()));
    }

    @RequestMapping("/getMaxCid")
    public String getMaxCid() {
        return managerCourseService.getMaxCid();
    }

    @RequestMapping("/queryNoTeachByCid")
    public String queryNoTeachByCid(String courseId) {
        List<Teacher> teachers = managerCourseService.queryNoTeachByCid(courseId);
        if (teachers != null) {
            return JsonUtils.writerValueAsString(ResultUtils.buildSuccess(teachers));
        } else {
            return JsonUtils.writerValueAsString(ResultUtils.buildFail(3000, "暂无教师可选"));
        }

    }
}
