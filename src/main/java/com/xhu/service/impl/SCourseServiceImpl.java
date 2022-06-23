package com.xhu.service.impl;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xhu.common.vo.ResultVo;
import com.xhu.entity.StudentCourse;
import com.xhu.entity.vo.SCourse;
import com.xhu.mapper.SCourseMapper;
import com.xhu.service.SCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SCourseServiceImpl implements SCourseService {

    @Autowired(required = false)
    private SCourseMapper sCourseMapper;

    @Override
    public IPage<SCourse> managerCherckAllStudetScore(Map<String,String> map) {
        IPage<SCourse> iPage = new Page<>();
        iPage.setCurrent(Long.parseLong(map.get("page")));
        iPage.setSize(Long.parseLong(map.get("limit")));
        IPage<SCourse> resultPage = sCourseMapper.managerCherckAllStudetScore(map, iPage);
        return resultPage;
    }


}
