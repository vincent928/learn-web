package com.learn.manage.mapper;

import com.learn.manage.pojo.LQuestion;
import com.learn.manage.pojo.LQuestionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LQuestionMapper {
    long countByExample(LQuestionExample example);

    int deleteByExample(LQuestionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LQuestion record);

    int insertSelective(LQuestion record);

    List<LQuestion> selectByExampleWithBLOBs(LQuestionExample example);

    List<LQuestion> selectByExample(LQuestionExample example);

    LQuestion selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") LQuestion record, @Param("example") LQuestionExample example);

    int updateByExampleWithBLOBs(@Param("record") LQuestion record, @Param("example") LQuestionExample example);

    int updateByExample(@Param("record") LQuestion record, @Param("example") LQuestionExample example);

    int updateByPrimaryKeySelective(LQuestion record);

    int updateByPrimaryKeyWithBLOBs(LQuestion record);

    int updateByPrimaryKey(LQuestion record);
}