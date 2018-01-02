package com.zm.admin.mapper;

import com.zm.admin.dao.Mechanism;
import com.zm.admin.dao.MechanismExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface MechanismMapper {
    int countByExample(MechanismExample example);

    int deleteByExample(MechanismExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Mechanism record);

    int insertSelective(Mechanism record);

    List<Mechanism> selectByExample(MechanismExample example);

    Mechanism selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Mechanism record, @Param("example") MechanismExample example);

    int updateByExample(@Param("record") Mechanism record, @Param("example") MechanismExample example);

    int updateByPrimaryKeySelective(Mechanism record);

    int updateByPrimaryKey(Mechanism record);
}