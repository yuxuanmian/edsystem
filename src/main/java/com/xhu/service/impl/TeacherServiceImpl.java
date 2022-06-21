package com.xhu.service.impl;

import com.edsystem.mapper.TeacherMapper;
import com.edsystem.pojo.Teacher;
import com.edsystem.result.JsonResult;
import com.edsystem.result.R;
import com.edsystem.service.TeacherService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {


    @Autowired(required = false)
    private TeacherMapper teacherMapper;


    @Override
    public JsonResult findAllList(Integer page, Integer limit) {
        JsonResult r=new JsonResult();
        try{
            Integer param1=(page-1)*limit;
            Integer param2=limit;
            r.setCode(0);
            r.setMsg("查询成功！");
            //查询所有的部门信息，塞到data中
            List<Teacher> ll= teacherMapper.findAllList(param1,param2);
            r.setData(ll);
            Integer TotalSize=teacherMapper.countTeacherTotalSize();
            r.setCount(TotalSize);
        }catch(Exception e){
            e.printStackTrace();
            r.setCode(500);
            r.setMsg("查询失败！");
        }
        return r;
    }
    @Override
    public R addTeacherList(Teacher teacher) {
        R r=new R();
        try {
            int result=teacherMapper.addTeacherList(teacher);
            if(result>0){
                r.setCode(200);
                r.setMsg("添加成功！");
            }
        }catch (Exception e){
            e.printStackTrace();
            r.setCode(500);
            r.setMsg("添加失败");
        }
        return r;
    }

    @Override
    public R deleteTeacherList(String teacherId) {
        R r=new R();
        try {
            System.out.println(teacherId);
            int result=teacherMapper.deleteTeacherList(teacherId);
                r.setCode(200);
                r.setMsg("删除成功");
        }catch (Exception e){
            e.printStackTrace();
            r.setCode(500);
            r.setMsg("删除失败");
        }
        return r;
    }

    @Override
    public R updateTeacherList(Teacher teacher) {
        R r=new R();
        try {
            System.out.println("==Service=="+teacher);
            int result=teacherMapper.updateTeacherList(teacher);
            if(result>0){
                r.setCode(200);
                r.setMsg("修改成功！");
            }
        }catch (Exception e){
            e.printStackTrace();
            r.setCode(500);
            r.setMsg("修改失败");
        }
        return r;
    }

    @Override
    public R searchTeacher(String SearchId) {
        R r=new R();
        try{
            List<Teacher> ll= teacherMapper.searchTeacher(SearchId);
            r.setData(ll);
            r.setCode(0);
            r.setMsg("查询成功！");
            System.out.println("看看ServiceId"+SearchId);
            System.out.println("Data:"+r.getData());
        }catch(Exception e){
            e.printStackTrace();
            r.setCode(500);
            r.setMsg("查询失败！");
        }
        return r;
    }

    @Override
    public R addTeacherjobsign(@Param("teacherId")String teacherId, @Param("jobsign")String jobsign) {
        R r=new R();
        try {
            System.out.println("==ServiceId=="+jobsign);
            int result=teacherMapper.addTeacherjobsign(teacherId,jobsign);
            if(result>0){
                r.setCode(200);
                r.setMsg("申请成功！");
            }
        }catch (Exception e){
            e.printStackTrace();
            r.setCode(500);
            r.setMsg("申请失败");
        }
        return r;
    }
}
