package com.learn.manage.mapper;

import com.learn.manage.pojo.StuJudgment;
import com.learn.manage.pojo.StuJudgmentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StuJudgmentMapper {
    long countByExample(StuJudgmentExample example);

    int deleteByExample(StuJudgmentExample example);

    int deleteByPrimaryKey(Integer pdId);

    int insert(StuJudgment record);

    int insertSelective(StuJudgment record);

    List<StuJudgment> selectByExample(StuJudgmentExample example);

    StuJudgment selectByPrimaryKey(Integer pdId);

    int updateByExampleSelective(@Param("record") StuJudgment record, @Param("example") StuJudgmentExample example);

    int updateByExample(@Param("record") StuJudgment record, @Param("example") StuJudgmentExample example);

    int updateByPrimaryKeySelective(StuJudgment record);

    int updateByPrimaryKey(StuJudgment record);
}