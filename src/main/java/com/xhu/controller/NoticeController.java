package com.xhu.controller;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xhu.common.vo.QueryVo;
import com.xhu.entity.Notice;
import com.xhu.service.NoticeService;
import com.xhu.utils.MapToPojoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

//TODO:
@RestController
@RequestMapping("/notice")
public class NoticeController extends BaseController{
    @Autowired
    private NoticeService noticeService;

    @RequestMapping(value = "/insertNotice")
    public String insertNotice(@RequestBody Notice notice){
        System.out.println(notice.getSendtime());
        return JSON.toJSONString(noticeService.insertNotice(notice));
    }

    @RequestMapping(value = "/deleteNotice")
    public String deleteNotice(@RequestBody Map<String,Integer> map){
        return JSON.toJSONString(noticeService.deleteNotice(map.get("id")));
    }

    @RequestMapping(value = "/updateNotice")
    public String updateNotice(@RequestBody Notice notice){
        return JSON.toJSONString(noticeService.updateNotice(notice));
    }

    @RequestMapping(value = "/selectNoticeByRole")
    public String selectNoticeByRole(@RequestBody Map<String,?> map){
        QueryVo queryVo = MapToPojoUtil.convert(QueryVo.class, map);
        return this.returnPages(noticeService.selectNoticeByRole((String) map.get("recept_role"),queryVo));
    }

    @RequestMapping(value = "/selectAllNotice")
    public String selectAllNotice(@RequestBody QueryVo queryVo){
        return this.returnPages(noticeService.selectNoticeList(queryVo));
    }
}
