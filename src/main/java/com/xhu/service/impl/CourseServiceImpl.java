package com.xhu.service.impl;

import com.xhu.common.ex.CustomRuntimeException;
import com.xhu.common.vo.QueryPageWithTSCVo;
import com.xhu.common.vo.QueryVo;
import com.xhu.common.vo.ResultVo;
import com.xhu.constant.ResultConstant;
import com.xhu.mapper.CourseMapper;
import com.xhu.entity.Course;
import com.xhu.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseMapper courseMapper;

    @Override
    public ResultVo<?> updateExam(Course course) {
        ResultVo response = new ResultVo();
        if(courseMapper.updateExam(course)>0) {
            response.setCode(ResultConstant.SUCCESS);
            response.setMessage("success");
            return response;
        }else{
            throw new CustomRuntimeException("系统繁忙",ResultConstant.FAILED);
        }
    }

    @Override
    public ResultVo<?> selectExamByStudentId(QueryPageWithTSCVo queryPageWithTSCVo) {
        ResultVo response = new ResultVo<>();
        try {
            Integer param1 = (queryPageWithTSCVo.getPage() - 1) * queryPageWithTSCVo.getLimit();
            Integer param2 = queryPageWithTSCVo.getLimit();
            List<Course> courseList = courseMapper.selectExamByStudentId(queryPageWithTSCVo.getStudentId(), param1, param2);
            Integer count = courseMapper.totalSizeByStudentId(queryPageWithTSCVo.getStudentId());
            response.setCode(ResultConstant.SUCCESS);
            response.setMessage("success");
            Map<String, Object> map = new HashMap<>();
            map.put("count", count);
            map.put("data", courseList);
            response.setAttachment(map);
        } catch (Exception e) {
            e.printStackTrace();
            response.setCode(500);
            response.setMessage("系统开小差，请联系管理员！");
        }
        return response;
    }

    @Override
    public ResultVo<?> selectExamByTeacherId(QueryPageWithTSCVo queryPageWithTSCVo) {
        ResultVo countUtils = new ResultVo();
        try {
            Integer param1 = (queryPageWithTSCVo.getPage() - 1) * queryPageWithTSCVo.getLimit();
            Integer param2 = queryPageWithTSCVo.getLimit();
            List<Course> courseList = courseMapper.selectExamByTeacherId(queryPageWithTSCVo.getTeacherId(), param1, param2);
            Integer count = courseMapper.totalSizeByTeacherId(queryPageWithTSCVo.getTeacherId());
            countUtils.setCode(ResultConstant.SUCCESS);
            countUtils.setMessage("success");
            Map<String, Object> map = new HashMap<>();
            map.put("count", count);
            map.put("data", courseList);
            countUtils.setAttachment(map);
        } catch (Exception e) {
            e.printStackTrace();
            countUtils.setCode(ResultConstant.FAILED);
            countUtils.setMessage("系统开小差，请联系管理员！");
        }
        return countUtils;
    }

    @Override
    public ResultVo<?> selectAllExam(QueryVo queryVo) {
        ResultVo countUtils = new ResultVo();
        try {
            Integer param1 = (queryVo.getPage() - 1) * queryVo.getLimit();
            Integer param2 = queryVo.getLimit();
            List<Course> courseList = courseMapper.selectAllExam(param1, param2);
            Integer count = courseMapper.totalSize();
            countUtils.setCode(ResultConstant.SUCCESS);
            countUtils.setMessage("success");
            Map<String, Object> map = new HashMap<>();
            map.put("count", count);
            map.put("data", courseList);
            countUtils.setAttachment(map);
        } catch (Exception e) {
            e.printStackTrace();
            countUtils.setCode(ResultConstant.FAILED);
            countUtils.setMessage("系统开小差，请联系管理员！");
        }
        return countUtils;
    }

    @Override
    public ResultVo<?> selectExamByName(QueryPageWithTSCVo queryPageWithTSCVo) {
        ResultVo countUtils = new ResultVo();
        try {
            Integer param1 = (queryPageWithTSCVo.getPage() - 1) * queryPageWithTSCVo.getLimit();
            Integer param2 = queryPageWithTSCVo.getLimit();
            List<Course> courseList = courseMapper.selectExamByName(queryPageWithTSCVo.getCourseName(), param1, param2);
            Integer count = courseMapper.totalSizeByName(queryPageWithTSCVo.getCourseName());
            countUtils.setCode(ResultConstant.SUCCESS);
            countUtils.setMessage("success");
            Map<String, Object> map = new HashMap<>();
            map.put("count", count);
            map.put("data", courseList);
            countUtils.setAttachment(map);
        } catch (Exception e) {
            e.printStackTrace();
            countUtils.setCode(ResultConstant.FAILED);
            countUtils.setMessage("系统开小差，请联系管理员！");
        }
        return countUtils;
    }
}
