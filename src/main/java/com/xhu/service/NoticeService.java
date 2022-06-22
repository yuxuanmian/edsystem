package com.xhu.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xhu.common.vo.QueryVo;
import com.xhu.common.vo.ResultVo;
import com.xhu.entity.Notice;

public interface NoticeService {
    ResultVo<?> insertNotice(Notice notice);
    //删除公告
    ResultVo<?> deleteNotice(Integer id);
    //修改公告
    ResultVo<?> updateNotice(Notice notice);
    //查询所有公告
    IPage<Notice> selectNoticeList(QueryVo queryVo);

    //分页根据角色查询
    IPage<Notice> selectNoticeByRole(String recept_role, QueryVo queryVo);
}
