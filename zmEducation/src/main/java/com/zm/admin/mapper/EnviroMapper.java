package com.zm.admin.mapper;

import com.zm.admin.dao.Enviro;
import com.zm.admin.dao.EnviroExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface EnviroMapper {
    int countByExample(EnviroExample example);

    int deleteByExample(EnviroExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Enviro record);

    int insertSelective(Enviro record);

    List<Enviro> selectByExample(EnviroExample example);

    Enviro selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Enviro record, @Param("example") EnviroExample example);

    int updateByExample(@Param("record") Enviro record, @Param("example") EnviroExample example);

    int updateByPrimaryKeySelective(Enviro record);

    int updateByPrimaryKey(Enviro record);
}