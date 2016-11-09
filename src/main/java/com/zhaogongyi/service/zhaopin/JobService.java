package com.zhaogongyi.service.zhaopin;

import static com.zhaogongyi.util.CommonUtil.notNullnotEmty;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhaogongyi.commons.pager.ListPage;
import com.zhaogongyi.commons.pager.Pager;
import com.zhaogongyi.dao.common.DaoUtil;
import com.zhaogongyi.model.AcctInfo;
import com.zhaogongyi.model.CompanyInfo;
import com.zhaogongyi.model.CompanyInfoExample;
import com.zhaogongyi.model.WorkInfo;
import com.zhaogongyi.model.WorkInfoExample;
import com.zhaogongyi.model.vo.QueryCond;

@Service
@Transactional
public class JobService {
	private static final Log log = LogFactory.getLog(JobService.class);
	@Resource
	private DaoUtil daoUtil;

	public ListPage getJobList(Pager pager, Integer acctId) {
//		String sql = "select t1.* from WORK_INFO t1,COMPANY_INFO t2 where t1.COMPANY_ID_FK=t2.COMPANY_ID and t2.ACCT_ID_FK=? order by t1.PUBLISH_DATE desc";
		ListPage listPage = null;
		try {
			Map<String, Object> param = new HashMap<>();
			param.put("acctIdFk", acctId);
			
			// 查总条数
			int total = daoUtil.workInfoMapperCustom.selectJobsByAcctIdPaginationTotal(param); // 所有条数
			int pageCount = (total % pager.getPageSize() == 0) ? (total / pager.getPageSize()) : (total / pager.getPageSize() + 1); // 总页数
			pager.setTotal(total);
			pager.setPageCount(pageCount);
			int first = (pager.getThisPage() - 1) * pager.getPageSize();
			int pageSize = pager.getPageSize();
			
			// 加上分页的入参
			param.put("first", first);
			param.put("pageSize", pageSize);
			
			// 查数据
			List<Map<String,Object>> mapList = daoUtil.workInfoMapperCustom.selectJobsByAcctIdPagination(param);
			listPage = new ListPage();
			listPage.setPager(pager);
			listPage.setList(mapList);
			
			return listPage;
		} catch (Exception e) {
			log.error("查询工作列表出错", e);
			e.printStackTrace();
		}
		return listPage;
	}

//	public ListPage getAdminJobList(Pager pager, AdminQueryCond cond) {
//		String sql = "select * from WORK_INFO ";
//		String where = " where 1=1 ";
//		List<Object> params = new ArrayList<Object>();
//		if (notNullnotEmty(cond.getTitle())) {
//			where += " and TITLE like ? ";
//			params.add("%" + cond.getTitle() + "%");
//		}
//		if (notNullnotEmty(cond.getPlaceId())) {
//			where += " and PLACE_ID_FK like ? ";
//			params.add(cond.getPlaceId() + "%");
//		}
//		if (notNullnotEmty(cond.getPublishDateBegin())) {
//			where += " and PUBLISH_DATE >= ? ";
//			params.add(cond.getPublishDateBegin());
//		}
//		if (notNullnotEmty(cond.getPublishDateEnd())) {
//			where += " and PUBLISH_DATE <= dateadd(d,1,?) ";
//			params.add(cond.getPublishDateEnd());
//		}
//		if (notNullnotEmty(cond.getWorkId())) {
//			where += " and WORK_ID=? ";
//			params.add(cond.getWorkId());
//		}
//		if (notNullnotEmty(cond.getCompanyName())) {
//			where += " and COMPANY_NAME like ? ";
//			params.add("%" + cond.getCompanyName() + "%");
//		}
//		ListPage listPage = null;
//		String orderClause = " order by PUBLISH_DATE desc ";
//		sql += where += orderClause;
//		try {
//			listPage = jobDao.getListPage(sql, params.toArray(), pager);
//		} catch (Exception e) {
//			log.error("查询工作列表出错", e);
//			e.printStackTrace();
//		}
//		return listPage;
//	}
//
//	public ListPage getAdminCompanyList(Pager pager, AdminQueryCond cond) {
//		String sql = "select * from COMPANY_INFO ";
//		String where = " where 1=1 ";
//		List<Object> params = new ArrayList<Object>();
//		if (notNullnotEmty(cond.getCompanyId())) {
//			where += " and COMPANY_ID=? ";
//			params.add(cond.getCompanyId());
//		}
//		if (notNullnotEmty(cond.getCompanyName())) {
//			where += " and NAME like ? ";
//			params.add("%" + cond.getCompanyName() + "%");
//		}
//		if (notNullnotEmty(cond.getRemark())) {
//			where += " and REMARK like ? ";
//			params.add("%" + cond.getRemark() + "%");
//		}
//		String orderClause = " order by COMPANY_ID desc ";
//		sql += where += orderClause;
//		ListPage listPage = null;
//		try {
//			listPage = jobDao.getListPage(sql, params.toArray(), pager);
//		} catch (Exception e) {
//			log.error("查询工作列表出错", e);
//			e.printStackTrace();
//		}
//		return listPage;
//	}

