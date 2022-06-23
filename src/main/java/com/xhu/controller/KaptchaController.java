package com.xhu.controller;

import com.google.code.kaptcha.Producer;
import com.xhu.constant.ParameterConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.UUID;

@RestController
@Slf4j
public class KaptchaController extends BaseController {

    @Autowired
    Producer producer;

    @RequestMapping("/vc.jpg")
    public String kaptcha(HttpSession session) throws IOException {
        String text = UUID.randomUUID().toString().replace("_", "").substring(0, 4);
        log.info(text);
        //将验证码的值存入session
        session.setAttribute(ParameterConstant.VERIFY_CODE.value(), text);

        BufferedImage image = producer.createImage(text);

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ImageIO.write(image, "jpg", bos);
        byte[] bytes = bos.toByteArray();
        //base64 编码
        return new String(Base64.getEncoder().encode(bytes));
    }

}
