package com.xhu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xhu.common.vo.ResultVo;
import com.xhu.entity.Xueji;
import org.apache.ibatis.annotations.Param;

public interface XuejiService {

    IPage<Xueji> findAllList(Integer page, Integer limit);

    ResultVo<Xueji> addXuejiList(Xueji xueji);
    ResultVo<Xueji> addXuejijobsign(@Param("Id")Integer Id, @Param("jobsign")String jobsign);
    ResultVo<Xueji> deleteXuejiList(Integer id);
    ResultVo<Xueji> updateXuejiList(Xueji xueji);
}
