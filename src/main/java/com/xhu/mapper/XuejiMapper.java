package com.xhu.mapper;

import com.edsystem.pojo.Xueji;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface XuejiMapper {
    List<Xueji> findAllList(Integer page, Integer limit);
    Integer countXuejiTotalSize();
    int addXuejiList(Xueji xueji);
    int addXuejijobsign(@Param("id")Integer id, @Param("jobsign")String jobsign);
    int deleteXuejiList(Integer id);
    int updateXuejiList(Xueji xueji);
}

