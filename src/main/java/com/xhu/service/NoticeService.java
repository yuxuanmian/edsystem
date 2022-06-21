package com.xhu.service;

import com.edsystem.pojo.Notice;
import com.edsystem.utils.CountUtils;
import com.edsystem.utils.JsonUtils2;

public interface NoticeService {
    JsonUtils2 insertNotice(Notice notice);
    //删除公告
    JsonUtils2 deleteNotice(Integer id);
    //修改公告
    JsonUtils2 updateNotice(Notice notice);
    //查询所有公告
    CountUtils selectNoticeList(Integer page,Integer limit);

    //分页根据角色查询
    CountUtils selectNoticeByRole(String recept_role, Integer page, Integer limit);
}
