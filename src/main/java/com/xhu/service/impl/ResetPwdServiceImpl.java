package com.xhu.service.impl;

import com.edsystem.mapper.ResetPwdMapper;
import com.edsystem.service.ResetPwdService;
import com.edsystem.utils.Md5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResetPwdServiceImpl implements com.edsystem.service.ResetPwdService {
    @Autowired
    private ResetPwdMapper resetPwdMapper;

    @Override
    public int Reset(String id,String phone) {
        String pwd= Md5Utils.md5Password("123456");
        if(id.substring(0,1).equalsIgnoreCase("M")){
            if(resetPwdMapper.queryManagerInfo(id,phone)==null){
                return 0;
            }else{
                return resetPwdMapper.updateManagerPwd(id,pwd);
            }
        }else if(id.substring(0,1).equalsIgnoreCase("T")){
            if(resetPwdMapper.queryTeacherInfo(id,phone)==null){
                return 0;
            }else{
                return resetPwdMapper.updateTeacherPwd(id,pwd);
            }
        }else if(id.substring(0,1).equalsIgnoreCase("S")){
            if(resetPwdMapper.queryStudentInfo(id,phone)==null){
                return 0;
            }else{
                return resetPwdMapper.updateStudentPwd(id,pwd);
            }
        }else{
            return -1;
        }
    }

    @Override
    public int changeStudentPwd(String studentId, String pwd) {
        return resetPwdMapper.updateStudentPwd(studentId,Md5Utils.md5Password(pwd));
    }
}
