package com.xhu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xhu.entity.Manager;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ManagerMapper extends BaseMapper<Manager> {
}
