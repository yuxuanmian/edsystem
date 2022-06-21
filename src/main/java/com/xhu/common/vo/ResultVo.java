package com.xhu.common.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 返回一个json格式的结果
 *
 * @author yxm
 * @param <T> 附带的信息
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class ResultVo<T> {

    /**
     * 状态码
     */
    private Integer code;
    /**
     * 返回的消息
     */
    private String message;
    /**
     * 附带的信息
     */
    private T attachment;


}
