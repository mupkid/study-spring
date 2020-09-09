package com.example.studybase.basemodule.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.studybase.basemodule.entity.FileDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FileDao extends BaseMapper<FileDO> {

}
