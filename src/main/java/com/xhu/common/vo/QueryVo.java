package com.xhu.common.vo;

public class QueryVo {

    //页数
    private Integer page;

    //分页大小
    private Integer limit;

    //开始序号
    private Integer startIndex;

    /**
     * 计算开始序号
     * @return
     */
    public Integer getStartIndex() {
        this.startIndex=(this.page-1)*this.limit;
        return startIndex;
    }


    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }


}

