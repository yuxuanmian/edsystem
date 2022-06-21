package com.xhu.mapper;

import com.edsystem.pojo.Notice;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NoticeMapper {

    //添加公告
    Integer insertNotice(Notice notice);
    //删除公告
    void deleteNotice(Integer id);
    //修改公告
    void updateNotice(Notice notice);
    //查询所有公告
    List<Notice> selectAllNotice(Integer page,Integer limit);

    Integer totalSizeNotice();
    //根据角色分页查询
    List<Notice> selectNoticeByRole(String receptRole, Integer page, Integer limit);
    //查询记录总条数
    Integer totalSize(@Param("receptRole") String receptRole);
}
