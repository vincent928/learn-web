package com.learn.manage.mapper;

import com.learn.manage.pojo.StuChoose;
import com.learn.manage.pojo.StuChooseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StuChooseMapper {
    long countByExample(StuChooseExample example);

    int deleteByExample(StuChooseExample example);

    int deleteByPrimaryKey(Integer xzId);

    int insert(StuChoose record);

    int insertSelective(StuChoose record);

    List<StuChoose> selectByExample(StuChooseExample example);

    StuChoose selectByPrimaryKey(Integer xzId);

    int updateByExampleSelective(@Param("record") StuChoose record, @Param("example") StuChooseExample example);

    int updateByExample(@Param("record") StuChoose record, @Param("example") StuChooseExample example);

    int updateByPrimaryKeySelective(StuChoose record);

    int updateByPrimaryKey(StuChoose record);
}