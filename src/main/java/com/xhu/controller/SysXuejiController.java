package com.xhu.controller;


import com.alibaba.fastjson.JSON;
import com.xhu.common.vo.QueryVo;
import com.xhu.entity.Xueji;
import com.xhu.service.XuejiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

//TODO:
@Controller
@RequestMapping("/xueji")
public class SysXuejiController extends BaseController{
   @Autowired
   private XuejiService xuejiService;



    @RequestMapping("/findAllList")
    @ResponseBody
    public String findAllList(@RequestBody Map<String,String> map){
        System.out.println(map.toString());
        return this.returnPages(xuejiService.findAllList(map,Integer.parseInt(map.get("page")),Integer.parseInt(map.get("limit"))));
    }

    @RequestMapping("/addXuejiList")
    @ResponseBody
    public String addXuejiList(@RequestBody Xueji xueji){
        return JSON.toJSONString(xuejiService.addXuejiList(xueji));
    }
    @RequestMapping("/deleteXuejiList")
    @ResponseBody
    public String deleteXuejiList(@RequestBody Map<String,Integer> map){
        return JSON.toJSONString(xuejiService.deleteXuejiList(map.get("id")));
    }
    @RequestMapping("/updateXuejiList")
    @ResponseBody
    public String updateXuejiList(@RequestBody Xueji xueji){
        return JSON.toJSONString(xuejiService.updateXuejiList(xueji));
    }
}
