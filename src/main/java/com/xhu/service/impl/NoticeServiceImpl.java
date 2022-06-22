package com.xhu.service.impl;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xhu.common.vo.QueryVo;
import com.xhu.common.vo.ResultVo;
import com.xhu.constant.ResultConstant;
import com.xhu.entity.Notice;
import com.xhu.mapper.NoticeMapper;
import com.xhu.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NoticeServiceImpl implements NoticeService {
    @Autowired(required = false)
    private NoticeMapper noticeMapper;

    @Override
    public ResultVo<?> insertNotice(Notice notice) {
        ResultVo<Notice> response = new ResultVo<>();
        int result = noticeMapper.insertNotice(notice);
        if (result > 0) {
            response.setCode(ResultConstant.SUCCESS);
            response.setMessage("success");
        } else {
            response.setCode(ResultConstant.FAILED);
            response.setMessage("添加公告失败");
        }
        return response;
    }

    @Override
    public ResultVo<?> deleteNotice(Integer id) {
        ResultVo<?> response = new ResultVo<>();
        if (noticeMapper.deleteNotice(id) > 0) {
            response.setCode(ResultConstant.SUCCESS);
            response.setMessage("success");
        } else {
            response.setCode(ResultConstant.FAILED);
            response.setMessage("删除失败");
        }
        return response;
    }

    @Override
    public ResultVo<?> updateNotice(Notice notice) {
        ResultVo<Notice> response = new ResultVo<>();
        if (noticeMapper.updateNotice(notice) > 0) {
            response.setCode(ResultConstant.SUCCESS);
            response.setMessage("success");
        } else {
            response.setCode(ResultConstant.FAILED);
            response.setMessage("修改失败");
        }
        return response;
    }

    @Override
    public IPage<Notice> selectNoticeList(QueryVo queryVo) {
        ResultVo<?> response = new ResultVo<>();
        IPage<Notice> iPage = new Page<>();
        iPage.setCurrent(queryVo.getPage());
        iPage.setSize(queryVo.getLimit());
        IPage<Notice> noticeIPage = noticeMapper.selectAllNotice(iPage);

        return noticeIPage;
    }

    @Override
    public IPage<Notice> selectNoticeByRole(String recept_role, QueryVo queryVo) {
        IPage<Notice> noticeIPage = new Page<>();
        noticeIPage.setCurrent(queryVo.getPage())  ;
        noticeIPage.setSize(queryVo.getLimit());
        IPage<Notice> response = noticeMapper.selectNoticeByRole(recept_role,noticeIPage);

        return response;
    }
}
