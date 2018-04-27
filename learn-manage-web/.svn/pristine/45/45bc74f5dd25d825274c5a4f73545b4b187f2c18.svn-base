package com.learn.manage.mapper;

import com.learn.manage.pojo.LChoose;
import com.learn.manage.pojo.LChooseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LChooseMapper {
    long countByExample(LChooseExample example);

    int deleteByExample(LChooseExample example);

    int deleteByPrimaryKey(Integer xzId);

    int insert(LChoose record);

    int insertSelective(LChoose record);

    List<LChoose> selectByExample(LChooseExample example);

    LChoose selectByPrimaryKey(Integer xzId);

    int updateByExampleSelective(@Param("record") LChoose record, @Param("example") LChooseExample example);

    int updateByExample(@Param("record") LChoose record, @Param("example") LChooseExample example);

    int updateByPrimaryKeySelective(LChoose record);

    int updateByPrimaryKey(LChoose record);
}