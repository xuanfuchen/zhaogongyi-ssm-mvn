package com.zhaogongyi.dao.common;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.zhaogongyi.dao.AcctInfoMapper;
import com.zhaogongyi.dao.CommentInfoMapper;
import com.zhaogongyi.dao.CompanyInfoMapper;
import com.zhaogongyi.dao.PlaceMapper;
import com.zhaogongyi.dao.ResumeInfoMapper;
import com.zhaogongyi.dao.WorkInfoMapper;
import com.zhaogongyi.dao.WorkTypeMapper;
import com.zhaogongyi.dao.custom.AcctInfoMapperCustom;
import com.zhaogongyi.dao.custom.ResumeInfoMapperCustom;
import com.zhaogongyi.dao.custom.WorkInfoMapperCustom;

@Repository
public class DaoUtil {
	/**
	 * 各单表
	 */
	@Resource
	public BaseDaoTool baseDaoTool;
	@Resource
	public AcctInfoMapper acctInfoMapper;
	@Resource
	public CompanyInfoMapper companyInfoMapper;
	@Resource
	public PlaceMapper placeMapper;
	@Resource
	public ResumeInfoMapper resumeInfoMapper;
	@Resource
	public WorkInfoMapper workInfoMapper;
	@Resource
	public WorkTypeMapper workTypeMapper;
	@Resource
	public CommentInfoMapper commentInfoMapper;
	
	/**
	 * 自定义接口
	 */
	@Resource
	public AcctInfoMapperCustom acctInfoMapperCustom;
	@Resource
	public ResumeInfoMapperCustom resumeInfoMapperCustom;
	@Resource
	public WorkInfoMapperCustom workInfoMapperCustom;
	
}
