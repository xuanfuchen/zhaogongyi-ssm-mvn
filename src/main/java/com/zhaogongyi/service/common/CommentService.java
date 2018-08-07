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
import com.zhaogongyi.model.CommentInfo;
import com.zhaogongyi.model.CommentInfoExample;
import com.zhaogongyi.model.vo.CommentInfoVO;
import com.zhaogongyi.util.DateUtil;

@Service
@Transactional
public class CommentService {
	private static final Log log = LogFactory.getLog(CommentService.class);
	@Resource
	private DaoUtil daoUtil;
	
	public void addComment(Integer workId, String content, Integer acctId) {
		// 在这里插入一条数据到数据库表
		CommentInfo record = new CommentInfo();
		record.setWorkId(workId);
		record.setContent(content);
		Date createTime = DateUtil.now();
		record.setCreateTime(createTime);
		record.setAcctId(acctId);
		daoUtil.commentInfoMapper.insertSelective(record);
		
		
	}
	
	@SuppressWarnings("unused")
	public List<CommentInfoVO> getComment(Integer workId) {
		// 在这里插入一条数据到数据库表
//		CommentInfo get = new CommentInfo();
//		get.setWorkId(workId);
//		get.setContent(content);
//		Date createTime = DateUtil.now();
//		get.setCreateTime(createTime);
//		get.setAcctId(acctId);
//		daoUtil.commentInfoMapper.insertSelective(get);
		
		
		CommentInfoExample example = new CommentInfoExample();
		example.setOrderByClause("create_time DESC");
		example.createCriteria().andWorkIdEqualTo(workId);
		List<CommentInfo> resultList = daoUtil.commentInfoMapper.selectByExample(example );
		
		List<CommentInfoVO> resultList2 = new ArrayList<>();
		for (CommentInfo commentInfo : resultList) {
			CommentInfoVO v = new CommentInfoVO();
			v.setAcctId(commentInfo.getAcctId());
			v.setContent(commentInfo.getContent());
			Date createTime = DateUtil.now();
			v.setCreateTime(commentInfo.getCreateTime());
			v.setWorkId(commentInfo.getWorkId());
			///
			//
			int acctId = commentInfo.getAcctId();
			// 再去库查出acctName
			AcctInfo acctInfo = daoUtil.acctInfoMapper.selectByPrimaryKey(acctId);
			v.setAcctName(acctInfo == null ?"null": acctInfo.getAcctName());
			
			resultList2.add(v);
		}
		
		return resultList2;
		
	}

}
