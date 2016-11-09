package com.zhaogongyi.dao;

import com.zhaogongyi.model.CompanyInfo;
import com.zhaogongyi.model.CompanyInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CompanyInfoMapper {
    int countByExample(CompanyInfoExample example);

    int deleteByExample(CompanyInfoExample example);

    int deleteByPrimaryKey(Integer companyId);

    int insert(CompanyInfo record);

    int insertSelective(CompanyInfo record);

    List<CompanyInfo> selectByExampleWithBLOBs(CompanyInfoExample example);

    List<CompanyInfo> selectByExample(CompanyInfoExample example);

    CompanyInfo selectByPrimaryKey(Integer companyId);

    int updateByExampleSelective(@Param("record") CompanyInfo record, @Param("example") CompanyInfoExample example);

    int updateByExampleWithBLOBs(@Param("record") CompanyInfo record, @Param("example") CompanyInfoExample example);

    int updateByExample(@Param("record") CompanyInfo record, @Param("example") CompanyInfoExample example);

    int updateByPrimaryKeySelective(CompanyInfo record);

    int updateByPrimaryKeyWithBLOBs(CompanyInfo record);

    int updateByPrimaryKey(CompanyInfo record);
}