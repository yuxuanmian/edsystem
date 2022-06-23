package com.xhu.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xhu.common.ex.CustomRuntimeException;
import com.xhu.common.vo.ResultVo;
import com.xhu.constant.ResultConstant;
import com.xhu.entity.Xueji;
import com.xhu.mapper.XuejiMapper;
import com.xhu.service.XuejiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class XuejiServiceImpl implements XuejiService {
    @Autowired(required = false)
    private XuejiMapper xuejiMapper;


    public IPage<Xueji> findAllList(Map<String,String> map, Integer page, Integer limit) {
        IPage<Xueji> page1 = new Page<>();
        page1.setCurrent(page);
        page1.setSize(limit);
        return xuejiMapper.findAllList(map,page1);
    }

    @Override
    public ResultVo<Xueji> addXuejiList(Xueji xueji) {
        System.out.println("==service==" + xueji);
        ResultVo<Xueji> response = new ResultVo<>();
        if (xuejiMapper.addXuejiList(xueji) > 0) {
            response.setMessage("添加成功");
            response.setCode(ResultConstant.SUCCESS);
        } else {
            throw new CustomRuntimeException("添加失败", ResultConstant.FAILED);
        }
        return response;
    }

    @Override
    public ResultVo<Xueji> addXuejijobsign(Integer Id, String jobsign) {
        return null;
    }


    @Override
    public ResultVo<Xueji> deleteXuejiList(Integer id) {
        ResultVo<Xueji> r = new ResultVo<Xueji>();
        if (xuejiMapper.deleteXuejiList(id) > 0) {
            r.setCode(ResultConstant.SUCCESS);
            r.setMessage("删除成功！");
        } else {
            throw new CustomRuntimeException("系统繁忙", ResultConstant.FAILED);
        }
        return r;
    }

    @Override
    public ResultVo<Xueji> updateXuejiList(Xueji xueji) {
        ResultVo<Xueji> r = new ResultVo<Xueji>();
        int result = xuejiMapper.updateXuejiList(xueji);
        if (result > 0) {
            r.setCode(200);
            r.setMessage("修改成功！");
        }else {
            throw new CustomRuntimeException("系统繁忙",ResultConstant.FAILED);
        }
        return r;
    }
}
