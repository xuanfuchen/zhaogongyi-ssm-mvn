package com.zhaogongyi.service.common;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhaogongyi.dao.common.DaoUtil;
import com.zhaogongyi.model.AcctInfo;
import com.zhaogongyi.model.CompanyInfo;
import com.zhaogongyi.model.CompanyInfoExample;
@Service
@Transactional
public class AcctInfoService {
	private static final Log log = LogFactory.getLog(AcctInfoService.class);
	@Resource private DaoUtil daoUtil;

	// 修改AcctInfo
	public boolean updateAcctInfo(AcctInfo acctInfo) {
		boolean bo = false;
		try {
			bo = daoUtil.acctInfoMapper.updateByPrimaryKeySelective(acctInfo) > 0 ? true : false;
		} catch (Exception e) {
			log.error("修改AcctInfo出错", e);
			e.printStackTrace();
		}
		return bo;
	}
	
	public Serializable updateCompanyInfo(CompanyInfo company) {
		Serializable io = null;
		try {
			io = daoUtil.companyInfoMapper.updateByPrimaryKeySelective(company);
		} catch (Exception e) {
			log.error("保存公司信息失败", e);
			e.printStackTrace();
		}
		return io;
	}
	
	public CompanyInfo getCompanyInfo(Integer acctId) {
		List<CompanyInfo> list = null;
		try {
			CompanyInfoExample example = new CompanyInfoExample();
			example.createCriteria().andAcctIdFkEqualTo(acctId);
			list = daoUtil.companyInfoMapper.selectByExample(example );
			
		} catch (Exception e) {
			log.error("查询", e);
			e.printStackTrace();
		}
		return list != null && !list.isEmpty() ? list.get(0) : null;
	}
}
