package com.learn.manage.mapper;

import com.learn.manage.pojo.LGrade;
import com.learn.manage.pojo.LGradeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LGradeMapper {
    long countByExample(LGradeExample example);

    int deleteByExample(LGradeExample example);

    int insert(LGrade record);

    int insertSelective(LGrade record);

    List<LGrade> selectByExample(LGradeExample example);

    int updateByExampleSelective(@Param("record") LGrade record, @Param("example") LGradeExample example);

    int updateByExample(@Param("record") LGrade record, @Param("example") LGradeExample example);
}