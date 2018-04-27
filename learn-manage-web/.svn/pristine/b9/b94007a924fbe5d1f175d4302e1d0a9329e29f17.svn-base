package com.learn.manage.mapper;

import com.learn.manage.pojo.LUser;
import com.learn.manage.pojo.LUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LUserMapper {
    long countByExample(LUserExample example);

    int deleteByExample(LUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LUser record);

    int insertSelective(LUser record);

    List<LUser> selectByExample(LUserExample example);

    LUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") LUser record, @Param("example") LUserExample example);

    int updateByExample(@Param("record") LUser record, @Param("example") LUserExample example);

    int updateByPrimaryKeySelective(LUser record);

    int updateByPrimaryKey(LUser record);
}