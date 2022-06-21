package com.xhu.service.impl;

import com.edsystem.mapper.NoticeMapper;
import com.edsystem.pojo.Notice;
import com.edsystem.service.NoticeService;
import com.edsystem.utils.CountUtils;
import com.edsystem.utils.JsonUtils2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeServiceImpl implements com.edsystem.service.NoticeService {
    @Autowired(required = false)
    private NoticeMapper noticeMapper;

    @Override
    public JsonUtils2 insertNotice(Notice notice) {
        JsonUtils2 jsonUtils=new JsonUtils2();
        try{
            int result=noticeMapper.insertNotice(notice);
            if(result>0){
                jsonUtils.setCode(0);
                jsonUtils.setMsg("success");
            }
        }catch (Exception e){
            e.printStackTrace();
            jsonUtils.setCode(500);
            jsonUtils.setMsg("系统开小差，请联系管理员！");
        }
        return jsonUtils;
    }

    @Override
    public JsonUtils2 deleteNotice(Integer id) {
        JsonUtils2 jsonUtils=new JsonUtils2();
        try{
            noticeMapper.deleteNotice(id);
            jsonUtils.setCode(0);
            jsonUtils.setMsg("success");
        }catch (Exception e){
            e.printStackTrace();
            jsonUtils.setCode(500);
            jsonUtils.setMsg("系统开小差，请联系管理员！");
        }
        return jsonUtils;
    }

    @Override
    public JsonUtils2 updateNotice(Notice notice) {
        JsonUtils2 jsonUtils=new JsonUtils2();
        try{
            noticeMapper.updateNotice(notice);
            jsonUtils.setCode(0);
            jsonUtils.setMsg("success");
        }catch (Exception e){
            e.printStackTrace();
            jsonUtils.setCode(500);
            jsonUtils.setMsg("系统开小差，请联系管理员！");
        }
        return jsonUtils;
    }

    @Override
    public CountUtils selectNoticeList(Integer page, Integer limit) {
        CountUtils countUtils=new CountUtils();
        try {
            Integer param1 = (page - 1) * limit;
            Integer param2 = limit;
            List<Notice> noticeList = noticeMapper.selectAllNotice(param1,param2);
            Integer count=noticeMapper.totalSizeNotice();
            countUtils.setCode(0);
            countUtils.setMsg("success");
            countUtils.setCount(count);
            countUtils.setData(noticeList);
        }catch (Exception e){
            e.printStackTrace();
            countUtils.setCode(500);
            countUtils.setMsg("系统开小差，请联系管理员！");
        }
        return countUtils;
    }

    @Override
    public CountUtils selectNoticeByRole(String recept_role, Integer page, Integer limit) {
        CountUtils countUtils=new CountUtils();
        try {
            Integer param1 = (page - 1) * limit;
            Integer param2 = limit;
            List<Notice> noticeList = noticeMapper.selectNoticeByRole(recept_role, param1, param2);
            Integer count=noticeMapper.totalSize(recept_role);
            countUtils.setCode(0);
            countUtils.setMsg("success");
            countUtils.setCount(count);
            countUtils.setData(noticeList);
        }catch (Exception e){
            e.printStackTrace();
            countUtils.setCode(500);
            countUtils.setMsg("系统开小差，请联系管理员！");
        }
        return countUtils;
    }
}
