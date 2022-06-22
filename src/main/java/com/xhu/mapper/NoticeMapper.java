package com.xhu.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xhu.entity.Notice;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticeMapper {

    //添加公告
    Integer insertNotice(Notice notice);
    //删除公告
    Integer deleteNotice(Integer id);
    //修改公告
    Integer updateNotice(Notice notice);
    //查询所有公告
    IPage<Notice> selectAllNotice(IPage<?> iPage);

    Integer totalSizeNotice();
    //根据角色分页查询
    IPage<Notice> selectNoticeByRole(String receptRole, IPage<Notice> iPage);
}
