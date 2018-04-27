package com.learn.manage.mapper;

import com.learn.manage.pojo.LSubject;
import com.learn.manage.pojo.LSubjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LSubjectMapper {
    long countByExample(LSubjectExample example);

    int deleteByExample(LSubjectExample example);

    int deleteByPrimaryKey(Integer zgId);

    int insert(LSubject record);

    int insertSelective(LSubject record);

    List<LSubject> selectByExample(LSubjectExample example);

    LSubject selectByPrimaryKey(Integer zgId);

    int updateByExampleSelective(@Param("record") LSubject record, @Param("example") LSubjectExample example);

    int updateByExample(@Param("record") LSubject record, @Param("example") LSubjectExample example);

    int updateByPrimaryKeySelective(LSubject record);

    int updateByPrimaryKey(LSubject record);
}