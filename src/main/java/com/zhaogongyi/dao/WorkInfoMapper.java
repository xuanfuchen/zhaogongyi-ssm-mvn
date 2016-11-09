package com.zhaogongyi.dao;

import com.zhaogongyi.model.WorkInfo;
import com.zhaogongyi.model.WorkInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WorkInfoMapper {
    int countByExample(WorkInfoExample example);

    int deleteByExample(WorkInfoExample example);

    int deleteByPrimaryKey(Integer workId);

    int insert(WorkInfo record);

    int insertSelective(WorkInfo record);

    List<WorkInfo> selectByExampleWithBLOBs(WorkInfoExample example);

    List<WorkInfo> selectByExample(WorkInfoExample example);

    WorkInfo selectByPrimaryKey(Integer workId);

    int updateByExampleSelective(@Param("record") WorkInfo record, @Param("example") WorkInfoExample example);

    int updateByExampleWithBLOBs(@Param("record") WorkInfo record, @Param("example") WorkInfoExample example);

    int updateByExample(@Param("record") WorkInfo record, @Param("example") WorkInfoExample example);

    int updateByPrimaryKeySelective(WorkInfo record);

    int updateByPrimaryKeyWithBLOBs(WorkInfo record);

    int updateByPrimaryKey(WorkInfo record);
}