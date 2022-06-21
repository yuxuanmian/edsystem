package com.xhu.service;

import com.edsystem.pojo.Xueji;
import com.edsystem.result.JsonResult;
import com.edsystem.result.R;
import org.apache.ibatis.annotations.Param;

public interface XuejiService {

    JsonResult findAllList(Integer page,Integer limit);

    R addXuejiList(Xueji xueji);
    R addXuejijobsign(@Param("Id")Integer Id, @Param("jobsign")String jobsign);
    R deleteXuejiList(Integer id);
    R updateXuejiList(Xueji xueji);
}
