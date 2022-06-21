package com.xhu.service;

public interface ResetPwdService {
    //重置密码
    int Reset(String id,String phone);

    //修改学生密码
    int changeStudentPwd(String studentId,String pwd);
}
