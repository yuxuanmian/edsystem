package com.xhu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xhu.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface StudentMapper extends BaseMapper<Student> {
}
