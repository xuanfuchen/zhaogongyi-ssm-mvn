package com.zhaogongyi.dao;

import com.zhaogongyi.model.AcctInfo;
import com.zhaogongyi.model.AcctInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AcctInfoMapper {
    int countByExample(AcctInfoExample example);

    int deleteByExample(AcctInfoExample example);

    int deleteByPrimaryKey(Integer acctId);

    int insert(AcctInfo record);

    int insertSelective(AcctInfo record);

    List<AcctInfo> selectByExample(AcctInfoExample example);

    AcctInfo selectByPrimaryKey(Integer acctId);

    int updateByExampleSelective(@Param("record") AcctInfo record, @Param("example") AcctInfoExample example);

    int updateByExample(@Param("record") AcctInfo record, @Param("example") AcctInfoExample example);

    int updateByPrimaryKeySelective(AcctInfo record);

    int updateByPrimaryKey(AcctInfo record);
}