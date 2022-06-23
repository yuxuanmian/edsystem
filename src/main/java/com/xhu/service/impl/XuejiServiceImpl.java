//package com.xhu.service.impl;
//
//import com.edsystem.mapper.XuejiMapper;
//import com.edsystem.pojo.Xueji;
//import com.edsystem.result.JsonResult;
//import com.edsystem.result.R;
//import com.edsystem.service.XuejiService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class XuejiServiceImpl implements XuejiService {
//    @Autowired(required = false)
//    private XuejiMapper xuejiMapper;
//
//
//
//    public JsonResult findAllList(Integer page, Integer limit) {
//        JsonResult r=new JsonResult();
//        try{
//            Integer param1=(page-1)*limit;
//            Integer param2=limit;
//            r.setCode(0);
//            r.setMsg("查询成功！");
//            //查询所有的部门信息，塞到data中
//            List<Xueji> ll=xuejiMapper.findAllList(param1,param2);
//            r.setData(ll);
//            Integer TotalSize=xuejiMapper.countXuejiTotalSize();
//            r.setCount(TotalSize);
//        }catch(Exception e){
//            e.printStackTrace();
//            r.setCode(500);
//            r.setMsg("查询失败！");
//        }
//        return r;
//    }
//  @Override
//    public R addXuejiList(Xueji xueji) {
//        System.out.println("==service=="+xueji);
//        R r=new R();
//        try {
//            int result=xuejiMapper.addXuejiList(xueji);
//            if(result>0){
//                r.setCode(200);
//                r.setMsg("添加成功！");
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//            r.setCode(500);
//            r.setMsg("添加失败");
//        }
//        return r;
//    }
//
//    @Override
//    public R addXuejijobsign(Integer Id, String jobsign) {
//        return null;
//    }
//
//
//    @Override
//    public R deleteXuejiList(Integer id) {
//        R r=new R();
//        try {
//            System.out.println(id);
//            int result=xuejiMapper.deleteXuejiList(id);
//            r.setCode(200);
//            r.setMsg("删除成功！");
//        }catch (Exception e){
//            e.printStackTrace();
//            r.setCode(500);
//            r.setMsg("删除失败");
//        }
//        return r;
//    }
//
//    @Override
//    public R updateXuejiList(Xueji xueji) {
//        R r=new R();
//        try {
//            System.out.println("==Service=="+xueji);
//            int result=xuejiMapper.updateXuejiList(xueji);
//            if(result>0){
//                r.setCode(200);
//                r.setMsg("修改成功！");
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//            r.setCode(500);
//            r.setMsg("修改失败");
//        }
//        return r;
//    }
//}
