package com.zhaogongyi.dao;

import com.zhaogongyi.model.WorkType;
import com.zhaogongyi.model.WorkTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WorkTypeMapper {
    int countByExample(WorkTypeExample example);

    int deleteByExample(WorkTypeExample example);

    int deleteByPrimaryKey(String workTypeId);

    int insert(WorkType record);

    int insertSelective(WorkType record);

    List<WorkType> selectByExample(WorkTypeExample example);

    WorkType selectByPrimaryKey(String workTypeId);

    int updateByExampleSelective(@Param("record") WorkType record, @Param("example") WorkTypeExample example);

    int updateByExample(@Param("record") WorkType record, @Param("example") WorkTypeExample example);

    int updateByPrimaryKeySelective(WorkType record);

    int updateByPrimaryKey(WorkType record);
}