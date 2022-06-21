package com.xhu.common.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginUserVo {
    /**
     * 工号
     */
    private String id;
    /**
     * 密码
     */
    private String pwd;
}
