package com.xhu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xhu.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface TeacherMapper extends BaseMapper<Teacher> {
}
