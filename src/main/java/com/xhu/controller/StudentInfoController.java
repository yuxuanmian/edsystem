package com.xhu.controller;


import com.xhu.common.ex.CustomRuntimeException;
import com.xhu.constant.ResultConstant;
import com.xhu.entity.Student;
import com.xhu.service.StudentInfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.Objects;

/**
 * 信息管理模块
 */

@RestController
@RequestMapping("/studentInfo")
public class StudentInfoController extends BaseController{
    @Autowired
    private StudentInfoService studentInfoService;

    @RequestMapping("/updateStudentInfo")
    public String updateStudentInfo(@RequestBody Student studnet){
        if(studentInfoService.updateStudentInfo(studnet)>0){
            return this.returnSuccessWithNoData("修改成功");
        }else {
            throw new CustomRuntimeException("修改信息失败",3000);
        }
    }

    @RequestMapping("/queryMyInfo")
    public String queryMyInfo(@RequestBody Map<String,String> map){
        System.out.println(map.toString());
        String studentId=map.get("studentId");
        if(StringUtils.isEmpty(studentId)){
            throw new CustomRuntimeException("学号为空，无法查询", ResultConstant.FAILED);
        }
        Student student = studentInfoService.queryMyInfo(studentId);
        if (Objects.isNull(student)){
            throw new CustomRuntimeException("学号不存在",2000);
        }
        return this.returnSuccessWithData("查询成功",student);
    }


}
