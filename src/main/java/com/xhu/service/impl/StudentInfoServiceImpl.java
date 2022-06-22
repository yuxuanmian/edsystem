package com.xhu.service.impl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xhu.entity.Student;
import com.xhu.mapper.StudentInfoMapper;
import com.xhu.service.StudentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentInfoServiceImpl implements StudentInfoService {
    @Autowired
    private StudentInfoMapper studentInfoMapper;

    @Override
    public int updateStudentInfo(Student student) {
        return studentInfoMapper.updateStudentInfo(student);
    }

    @Override
    public Student queryMyInfo(String studentId) {
        return studentInfoMapper.queryMyInfo(studentId);
    }
}
