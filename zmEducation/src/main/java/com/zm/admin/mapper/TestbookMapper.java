package com.zm.admin.mapper;

import com.zm.admin.dao.Testbook;
import com.zm.admin.dao.TestbookExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface TestbookMapper {
    int countByExample(TestbookExample example);

    int deleteByExample(TestbookExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Testbook record);

    int insertSelective(Testbook record);

    List<Testbook> selectByExample(TestbookExample example);

    Testbook selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Testbook record, @Param("example") TestbookExample example);

    int updateByExample(@Param("record") Testbook record, @Param("example") TestbookExample example);

    int updateByPrimaryKeySelective(Testbook record);

    int updateByPrimaryKey(Testbook record);
}