package com.xhu.controller;


import com.edsystem.pojo.Xueji;
import com.edsystem.result.JsonResult;
import com.edsystem.result.R;
import com.edsystem.service.XuejiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//TODO:
@Controller
@RequestMapping("/xueji")
public class SysXuejiController {
   @Autowired
   private XuejiService xuejiService;



    @RequestMapping("/findAllList")
    @ResponseBody
    public JsonResult findAllList(Integer page,Integer limit){
        return xuejiService.findAllList(page,limit);
    }

    @RequestMapping("/addXuejijobsign")
    @ResponseBody
    public R addXuejiobsign(Integer Id,String jobsign){
        System.out.println("==controller+jobsign=="+jobsign);
        return xuejiService.addXuejijobsign(Id,jobsign);
    }

    @RequestMapping("/addXuejiList")
    @ResponseBody
    public R addXuejiList(Xueji xueji){
        System.out.println("==controller=="+xueji);
        return xuejiService.addXuejiList(xueji);
    }
    @RequestMapping("/deleteXuejiList")
    @ResponseBody
    public R deleteXuejiList(Integer id){
        System.out.println("Id=:"+id);
        return xuejiService.deleteXuejiList(id);
    }
    @RequestMapping("/updateXuejiList")
    @ResponseBody
    public R updateXuejiList(Xueji xueji){

        System.out.println("Controller=:"+xueji);
        return xuejiService.updateXuejiList(xueji);
    }
}
