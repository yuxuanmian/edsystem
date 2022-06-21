package com.xhu.utils;

import com.alibaba.fastjson.JSON;
import com.xhu.common.vo.RestultVo;

/**
 * 封装返回结果的工具类
 *
 * @author yxm
 */
public abstract class ResultVoUtil {

    private ResultVoUtil() {

    }

    /**
     * 返回一个没有附带信息的结果
     *
     * @param code    状态码
     * @param message 信息
     * @return 结果
     */
    public static String returnWithoutAttahment(int code, String message) {
        RestultVo<Void> result = new RestultVo<Void>()
                .setCode(code)
                .setMessage(message);

        return JSON.toJSONString(result);
    }

    /**
     * @param code       状态码
     * @param message    信息
     * @param attachment 附带结果
     * @param <V>        附带结果类型
     * @return 结果
     */
    public static <V> String returnWithAttachment(int code, String message, V attachment) {
        RestultVo<V> result = new RestultVo<V>()
                .setCode(code)
                .setMessage(message)
                .setAttachment(attachment);

        return JSON.toJSONString(result);
    }
}
