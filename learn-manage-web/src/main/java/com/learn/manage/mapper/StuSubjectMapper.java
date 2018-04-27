package com.learn.manage.mapper;

import com.learn.manage.pojo.StuSubject;
import com.learn.manage.pojo.StuSubjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StuSubjectMapper {
    long countByExample(StuSubjectExample example);

    int deleteByExample(StuSubjectExample example);

    int insert(StuSubject record);

    int insertSelective(StuSubject record);

    List<StuSubject> selectByExampleWithBLOBs(StuSubjectExample example);

    List<StuSubject> selectByExample(StuSubjectExample example);

    int updateByExampleSelective(@Param("record") StuSubject record, @Param("example") StuSubjectExample example);

    int updateByExampleWithBLOBs(@Param("record") StuSubject record, @Param("example") StuSubjectExample example);

    int updateByExample(@Param("record") StuSubject record, @Param("example") StuSubjectExample example);
    
    int updateByMyself(@Param("record") StuSubject record);
}