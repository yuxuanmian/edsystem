package com.xhu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xhu.common.vo.ResultVo;
import com.xhu.entity.Xueji;

import java.util.Map;

public interface XuejiService {

    IPage<Xueji> findAllList(Map<String,String> map,Integer page, Integer limit);

    ResultVo<Xueji> addXuejiList(Xueji xueji);

    ResultVo<Xueji> addXuejijobsign(Integer Id, String jobsign);

    ResultVo<Xueji> deleteXuejiList(Integer id);

    ResultVo<Xueji> updateXuejiList(Xueji xueji);
}
