package com.xhu.common.bo;

import lombok.Data;

@Data
public class SimplePage {
    /**
     * 当前第几页
     */
    private int page;

    /**
     * 每页大小
     */
    private int limit;
}
