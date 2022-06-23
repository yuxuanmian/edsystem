package com.xhu.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xhu.entity.Xueji;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface XuejiMapper {
    IPage<Xueji> findAllList(IPage<Xueji> iPage);

    int addXuejiList(Xueji xueji);

    int addXuejijobsign(@Param("id")Integer id, @Param("jobsign")String jobsign);

    int deleteXuejiList(Integer id);

    int updateXuejiList(Xueji xueji);
}

