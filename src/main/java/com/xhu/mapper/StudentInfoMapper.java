package com.xhu.mapper;

import com.xhu.entity.Student;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentInfoMapper {
    //动态sql修改学生信息
    int updateStudentInfo(Student student);

    //查看学生信息
    Student queryMyInfo(String studentId);
}
