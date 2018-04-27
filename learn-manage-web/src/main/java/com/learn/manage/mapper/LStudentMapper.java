package com.learn.manage.mapper;

import com.learn.manage.pojo.LStudent;
import com.learn.manage.pojo.LStudentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LStudentMapper {
    long countByExample(LStudentExample example);

    int deleteByExample(LStudentExample example);

    int deleteByPrimaryKey(String sId);

    int insert(LStudent record);

    int insertSelective(LStudent record);

    List<LStudent> selectByExample(LStudentExample example);

    LStudent selectByPrimaryKey(String sId);

    int updateByExampleSelective(@Param("record") LStudent record, @Param("example") LStudentExample example);

    int updateByExample(@Param("record") LStudent record, @Param("example") LStudentExample example);

    int updateByPrimaryKeySelective(LStudent record);

    int updateByPrimaryKey(LStudent record);
}