package com.learn.manage.mapper;

import com.learn.manage.pojo.LJudgment;
import com.learn.manage.pojo.LJudgmentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LJudgmentMapper {
    long countByExample(LJudgmentExample example);

    int deleteByExample(LJudgmentExample example);

    int deleteByPrimaryKey(Integer pdId);

    int insert(LJudgment record);

    int insertSelective(LJudgment record);

    List<LJudgment> selectByExample(LJudgmentExample example);

    LJudgment selectByPrimaryKey(Integer pdId);

    int updateByExampleSelective(@Param("record") LJudgment record, @Param("example") LJudgmentExample example);

    int updateByExample(@Param("record") LJudgment record, @Param("example") LJudgmentExample example);

    int updateByPrimaryKeySelective(LJudgment record);

    int updateByPrimaryKey(LJudgment record);
}