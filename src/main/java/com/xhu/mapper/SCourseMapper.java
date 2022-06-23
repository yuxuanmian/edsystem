package com.xhu.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xhu.entity.StudentCourse;
import com.xhu.entity.vo.SCourse;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

@Repository
public interface SCourseMapper {
    /**
     * 管理员查看所有学生成绩
     * @param map
     * @param iPage
     * @return
     */
    IPage<SCourse> managerCherckAllStudetScore(@Param("map") Map<String,String> map, IPage<SCourse> iPage);


}
