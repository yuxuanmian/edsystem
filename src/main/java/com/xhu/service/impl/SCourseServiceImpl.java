package com.xhu.service.impl;

import com.edsystem.mapper.SCourseMapper;
import com.edsystem.pojo.StudentCourse;
import com.edsystem.service.SCourseService;
import com.edsystem.utils.CountUtils;
import com.edsystem.utils.JsonUtils2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SCourseServiceImpl implements SCourseService {

    @Autowired(required = false)
    private SCourseMapper sCourseMapper;

    /**
     *
     */

    @Override
    public Integer countStudentCourseTotalSize() {
        Integer totalSize =  sCourseMapper.countStudentCourseTotalSize();
        return totalSize;
    }

    @Override
    public CountUtils findStudentCourseList(Integer page, Integer limit) {
        CountUtils result = new CountUtils();
        try{
            //分页第一个参数
            Integer param1 = (page - 1) * limit;
            //分页第二个参数
            Integer param2 = limit;
            //获取数据
            List<StudentCourse> list =  sCourseMapper.findStudentCourseList(param1,param2);
            result.setCode(0);
            result.setMsg("success");
            result.setData(list);
            //得到整个表count，总的记录数
            Integer totalSize =  sCourseMapper.countStudentCourseTotalSize();
            result.setCount(totalSize);
        }catch (Exception e){
            e.printStackTrace();
            result.setCode(500);
            result.setMsg("系统开小差，请联系管理员！");
        }
        return result;
    }


    @Override
    public JsonUtils2 addStudentCourse(StudentCourse studentCourse) {

        JsonUtils2 jsonUtils2 = new JsonUtils2();
        try {
            int result = sCourseMapper.addStudentCourse(studentCourse);
            if (result > 0) {
                jsonUtils2.setCode(200);
                jsonUtils2.setMsg("添加成功");
            }
        }catch (Exception e) {
            e.printStackTrace();
            jsonUtils2.setCode(500);
            jsonUtils2.setMsg("系统开小差，请联系管理员");
        }
        return jsonUtils2;
    }


    @Override
    public JsonUtils2 selectBycouseID(String courseId) {
        JsonUtils2 jsonUtils2 = new JsonUtils2();

        try {
            StudentCourse studentCourse= sCourseMapper.selectBycouseID(courseId);

        }catch (Exception e) {
            e.printStackTrace();
            jsonUtils2.setCode(500);
            jsonUtils2.setMsg("系统开小差，请联系管理员");
        }
        return jsonUtils2;
    }

    @Override
    public JsonUtils2 selectByID(Integer Id) {
        JsonUtils2 jsonUtils2 = new JsonUtils2();

        try {
            StudentCourse studentCourse= sCourseMapper.selectByID(Id);

        }catch (Exception e) {
            e.printStackTrace();
            jsonUtils2.setCode(500);
            jsonUtils2.setMsg("系统开小差，请联系管理员");
        }
        return jsonUtils2;
    }

    @Override
    public JsonUtils2 updateByID(StudentCourse studentCourse) {
        JsonUtils2 jsonUtils2 = new JsonUtils2();
        try {
            int result = sCourseMapper.updateByID(studentCourse);
            if (result > 0) {
                jsonUtils2.setCode(200);
                jsonUtils2.setMsg("修改成功");
            }
        }catch (Exception e) {
            e.printStackTrace();
            jsonUtils2.setCode(500);
            jsonUtils2.setMsg("系统开小差，请联系管理员");
        }
        return jsonUtils2;
    }

    @Override
    public JsonUtils2 deleteByID(Integer Id) {
        JsonUtils2 jsonUtils2 = new JsonUtils2();
        try {
            int result = sCourseMapper.deleteByID(Id);
            if (result > 0) {
                jsonUtils2.setCode(200);
                jsonUtils2.setMsg("success");
            }
        }catch (Exception e) {
            e.printStackTrace();
            jsonUtils2.setCode(500);
            jsonUtils2.setMsg("系统开小差，请联系管理员");
        }
        return jsonUtils2;
    }

    @Override
    public CountUtils findStudentCourseByStudentList(String studentId, Integer page, Integer limit) {
        CountUtils result = new CountUtils();
        try{
            //分页第一个参数
            Integer param1 = (page - 1) * limit;
            //分页第二个参数
            Integer param2 = limit;
            //获取数据
            List<StudentCourse> list =  sCourseMapper.findStudentCourseByStudentList(studentId,param1,param2);
            result.setCode(0);
            result.setMsg("success");
            result.setData(list);
            //得到整个表count，总的记录数
            Integer totalSize =  sCourseMapper.countStudentCourseByStudentTotalSize(studentId);
            System.out.println(totalSize);
            result.setCount(totalSize);
        }catch (Exception e){
            e.printStackTrace();
            result.setCode(500);
            result.setMsg("系统开小差，请联系管理员！");
        }
        return result;
    }

    @Override
    public CountUtils findStudentCourseByTeacherList(String teacherId, Integer page, Integer limit) {

        CountUtils result = new CountUtils();
        try{
            //分页第一个参数
            Integer param1 = (page - 1) * limit;
            //分页第二个参数
            Integer param2 = limit;
            //获取数据
            List<StudentCourse> list =  sCourseMapper.findStudentCourseByTeacherList(teacherId,param1,param2);
            result.setCode(0);
            result.setMsg("success");
            result.setData(list);
            //得到整个表count，总的记录数
            Integer totalSize =  sCourseMapper.countStudentCourseByTeacherTotalSize(teacherId);
            result.setCount(totalSize);
        }catch (Exception e){
            e.printStackTrace();
            result.setCode(500);
            result.setMsg("系统开小差，请联系管理员！");
        }
        return result;

    }

    @Override
    public CountUtils glyselect(String studentId, String teacherId, String courseId, Integer page, Integer limit) {
        CountUtils result = new CountUtils();
        try{
            //分页第一个参数
            Integer param1 = (page - 1) * limit;
            //分页第二个参数
            Integer param2 = limit;
            //获取数据
            List<StudentCourse> list =  sCourseMapper.glyselect(studentId,teacherId,courseId,param1,param2);
            result.setCode(0);
            result.setMsg("success");
            result.setData(list);
            //得到整个表count，总的记录数
            Integer totalSize =  sCourseMapper.countglyselect(studentId,teacherId,courseId);
            result.setCount(totalSize);
        }catch (Exception e){
            e.printStackTrace();
            result.setCode(500);
            result.setMsg("系统开小差，请联系管理员！");
        }
        return result;
    }

    @Override
    public CountUtils lsselect(String studentId, String courseId, Integer page, Integer limit) {
        CountUtils result = new CountUtils();
        try{
            //分页第一个参数
            Integer param1 = (page - 1) * limit;
            //分页第二个参数
            Integer param2 = limit;
            //获取数据
            List<StudentCourse> list =  sCourseMapper.lsselect(studentId,courseId,param1,param2);
            result.setCode(0);
            result.setMsg("success");
            result.setData(list);
            //得到整个表count，总的记录数
            Integer totalSize =  sCourseMapper.countlsselect(studentId,courseId);
            result.setCount(totalSize);
        }catch (Exception e){
            e.printStackTrace();
            result.setCode(500);
            result.setMsg("系统开小差，请联系管理员！");
        }
        return result;
    }

    @Override
    public CountUtils xsselect(String courseId, Integer page, Integer limit) {
        CountUtils result = new CountUtils();
        try{
            //分页第一个参数
            Integer param1 = (page - 1) * limit;
            //分页第二个参数
            Integer param2 = limit;
            //获取数据
            List<StudentCourse> list =  sCourseMapper.xsselect(courseId,param1,param2);
            result.setCode(0);
            result.setMsg("success");
            result.setData(list);
            //得到整个表count，总的记录数
            Integer totalSize =  sCourseMapper.countxsselect(courseId);
            result.setCount(totalSize);
        }catch (Exception e){
            e.printStackTrace();
            result.setCode(500);
            result.setMsg("系统开小差，请联系管理员！");
        }
        return result;
    }

    /*@Override
    public JsonResult glyselect(String userId, Integer page, Integer limit) {
        JsonResult result = new JsonResult();
        try{
            //分页第一个参数
            Integer param1 = (page - 1) * limit;
            //分页第二个参数
            Integer param2 = limit;
            //获取数据
            List<StudentCourse> list =  studentCourseMapper.findStudentCourseByTeacherList(userId,param1,param2);
            result.setCode(0);
            result.setMsg("success");
            result.setData(list);
            //得到整个表count，总的记录数
            Integer totalSize =  studentCourseMapper.countStudentCourseByTeacherTotalSize(userId);
            result.setCount(totalSize);
        }catch (Exception e){
            e.printStackTrace();
            result.setCode(500);
            result.setMsg("系统开小差，请联系管理员！");
        }
        return result;
    }*/



    /*@Override
    public JsonResult glySelect(String studentId,String teacherId,String courseId,Integer page, Integer limit) {
        JsonResult result = new JsonResult();
        try{
            //分页第一个参数
            Integer param1 = (page - 1) * limit;
            //分页第二个参数
            Integer param2 = limit;
            //获取数据
            List<StudentCourse> list =  studentCourseMapper.glyselect(studentId,teacherId,courseId,page,limit);
            result.setCode(0);
            result.setMsg("success");
            result.setData(list);
            //得到整个表count，总的记录数
            Integer totalSize =  studentCourseMapper.countglyselect(studentId,teacherId,courseId);
            result.setCount(totalSize);
        }catch (Exception e){
            e.printStackTrace();
            result.setCode(500);
            result.setMsg("系统开小差，请联系管理员！");
        }
        return result;
    }*/


}
