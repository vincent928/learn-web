package com.learn.manage.mapper;

import com.learn.manage.pojo.LTeacher;
import com.learn.manage.pojo.LTeacherExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LTeacherMapper {
    long countByExample(LTeacherExample example);

    int deleteByExample(LTeacherExample example);

    int deleteByPrimaryKey(String tId);

    int insert(LTeacher record);

    int insertSelective(LTeacher record);

    List<LTeacher> selectByExample(LTeacherExample example);

    LTeacher selectByPrimaryKey(String tId);

    int updateByExampleSelective(@Param("record") LTeacher record, @Param("example") LTeacherExample example);

    int updateByExample(@Param("record") LTeacher record, @Param("example") LTeacherExample example);

    int updateByPrimaryKeySelective(LTeacher record);

    int updateByPrimaryKey(LTeacher record);
}