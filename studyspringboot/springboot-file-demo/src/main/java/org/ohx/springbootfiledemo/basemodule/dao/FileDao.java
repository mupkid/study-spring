package org.ohx.springbootfiledemo.basemodule.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.ohx.springbootfiledemo.basemodule.entity.FileDO;

@Mapper
public interface FileDao extends BaseMapper<FileDO> {

}
