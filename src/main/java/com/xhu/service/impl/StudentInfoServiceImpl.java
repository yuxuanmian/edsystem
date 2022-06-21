package com.xhu.service.impl;

import com.edsystem.mapper.StudentInfoMapper;
import com.edsystem.pojo.Student;
import com.edsystem.service.StudentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentInfoServiceImpl implements com.edsystem.service.StudentInfoService {
    @Autowired
    private StudentInfoMapper studentInfoMapper;

    @Override
    public int updateStudentInfo(Student student) {
        return studentInfoMapper.updateStudentInfo(student);
    }
}
