//package com.xhu.service.impl;
//
//
//import com.xhu.common.vo.ResultVo;
//import com.xhu.entity.StudentCourse;
//import com.xhu.mapper.SCourseMapper;
//import com.xhu.service.SCourseService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class SCourseServiceImpl implements SCourseService {
//
//    @Autowired(required = false)
//    private SCourseMapper sCourseMapper;
//
//    /**
//     * 查询总记录数
//     */
//    @Override
//    public Integer countStudentCourseTotalSize() {
//        Integer totalSize = sCourseMapper.countStudentCourseTotalSize();
//        return totalSize;
//    }
//
//    @Override
//    public ResultVo<?> findStudentCourseList(Integer page, Integer limit) {
//        ResultVo<?> result = new ResultVo<>();
//        //分页第一个参数
//        Integer param1 = (page - 1) * limit;
//        //分页第二个参数
//        Integer param2 = limit;
//        //获取数据
//        List<StudentCourse> list = sCourseMapper.findStudentCourseList(param1, param2);
//        result.setCode(0);
//        result.setMsg("success");
//        result.setData(list);
//        //得到整个表count，总的记录数
//        Integer totalSize = sCourseMapper.countStudentCourseTotalSize();
//        result.setCount(totalSize);
//        return result;
//    }
//
//    @Override
//    public ResultVo<?> addStudentCourse(StudentCourse studentCourse) {
//        return null;
//    }
//
//
//    @Override
//    public ResultVo<?> addStudentCourse(StudentCourse studentCourse) {
//
//        JsonUtils2 jsonUtils2 = new JsonUtils2();
//        try {
//            int result = sCourseMapper.addStudentCourse(studentCourse);
//            if (result > 0) {
//                jsonUtils2.setCode(200);
//                jsonUtils2.setMsg("添加成功");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            jsonUtils2.setCode(500);
//            jsonUtils2.setMsg("系统开小差，请联系管理员");
//        }
//        return jsonUtils2;
//    }
//
//
//    @Override
//    public ResultVo<?> selectBycouseID(String courseId) {
//        JsonUtils2 jsonUtils2 = new JsonUtils2();
//
//        try {
//            StudentCourse studentCourse = sCourseMapper.selectBycouseID(courseId);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            jsonUtils2.setCode(500);
//            jsonUtils2.setMsg("系统开小差，请联系管理员");
//        }
//        return jsonUtils2;
//    }
//
//    @Override
//    public ResultVo<?> selectByID(Integer Id) {
//        JsonUtils2 jsonUtils2 = new JsonUtils2();
//
//        try {
//            StudentCourse studentCourse = sCourseMapper.selectByID(Id);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            jsonUtils2.setCode(500);
//            jsonUtils2.setMsg("系统开小差，请联系管理员");
//        }
//        return jsonUtils2;
//    }
//
//    @Override
//    public ResultVo<?> updateByID(StudentCourse studentCourse) {
//        JsonUtils2 jsonUtils2 = new JsonUtils2();
//        try {
//            int result = sCourseMapper.updateByID(studentCourse);
//            if (result > 0) {
//                jsonUtils2.setCode(200);
//                jsonUtils2.setMsg("修改成功");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            jsonUtils2.setCode(500);
//            jsonUtils2.setMsg("系统开小差，请联系管理员");
//        }
//        return jsonUtils2;
//    }
//
//    @Override
//    public ResultVo<?> deleteByID(Integer Id) {
//        JsonUtils2 jsonUtils2 = new JsonUtils2();
//        try {
//            int result = sCourseMapper.deleteByID(Id);
//            if (result > 0) {
//                jsonUtils2.setCode(200);
//                jsonUtils2.setMsg("success");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            jsonUtils2.setCode(500);
//            jsonUtils2.setMsg("系统开小差，请联系管理员");
//        }
//        return jsonUtils2;
//    }
//
//    @Override
//    public ResultVo<?> findStudentCourseByStudentList(String studentId, Integer page, Integer limit) {
//        CountUtils result = new CountUtils();
//        try {
//            //分页第一个参数
//            Integer param1 = (page - 1) * limit;
//            //分页第二个参数
//            Integer param2 = limit;
//            //获取数据
//            List<StudentCourse> list = sCourseMapper.findStudentCourseByStudentList(studentId, param1, param2);
//            result.setCode(0);
//            result.setMsg("success");
//            result.setData(list);
//            //得到整个表count，总的记录数
//            Integer totalSize = sCourseMapper.countStudentCourseByStudentTotalSize(studentId);
//            System.out.println(totalSize);
//            result.setCount(totalSize);
//        } catch (Exception e) {
//            e.printStackTrace();
//            result.setCode(500);
//            result.setMsg("系统开小差，请联系管理员！");
//        }
//        return result;
//    }
//
//    @Override
//    public ResultVo<?> findStudentCourseByTeacherList(String teacherId, Integer page, Integer limit) {
//
//        CountUtils result = new CountUtils();
//        try {
//            //分页第一个参数
//            Integer param1 = (page - 1) * limit;
//            //分页第二个参数
//            Integer param2 = limit;
//            //获取数据
//            List<StudentCourse> list = sCourseMapper.findStudentCourseByTeacherList(teacherId, param1, param2);
//            result.setCode(0);
//            result.setMsg("success");
//            result.setData(list);
//            //得到整个表count，总的记录数
//            Integer totalSize = sCourseMapper.countStudentCourseByTeacherTotalSize(teacherId);
//            result.setCount(totalSize);
//        } catch (Exception e) {
//            e.printStackTrace();
//            result.setCode(500);
//            result.setMsg("系统开小差，请联系管理员！");
//        }
//        return result;
//
//    }
//
//    @Override
//    public ResultVo<?> glyselect(String studentId, String teacherId, String courseId, Integer page, Integer limit) {
//        CountUtils result = new CountUtils();
//        try {
//            //分页第一个参数
//            Integer param1 = (page - 1) * limit;
//            //分页第二个参数
//            Integer param2 = limit;
//            //获取数据
//            List<StudentCourse> list = sCourseMapper.glyselect(studentId, teacherId, courseId, param1, param2);
//            result.setCode(0);
//            result.setMsg("success");
//            result.setData(list);
//            //得到整个表count，总的记录数
//            Integer totalSize = sCourseMapper.countglyselect(studentId, teacherId, courseId);
//            result.setCount(totalSize);
//        } catch (Exception e) {
//            e.printStackTrace();
//            result.setCode(500);
//            result.setMsg("系统开小差，请联系管理员！");
//        }
//        return result;
//    }
//
//    @Override
//    public ResultVo<?> lsselect(String studentId, String courseId, Integer page, Integer limit) {
//        CountUtils result = new CountUtils();
//        try {
//            //分页第一个参数
//            Integer param1 = (page - 1) * limit;
//            //分页第二个参数
//            Integer param2 = limit;
//            //获取数据
//            List<StudentCourse> list = sCourseMapper.lsselect(studentId, courseId, param1, param2);
//            result.setCode(0);
//            result.setMsg("success");
//            result.setData(list);
//            //得到整个表count，总的记录数
//            Integer totalSize = sCourseMapper.countlsselect(studentId, courseId);
//            result.setCount(totalSize);
//        } catch (Exception e) {
//            e.printStackTrace();
//            result.setCode(500);
//            result.setMsg("系统开小差，请联系管理员！");
//        }
//        return result;
//    }
//
//    @Override
//    public ResultVo<?> xsselect(String courseId, Integer page, Integer limit) {
//        CountUtils result = new CountUtils();
//        try {
//            //分页第一个参数
//            Integer param1 = (page - 1) * limit;
//            //分页第二个参数
//            Integer param2 = limit;
//            //获取数据
//            List<StudentCourse> list = sCourseMapper.xsselect(courseId, param1, param2);
//            result.setCode(0);
//            result.setMsg("success");
//            result.setData(list);
//            //得到整个表count，总的记录数
//            Integer totalSize = sCourseMapper.countxsselect(courseId);
//            result.setCount(totalSize);
//        } catch (Exception e) {
//            e.printStackTrace();
//            result.setCode(500);
//            result.setMsg("系统开小差，请联系管理员！");
//        }
//        return result;
//    }
//
//
//}
