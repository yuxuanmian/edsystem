package com.xhu.common.vo;

import java.util.List;

public class QueryResultVo {

    /**
     * 页面数据
     */
    private List list;
    /**
     * 查询记录的数目
     */
    private Integer count;

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
