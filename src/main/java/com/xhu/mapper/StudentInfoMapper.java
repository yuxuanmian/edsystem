package com.xhu.mapper;

import com.xhu.entity.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentInfoMapper {

    Student queryStudentBySidPwd(@Param("sid") String sid,@Param("pwd") String pwd);

    //动态sql修改学生信息
    int updateStudentInfo(Student student);

    //查看学生信息
    Student queryMyInfo(String studentId);
}
