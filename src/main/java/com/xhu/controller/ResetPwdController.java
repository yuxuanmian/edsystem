package com.xhu.controller;

import com.edsystem.service.ResetPwdService;
import com.edsystem.utils.JsonUtils;
import com.edsystem.utils.ResultUtils;
import com.edsystem.utils.YzmUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

//TODO:
@RestController
@RequestMapping("/reset")
public class ResetPwdController {
    @Autowired
    private ResetPwdService pwdService;

    @RequestMapping("/resetPwd")
    public String restPwd(HttpServletRequest request, String id, String phone, String code){
        if(code==null){
            return JsonUtils.writerValueAsString(ResultUtils.buildFail(-1,"非法访问！！！"));
        }
        String session_vcode=(String) request.getSession().getAttribute("resetCode");
        if (!code.equalsIgnoreCase(session_vcode)){
            return JsonUtils.writerValueAsString(ResultUtils.buildFail(1111,"验证码错误"));
        }
        int reset = pwdService.Reset(id, phone);
        if(reset==-1){
            return JsonUtils.writerValueAsString(ResultUtils.buildFail(-1,"信息格式错误！"));
        }else if(reset==0){
            return JsonUtils.writerValueAsString(ResultUtils.buildFail(2000,"信息验证失败"));
        }else{
            return JsonUtils.writerValueAsString(ResultUtils.buildSuccess());
        }

    }

    @RequestMapping("/changeStudentPwd")
    public String changeStduentPwd(String studentId,String pwd){
        System.out.println(studentId+" "+pwd);
         if(pwdService.changeStudentPwd(studentId, pwd)>0){
             return JsonUtils.writerValueAsString(ResultUtils.buildSuccess());
         }else{
             return JsonUtils.writerValueAsString(ResultUtils.buildFail(3000,"系统繁忙"));
         }
    }

    @RequestMapping("/getVerCode")
    public void getVerCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //用我们的验证码类，生成验证码类对象
        YzmUtils ivc = new YzmUtils();
        //获取验证码图片
        BufferedImage image = ivc.getImage();
        //将验证码的文本存在session中
        request.getSession().setAttribute("resetCode", ivc.getText());
//        System.out.println(request.getSession().getAttribute("resetCode"));
        //将验证码图片响应给客户端
        ivc.output(image, response.getOutputStream());
    }
}