	public WorkInfo findWorkInfoById(Integer workId) {
		WorkInfo workInfo = null;
		try {
			workInfo = daoUtil.workInfoMapper.selectByPrimaryKey(workId);
		} catch (Exception e) {
			log.error("查询WorkInfo出错", e);
			e.printStackTrace();
		}
		return workInfo;
	}

	public List<WorkInfo> findWorkInfoByCompanyId(Integer companyId) {
		List<WorkInfo> workInfoList = null;
		try {
			WorkInfoExample example = new WorkInfoExample();
			example.createCriteria().andCompanyIdFkEqualTo(companyId).andDisFlagEqualTo((byte)1);
			example.setOrderByClause("publish_date desc");
			workInfoList = daoUtil.workInfoMapper.selectByExampleWithBLOBs(example);
		} catch (Exception e) {
			log.error("查询同一公司的所有工作出错", e);
			e.printStackTrace();
		}
		return workInfoList;
	}

	/* 管理员可以查出所有，包括隐藏的 */
	public List<WorkInfo> findAddWorkInfoByCompanyId(Integer companyId) {
		List<WorkInfo> workInfoList = null;
		try {
			WorkInfoExample example = new WorkInfoExample();
			example.createCriteria().andCompanyIdFkEqualTo(companyId);
			example.setOrderByClause("publish_date desc");
			workInfoList = daoUtil.workInfoMapper.selectByExampleWithBLOBs(example);// 把text字段的记得要select出来
		} catch (Exception e) {
			log.error("查询同一公司的所有工作出错", e);
			e.printStackTrace();
		}
		return workInfoList;
	}

	public ListPage listMyJobs(QueryCond cond, Pager pager) {
		try {
			Map<String, Object> param = new HashMap<>();
			param.put("kw", "%" + cond.getKw().trim() + "%");
			param.put("plid", "%" + cond.getPlid() + "%");
			param.put("wtid", "%" + cond.getWtid() + "%");
			
			// 查总条数
			int total = daoUtil.workInfoMapperCustom.selectJobPaginationTotal(param); // 所有条数
			int pageCount = (total % pager.getPageSize() == 0) ? (total / pager.getPageSize()) : (total / pager.getPageSize() + 1); // 总页数
			pager.setTotal(total);
			pager.setPageCount(pageCount);
			int first = (pager.getThisPage() - 1) * pager.getPageSize();
			int pageSize = pager.getPageSize();
			
			// 加上分页的入参
			param.put("first", first);
			param.put("pageSize", pageSize);
			
			// 查数据
			List<Map<String,Object>> mapList = daoUtil.workInfoMapperCustom.selectJobPagination(param);
			ListPage listPage = new ListPage();
			listPage.setPager(pager);
			listPage.setList(mapList);
			
			return listPage;
		} catch (Exception e) {
			log.error("查询工作列表出错", e);
			e.printStackTrace();
		}
		return null;
	}

