package com.xhu.controller;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xhu.common.vo.RestultVo;
import com.xhu.constant.ResultConstant;
import com.xhu.utils.ResultVoUtil;


import java.util.HashMap;
import java.util.Map;

/**
 * 父controller类
 *
 * @author yxm
 */
public abstract class BaseController {

    /**
     * 返回分页查询
     *
     * @param result 分页查询参数
     * @return 结果
     */
    protected String returnPages(IPage<?> result) {
        RestultVo<Map<String, Object>> response = new RestultVo<>();

        Map<String, Object> resMap = new HashMap<>();
        resMap.put("pageCount", result.getPages());
        resMap.put("content", result.getRecords());

        response.setCode(ResultConstant.SUCCESS);
        response.setAttachment(resMap);

        return JSON.toJSONString(response);
    }

    /**
     * 返回不带附加信息的结果
     *
     * @param message 信息
     * @return /
     */
    protected String returnSuccessWithNoData(String message) {
        return ResultVoUtil.returnWithoutAttahment(ResultConstant.SUCCESS, message);
    }

    /**
     * 用于@responsebody只有一个参数而导致把键值对都取出来的情况
     *
     * @param content 传来的json字符串
     * @param key     键的value
     * @return 值的value
     */
    protected String getSingleStr(String content, String key) {
        return JSON.parseObject(content, Map.class).get(key).toString();
    }

    /**
     * 返回带附加信息的结果
     *
     * @param message 信息
     * @param data    附加信息
     * @param <T>     泛型
     * @return /
     */
    protected <T> String returnSuccessWithData(String message, T data) {
        return ResultVoUtil.returnWithAttachment(ResultConstant.SUCCESS, message, data);
    }
}
