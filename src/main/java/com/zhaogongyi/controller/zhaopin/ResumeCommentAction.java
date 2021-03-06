package com.zhaogongyi.controller.zhaopin;
	
	
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhaogongyi.controller.common.BaseAction;
import com.zhaogongyi.model.AcctInfo;
import com.zhaogongyi.service.common.ResumeCommentService;
import com.zhaogongyi.util.Constants;
	
@Controller
@RequestMapping("/resume")
public class ResumeCommentAction extends BaseAction {
	private static final Log log = LogFactory.getLog(ResumeCommentAction.class);
	@Resource
	private ResumeCommentService resumeCommentService;
	
@ResponseBody
@RequestMapping("/comment")
public void addComment(
	@RequestParam(required=true) Integer resumeId,
	@RequestParam(required=true) String content,
	HttpServletRequest req
			) {
		
		AcctInfo loginUser = (AcctInfo) req.getSession().getAttribute(Constants.LOGIN_SESSION_KEY);
		int acctId = loginUser.getAcctId();
		resumeCommentService.addResumeComment(resumeId, content, acctId);
	}   
}		
	