package com.xhu.constant;

/**
 * 状态码常量类
 */
public final class ResultConstant {

    private ResultConstant(){}
    /**
     * 请求成功常量
     */
    public static final int SUCCESS = 200;

    /**
     * 请求失败常量
     */
    public static final int FAILED= 500;
    /**
     * 未找到该学生
     */
    public static final int NOTFOUND=3000;
    /**
     * 未选课
     */
    public static final int NOTCHECK=2000;
}