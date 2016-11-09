package com.zhaogongyi.service.qiuzhi;

import static com.zhaogongyi.util.CommonUtil.notNullnotEmty;

import java.io.Serializable;
import java.util.ArrayList;
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
import com.zhaogongyi.model.ResumeInfo;
import com.zhaogongyi.model.vo.QueryCond;

@Service
@Transactional
public class ResumeService {
	private static final Log log = LogFactory.getLog(ResumeService.class);
	@Resource
	private DaoUtil daoUtil;

	public ListPage getResumeList(Pager pager, Integer acctId) {
		ListPage listPage = null;
		try {
			Map<String, Object> param = new HashMap<>();
			param.put("acctIdFk", acctId);
			
			// 查总条数
			int total = daoUtil.resumeInfoMapperCustom.selectResumesByAcctIdPaginationTotal(param); // 所有条数
			int pageCount = (total % pager.getPageSize() == 0) ? (total / pager.getPageSize()) : (total / pager.getPageSize() + 1); // 总页数
			pager.setTotal(total);
			pager.setPageCount(pageCount);
			int first = (pager.getThisPage() - 1) * pager.getPageSize();
			int pageSize = pager.getPageSize();
			
			// 加上分页的入参
			param.put("first", first);
			param.put("pageSize", pageSize);
			
			// 查数据
			List<Map<String,Object>> mapList = daoUtil.resumeInfoMapperCustom.selectResumesByAcctIdPagination(param);
			listPage = new ListPage();
			listPage.setPager(pager);
			listPage.setList(mapList);
		} catch (Exception e) {
			log.error("查询简历列表出错", e);
			e.printStackTrace();
		}
		return listPage;
	}


	public ResumeInfo findById(Integer resumeId) {
		ResumeInfo resumeInfo = null;
		try {
			resumeInfo = daoUtil.resumeInfoMapper.selectByPrimaryKey(resumeId);
		} catch (Exception e) {
			log.error("查询ResumeInfo出错", e);
			e.printStackTrace();
		}
		return resumeInfo;
	}

	public boolean updateResumeInfo(ResumeInfo resumeInfo) {
		boolean bo = false;
		try {
			bo = daoUtil.resumeInfoMapper.updateByPrimaryKeySelective(resumeInfo) > 0 ? true : false;
		} catch (Exception e) {
			log.error("修改ResumeInfo出错", e);
			e.printStackTrace();
		}
		return bo;
	}

	public boolean removeResumeInfo(ResumeInfo resumeInfo) {
		boolean bo = false;
		try {
			bo = daoUtil.resumeInfoMapper.deleteByPrimaryKey(resumeInfo.getResumeId()) > 0 ? true : false;
		} catch (Exception e) {
			log.error("删除ResumeInfo出错", e);
			e.printStackTrace();
		}
		return bo;
	}

	public ListPage toListResumes(QueryCond cond, Pager pager) {
		try {
			
			Map<String, Object> param = new HashMap<>();
			param.put("kw", "%" + cond.getKw().trim() + "%");
			param.put("plid", "%" + cond.getPlid() + "%");
			param.put("wtid", "%" + cond.getWtid() + "%");
			
			// 查总条数
			int total = daoUtil.resumeInfoMapperCustom.selectResumePaginationTotal(param); // 所有条数
			int pageCount = (total % pager.getPageSize() == 0) ? (total / pager.getPageSize()) : (total / pager.getPageSize() + 1); // 总页数
			pager.setTotal(total);
			pager.setPageCount(pageCount);
			int first = (pager.getThisPage() - 1) * pager.getPageSize();
			int pageSize = pager.getPageSize();
			
			// 加上分页的入参
			param.put("first", first);
			param.put("pageSize", pageSize);
			
			// 查数据
			List<Map<String,Object>> mapList = daoUtil.resumeInfoMapperCustom.selectResumePagination(param);
			ListPage listPage = new ListPage();
			listPage.setPager(pager);
			listPage.setList(mapList);
			
			return listPage;
		} catch (Exception e) {
			log.error("查询简历列表出错", e);
			e.printStackTrace();
		}
		return null;
	}

	public void addResumeInfo(ResumeInfo resumeInfo) {
		try {
			daoUtil.resumeInfoMapper.insert(resumeInfo);
		} catch (Exception e) {
			log.error("保存ResumeInfo出错", e);
			e.printStackTrace();
		}
	}

	public boolean editResumeInfo(ResumeInfo resumeInfo) {
		boolean bo = false;
		try {
			bo = daoUtil.resumeInfoMapper.updateByPrimaryKeySelective(resumeInfo) > 0 ? true : false;
		} catch (Exception e) {
			log.error("保存ResumeInfo出错", e);
			e.printStackTrace();
		}
		return bo;
	}

	// 使用set的好处比字段值散布在jsp中(使用hidden)的好处在于容易debug
	public void adaptResumeInfo(ResumeInfo found, ResumeInfo newValue) {
		if (notNullnotEmty(newValue.getResumeTitle())) {
			found.setResumeTitle(newValue.getResumeTitle());
		}
		if (notNullnotEmty(newValue.getAge())) {
			found.setAge(newValue.getAge());
		}
		if (notNullnotEmty(newValue.getCellPhone())) {
			found.setCellPhone(newValue.getCellPhone());
		}
		if (notNullnotEmty(newValue.getJiguan())) {
			found.setJiguan(newValue.getJiguan());
		}
		if (notNullnotEmty(newValue.getEducation())) {
			found.setEducation(newValue.getEducation());
		}
		if (notNullnotEmty(newValue.getTitle())) {
			found.setTitle(newValue.getTitle());
		}
		if (notNullnotEmty(newValue.getEmail())) {
			found.setEmail(newValue.getEmail());
		}
		if (notNullnotEmty(newValue.getWorkTypeName())) {
			found.setWorkTypeName(newValue.getWorkTypeName());
		}
		// 这个字段比较特殊：一整型，二是可填可不填。如果原来有值，后来修改为不填，则传入的值会是null，这个时候不应该判断非null才set，因为会导致原来若有值，则无法修改为不填。
		found.setSlyBegin(newValue.getSlyBegin());
		found.setSlyEnd(newValue.getSlyEnd());
		if (notNullnotEmty(newValue.getExprTime())) {
			found.setExprTime(newValue.getExprTime());
		}
		if (notNullnotEmty(newValue.getIntroduce())) {
			found.setIntroduce(newValue.getIntroduce());
		}
	}

}
