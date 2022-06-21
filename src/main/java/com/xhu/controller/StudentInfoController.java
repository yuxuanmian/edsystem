package com.xhu.controller;

import com.edsystem.pojo.Student;
import com.edsystem.service.StudentInfoService;
import com.edsystem.utils.JsonUtils;
import com.edsystem.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//TODO:
@RestController
@RequestMapping("/student2")
public class StudentInfoController {
    @Autowired
    private StudentInfoService studentInfoService;

    @RequestMapping("/updateStudentInfo")
    public String updateStudentInfo(@RequestBody Student studnet){
        if(studentInfoService.updateStudentInfo(studnet)>0){
            return JsonUtils.writerValueAsString(ResultUtils.buildSuccess());
        }else {
            return JsonUtils.writerValueAsString(ResultUtils.buildFail(3000,"系统繁忙"));
        }
    }
}
