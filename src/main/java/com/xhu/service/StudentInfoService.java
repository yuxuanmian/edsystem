package com.xhu.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xhu.entity.Student;
import com.xhu.mapper.StudentInfoMapper;

public interface StudentInfoService{
    //修改学生信息
    int updateStudentInfo(Student student);

    //查看个人信息
    Student queryMyInfo(String studentId);
}
