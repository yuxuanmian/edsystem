package com.xhu.mapper;

import com.edsystem.pojo.Student;

public interface StudentInfoMapper {
    //动态sql修改学生信息
    int updateStudentInfo(Student student);
}
