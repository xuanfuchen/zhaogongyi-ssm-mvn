package com.zhaogongyi.dao;

import com.zhaogongyi.model.ResumeCommentInfo;
import com.zhaogongyi.model.ResumeCommentInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ResumeCommentInfoMapper {
    int countByExample(ResumeCommentInfoExample example);

    int deleteByExample(ResumeCommentInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ResumeCommentInfo record);

    int insertSelective(ResumeCommentInfo record);
    
    List<ResumeCommentInfo> selectByExample(ResumeCommentInfoExample example);

    ResumeCommentInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ResumeCommentInfo record, @Param("example") ResumeCommentInfoExample example);

    int updateByExample(@Param("record") ResumeCommentInfo record, @Param("example") ResumeCommentInfoExample example);

    int updateByPrimaryKeySelective(ResumeCommentInfo record);

    int updateByPrimaryKey(ResumeCommentInfo record);
}