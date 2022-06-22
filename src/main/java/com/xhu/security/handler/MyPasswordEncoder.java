package com.xhu.security.handler;

import com.xhu.utils.Md5Utils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.security.NoSuchAlgorithmException;

@Slf4j
public class MyPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence rawPassword) {
        String encodedPassword = null;
        try {
            encodedPassword = Md5Utils.md5Password(String.valueOf(rawPassword));
        } catch (NoSuchAlgorithmException e) {
            log.error("密码编码失败" + e.getMessage());
        }
        return encodedPassword;
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        String processedPassword = null;
        try {
            processedPassword = Md5Utils.md5Password(String.valueOf(rawPassword));
        } catch (NoSuchAlgorithmException e) {
            log.error("密码编码失败" + e.getMessage());
        }
        return StringUtils.equals(encodedPassword, processedPassword);
    }
}
