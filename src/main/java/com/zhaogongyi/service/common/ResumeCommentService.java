package com.zhaogongyi.service.common;
	
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
	
import javax.annotation.Resource;
	
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
	
import com.zhaogongyi.dao.common.DaoUtil;
import com.zhaogongyi.model.AcctInfo;
import com.zhaogongyi.model.ResumeCommentInfo;
import com.zhaogongyi.model.ResumeCommentInfoExample;
import com.zhaogongyi.model.ResumeInfo;
import com.zhaogongyi.model.vo.ResumeCommentInfoVO;
import com.zhaogongyi.util.DateUtil;
	
@Service
@Transactional
public class ResumeCommentService {
	private static final Log log = LogFactory.getLog(ResumeCommentService.class);
	@Resource
	private DaoUtil daoUtil;
	 
	public void addResumeComment(Integer resumeId, String content, Integer acctId) {
		// 在这里插入一条数据到数据库表
		ResumeCommentInfo record = new ResumeCommentInfo();
		record.setResumeId(resumeId);
		record.setContent(content);
		Date createTime = DateUtil.now();
		record.setCreateTime(createTime);
		record.setAcctId(acctId);
		daoUtil.resumeCommentInfoMapper.insertSelective(record);
		
	}
	
	@SuppressWarnings("unused")
	public List<ResumeCommentInfoVO> getComment(Integer resumeId) {	
		
		ResumeCommentInfoExample example = new ResumeCommentInfoExample();
		example.setOrderByClause("create_time DESC");
		example.createCriteria().andResumeIdEqualTo(resumeId);// select *from resume_comment_info where result_id=?
		List<ResumeCommentInfo> resultList = daoUtil.resumeCommentInfoMapper.selectByExample(example);
		
		List<ResumeCommentInfoVO> resultListResume = new ArrayList<>();
		for (ResumeCommentInfo commentInfo : resultList) {
			ResumeCommentInfoVO v = new ResumeCommentInfoVO();
			v.setAcctId(commentInfo.getAcctId());
			v.setContent(commentInfo.getContent());
			Date createTime = DateUtil.now();
			v.setCreateTime(commentInfo.getCreateTime());
			v.setResumeId(commentInfo.getResumeId());
			//
			//
			int acctId = commentInfo.getAcctId();
			// 再去库查出acctName
			AcctInfo acctInfo = daoUtil.acctInfoMapper.selectByPrimaryKey(acctId);
			v.setAcctName(acctInfo == null ?"null": acctInfo.getAcctName());
			
			resultListResume.add(v);
		}
		
		return resultListResume;
	}	
	public ResumeInfo findResumeInfoById(Integer resumeId) {
		ResumeInfo resumeInfo = null;
		try {
			resumeInfo = daoUtil.resumeInfoMapper.selectByPrimaryKey(resumeId);
		} catch (Exception e) {
			log.error("查询ResumeInfo出错", e);
			e.printStackTrace();
		}
		return resumeInfo;
	}
}	