	public CompanyInfo findCompanyInfoByAcctId(AcctInfo acctInfo) {
		CompanyInfo found = null;
		try {
			CompanyInfoExample example = new CompanyInfoExample();
			example.createCriteria().andAcctIdFkEqualTo(acctInfo.getAcctId());
			List<CompanyInfo> retList = daoUtil.companyInfoMapper.selectByExampleWithBLOBs(example);// 把text字段的记得要select出来
			
			if (retList != null && retList.size() > 0) {
				found = retList.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("查找公司信息出错", e);
		}
		return found;
	}

	public CompanyInfo findCompanyInfoById(Serializable cid) {
		CompanyInfo found = null;
		try {
			found = daoUtil.companyInfoMapper.selectByPrimaryKey(Integer.parseInt((String) cid));
		} catch (Exception e) {
			e.printStackTrace();
			log.error("通过ID查找公司信息出错", e);
		}
		return found;
	}

	public CompanyInfo adaptCompanyInfo(CompanyInfo db, CompanyInfo in) {
		if (notNullnotEmty(in.getAddr())) {
			db.setAddr(in.getAddr());
		}
		if (notNullnotEmty(in.getComEmail())) {
			db.setComEmail(in.getComEmail());
		}
		if (notNullnotEmty(in.getComPhone())) {
			db.setComPhone(in.getComPhone());
		}
		if (notNullnotEmty(in.getGrand())) {
			db.setGrand(in.getGrand());
		}
		if (notNullnotEmty(in.getName())) {
			db.setName(in.getName());
		}
		if (notNullnotEmty(in.getRemark())) {
			db.setRemark(in.getRemark());
		}
		if (notNullnotEmty(in.getTrade())) {
			db.setTrade(in.getTrade());
		}
		if (notNullnotEmty(in.getType())) {
			db.setType(in.getType());
		}
		return db;
	}

	// 保存CompanyInfo
	public void addCompanyInfo(CompanyInfo company) {
		try {
			daoUtil.companyInfoMapper.insert(company);
		} catch (Exception e) {
			log.error("保存公司信息失败", e);
			e.printStackTrace();
		}
	}

	// 修改CompanyInfo
	public boolean editCompanyInfo(CompanyInfo company) {
		boolean bo = false;
		try {
			bo = daoUtil.companyInfoMapper.updateByPrimaryKeySelective(company) > 0 ? true : false;
		} catch (Exception e) {
			log.error("保存公司信息失败", e);
			e.printStackTrace();
		}
		return bo;
	}

	public WorkInfo adaptWorkInfo(WorkInfo db, WorkInfo in) {
		if (notNullnotEmty(in.getTitle())) {
			db.setTitle(in.getTitle());
		}
		if (notNullnotEmty(in.getNum())) {
			db.setNum(in.getNum());
		}
		if (notNullnotEmty(in.getExprTime())) {
			db.setExprTime(in.getExprTime());
		}
		if (notNullnotEmty(in.getEducation())) {
			db.setEducation(in.getEducation());
		}
		db.setSlyBegin(in.getSlyBegin());
		db.setSlyEnd(in.getSlyEnd());
		if (notNullnotEmty(in.getPlaceName())) {
			db.setPlaceName(in.getPlaceName());
		}
		if (notNullnotEmty(in.getDutyReq())) {
			db.setDutyReq(in.getDutyReq());
		}
		if (notNullnotEmty(in.getContactPerson())) {
			db.setContactPerson(in.getContactPerson());
		}
		if (notNullnotEmty(in.getContactPhone())) {
			db.setContactPhone(in.getContactPhone());
		}
		if (notNullnotEmty(in.getWorkEmail())) {
			db.setWorkEmail(in.getWorkEmail());
		}
		if (in.getPublishDate() != null) {
			db.setPublishDate(in.getPublishDate());
		}
		if (notNullnotEmty(in.getWorkTypeName())) {
			db.setWorkTypeName(in.getWorkTypeName());
		}
		if (in.getDisFlag() != null) {
			db.setDisFlag(in.getDisFlag());
		}
		if (notNullnotEmty(in.getCompanyName())) {
			db.setCompanyName(in.getCompanyName());
		}
		return db;
	}

	public void addWorkInfo(WorkInfo workInfo) {
		try {
			daoUtil.workInfoMapper.insert(workInfo);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("保存WorkInfo出错", e);
		}
	}

	public boolean removeWorkInfo(WorkInfo workInfo) {
		boolean bo = false;
		try {
			bo = daoUtil.workInfoMapper.deleteByPrimaryKey(workInfo.getWorkId())  > 0 ? true : false;
		} catch (Exception e) {
			e.printStackTrace();
			log.error("", e);
		}
		return bo;
	}

	/**
	 * 注意必须传主键
	 * @param workInfo
	 * @return
	 */
	public boolean updateWorkInfo(WorkInfo workInfo) {
		boolean bo = false;
		try {
			bo = daoUtil.workInfoMapper.updateByPrimaryKeySelective(workInfo) > 0 ? true : false;
		} catch (Exception e) {
			e.printStackTrace();
			log.error("", e);
		}
		return bo;
	}

}
