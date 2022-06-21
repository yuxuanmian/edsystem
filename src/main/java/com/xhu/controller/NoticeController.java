package com.xhu.controller;

import com.edsystem.pojo.Notice;
import com.edsystem.service.NoticeService;
import com.edsystem.utils.CountUtils;
import com.edsystem.utils.JsonUtils2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//TODO:
@Controller
@RequestMapping("/notice")
public class NoticeController {
    @Autowired
    private NoticeService noticeService;

    @RequestMapping(value = "/insertNotice")
    @ResponseBody
    public JsonUtils2 insertNotice(Notice notice){
        return noticeService.insertNotice(notice);
    }

    @RequestMapping(value = "/deleteNotice")
    @ResponseBody
    public JsonUtils2 deleteNotice(Integer id){
        return noticeService.deleteNotice(id);
    }

    @RequestMapping(value = "/updateNotice")
    @ResponseBody
    public JsonUtils2 updateNotice(Notice notice){
        System.out.println(notice);
        return noticeService.updateNotice(notice);
    }

    @RequestMapping(value = "/selectNoticeByRole")
    @ResponseBody
    public CountUtils selectNoticeByRole(String recept_role, Integer page, Integer limit){
        System.out.println("recept_role="+recept_role+"page:"+page+"limit"+limit);
        return noticeService.selectNoticeByRole(recept_role,page,limit);
    }

    @RequestMapping(value = "/selectAllNotice")
    @ResponseBody
    public CountUtils selectAllNotice(Integer page, Integer limit){
        System.out.println("page:"+page+"limit"+limit);
        return noticeService.selectNoticeList(page, limit);
    }
}
