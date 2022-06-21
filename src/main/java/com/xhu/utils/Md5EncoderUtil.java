package com.xhu.utils;

import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

/**
 * md5密码工具类
 *
 * @author yxm
 */
public abstract class Md5EncoderUtil {
    /**
     * 加密次数
     */
    private static final int TIME = 3;

    private Md5EncoderUtil() {
        //防止实例化
    }

    /**
     * 生成md5密码
     * @param rawPassword 明文密码
     * @param salt 盐值
     * @return md5密码
     */
    public static String encode(String rawPassword, String salt) {
        String result = null;
        for (int i = 0; i < TIME; i++) {
            String contra = salt + rawPassword + salt;
            result = DigestUtils.md5DigestAsHex(contra.getBytes(StandardCharsets.UTF_8));
        }
        return result;
    }

    /**
     * 生成盐值
     * @return 盐值
     */
    public static String getSalt(){
        String rawUuid= UUID.randomUUID().toString();
        rawUuid = rawUuid.replace("-", "");
        return rawUuid;
    }


}
