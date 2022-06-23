package com.xhu.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xhu.common.vo.ResultVo;
import com.xhu.entity.Course;
import com.xhu.entity.StudentCourse;
import com.xhu.entity.Teacher;
import com.xhu.entity.vo.SCourse;
import com.xhu.entity.vo.TCourse;
import com.xhu.mapper.SCourseMapper;
import com.xhu.service.SCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SCourseServiceImpl implements SCourseService {

    @Autowired(required = false)
    private SCourseMapper sCourseMapper;

    @Override
    public IPage<SCourse> managerCherckAllStudetScore(Map<String,String> map) {
        IPage<SCourse> iPage = new Page<>();
        iPage.setCurrent(Long.parseLong(map.get("page")));
        iPage.setSize(Long.parseLong(map.get("limit")));
        IPage<SCourse> resultPage = sCourseMapper.managerCherckAllStudetScore(map, iPage);
        return resultPage;
    }

    @Override
    public boolean managerUpdateStudentScore(StudentCourse studentCourse) {
        if(sCourseMapper.managerUpdateStudentScore(studentCourse)>0){
            return true;
        }
        return false;
    }

    @Override
    public List<Teacher> queryAllTeacher() {
        return sCourseMapper.queryAllTeacher();
    }

    @Override
    public List<Course> queryAllCourse() {
        return sCourseMapper.queryAllCourse();
    }

    @Override
    public IPage<SCourse> teacherCherckAllStudetScore(Map<String, String> map) {
        IPage<SCourse> iPage = new Page<>();
        iPage.setCurrent(Long.parseLong(map.get("page")));
        iPage.setSize(Long.parseLong(map.get("limit")));
        IPage<SCourse> resultPage = sCourseMapper.teacherCherckAllStudetScore(map, iPage);
        return resultPage;
    }

    @Override
    public List<TCourse> queryMyCourse(String teacherId) {
        return sCourseMapper.queryMyCourse(teacherId);
    }

    @Override
    public boolean teacherAddStduentScore(StudentCourse studentCourse) {
        if(sCourseMapper.teacherAddStduentScore(studentCourse)>0){
            return true;
        }
        return false;
    }

    @Override
    public IPage<SCourse> studentCheckMyScore(Map<String, String> map) {
        IPage<SCourse> iPage = new Page<>();
        iPage.setCurrent(Long.parseLong(map.get("page")));
        iPage.setSize(Long.parseLong(map.get("limit")));
        IPage<SCourse> resultPage = sCourseMapper.studentCheckMyScore(map, iPage);
        return resultPage;
    }


}
