package com.zhaogongyi.service.zhaopin;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhaogongyi.dao.common.DaoUtil;
import com.zhaogongyi.model.CompanyInfo;

@Service
@Transactional
public class CompanyService {
	private static final Log log = LogFactory.getLog(CompanyService.class);
	@Resource
	private DaoUtil daoUtil;

	public CompanyInfo findCompanyInfoById(Integer companyId) {
		CompanyInfo companyInfo = null;
		try {
			companyInfo = daoUtil.companyInfoMapper.selectByPrimaryKey(companyId);
		} catch (Exception e) {
			log.error("查询WorkInfo出错", e);
			e.printStackTrace();
		}
		return companyInfo;
	}
}
