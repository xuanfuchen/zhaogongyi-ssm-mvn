package com.zhaogongyi.controller.common;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.zhaogongyi.commons.pager.ListPage;
import com.zhaogongyi.commons.pager.Pager;
import com.zhaogongyi.model.AcctInfo;
import com.zhaogongyi.model.CompanyInfo;
import com.zhaogongyi.model.Place;
import com.zhaogongyi.model.ResumeInfo;
import com.zhaogongyi.model.WorkInfo;
import com.zhaogongyi.model.vo.ChgPwdVO;
import com.zhaogongyi.service.common.AcctInfoService;
import com.zhaogongyi.service.common.PlaceService;
import com.zhaogongyi.service.qiuzhi.ResumeService;
import com.zhaogongyi.service.zhaopin.CompanyService;
import com.zhaogongyi.service.zhaopin.JobService;
import com.zhaogongyi.util.CommonUtil;
import com.zhaogongyi.util.Constants;
import com.zhaogongyi.util.md5.MD5Util;

@Controller
@RequestMapping("/my")
public class UserCenterAction extends BaseAction {
	private static final Log log = LogFactory.getLog(UserCenterAction.class);
	@Resource
	private AcctInfoService acctInfoService;
	@Resource
	private PlaceService placeService;
	@Resource
	private ResumeService resumeService;
	@Resource
	private JobService jobService;
	@Resource
	private CompanyService companyService;


	@RequestMapping("/index")
	public ModelAndView toUserCenter(HttpServletRequest req) {
		ModelAndView modelAndView = new ModelAndView("usercenter/userCenter");
		AcctInfo acctInfo = (AcctInfo) req.getSession().getAttribute(Constants.LOGIN_SESSION_KEY);
		modelAndView.addObject("acctInfo", acctInfo);
		if (acctInfo.getAcctName().equals(Constants.ADMIN_ACCT_NAME)) {
			modelAndView = new ModelAndView("admincenter/adminCenter");
			return modelAndView;
		}
		return modelAndView;
	}

	// ★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★
	// to修改密码jsp
	@RequestMapping("/pwd")
	public ModelAndView toChgPwd(HttpServletRequest req) {
		AcctInfo acctInfo = (AcctInfo) req.getSession().getAttribute(Constants.LOGIN_SESSION_KEY);
		ModelAndView modelAndView = new ModelAndView("usercenter/chgPwd");
		modelAndView.addObject("acctInfo", acctInfo);
		return modelAndView;
	}

	// 修改密码
	@RequestMapping("/chgpwd")
	public ModelAndView chgPwd(ChgPwdVO chgPwdVO, HttpServletRequest req) {
		AcctInfo acctInfo = (AcctInfo) req.getSession().getAttribute(Constants.LOGIN_SESSION_KEY);
		acctInfo.setPassword(MD5Util.getMd5Passwd(chgPwdVO.getNewPassword(), acctInfo.getSalt()));
		acctInfo.setPassword2(chgPwdVO.getNewPassword());
		if (acctInfoService.updateAcctInfo(acctInfo)) {
			req.setAttribute("hint", "密码修改成功！");
			ModelAndView modelAndView = new ModelAndView(SUCCESS);
			return modelAndView;
		}
		return new ModelAndView(FAIL);
	}

	// to修改邮箱jsp
	@RequestMapping("/email")
	public ModelAndView toChgEmail(HttpServletRequest req) {
		AcctInfo acctInfo = (AcctInfo) req.getSession().getAttribute(Constants.LOGIN_SESSION_KEY);
		ModelAndView modelAndView = new ModelAndView("usercenter/chgAcctEmail");
		modelAndView.addObject("acctInfo", acctInfo);
		return modelAndView;
	}

	// 修改邮箱
	@RequestMapping("/chgemail")
	public ModelAndView chgEmail(ChgPwdVO chgPwdVO, HttpServletRequest req) {
		AcctInfo acctInfo = (AcctInfo) req.getSession().getAttribute(Constants.LOGIN_SESSION_KEY);
		acctInfo.setEmail(chgPwdVO.getNewEmail());
		if (acctInfoService.updateAcctInfo(acctInfo)) {
			req.setAttribute("hint", "邮箱修改成功！");
			ModelAndView modelAndView = new ModelAndView(SUCCESS);
			modelAndView.addObject("acctInfo", acctInfo);
			return modelAndView;
		}
		return new ModelAndView(FAIL);
	}

	// ★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★
	// 我的简历列表
	@RequestMapping("/rlist/{pn}")
	public ModelAndView myResumeList(@PathVariable Integer pn, HttpServletRequest req) {
		try {
			AcctInfo acctInfo = (AcctInfo) req.getSession().getAttribute(Constants.LOGIN_SESSION_KEY);
			Pager pager = new Pager();
			pager.setThisPage(pn);
			ListPage listPage = resumeService.getResumeList(pager, acctInfo.getAcctId());
			ModelAndView modelAndView = new ModelAndView("usercenter/qiuzhi/myResumeList");
			modelAndView.addObject("acctInfo", acctInfo);
			modelAndView.addObject("listPage", listPage);
			modelAndView.addObject("pager", pager);
			return modelAndView;
		} catch (Exception e) {
			log.error("查询简历列表失败", e);
			e.printStackTrace();
		}
		return new ModelAndView(FAIL);
	}

	// =============================简历的修改、删除、刷新、显隐 BEGIN
	// (可以测试局部刷新)============================================
	@RequestMapping("/showedit/{rid}")
	public ModelAndView toEditRsm(@PathVariable Integer rid, HttpServletRequest req) {
		ResumeInfo found = resumeService.findById(rid);
		List<Place> cities = placeService.getCityList(req, true);
		Place place = placeService.getPlaceByPlaceId(found.getPlaceIdFk());
		ModelAndView modelAndView = new ModelAndView("usercenter/qiuzhi/myResumeEdit");
		modelAndView.addObject("resumeInfo", found);
		modelAndView.addObject("place", place);
		modelAndView.addObject("cities", cities);
		return modelAndView;
	}

	@RequestMapping(value = "/edit/{rid}", method = RequestMethod.POST)
	public ModelAndView editRsm(@PathVariable Integer rid, ResumeInfo resumeInfo) {
		try {
			ResumeInfo found = resumeService.findById(rid);
			resumeService.adaptResumeInfo(found, resumeInfo);
			boolean bo = resumeService.editResumeInfo(found);
			if (bo) {
				ModelAndView modelAndView = new ModelAndView(SUCCESS);
				modelAndView.addObject("hint", "修改简历成功");
				return modelAndView;
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("修改简历出错", e);
		}
		return new ModelAndView(FAIL);
	}

	@RequestMapping("/del/{rid}")
	public ModelAndView delRsm(@PathVariable Integer rid, HttpServletRequest req) throws Exception {
		try {
			ResumeInfo found = resumeService.findById(rid);
			if (resumeService.removeResumeInfo(found)) {
				ModelAndView modelAndView = new ModelAndView(SUCCESS);
				return modelAndView;
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("删除简历出错", e);
		}
		return new ModelAndView(FAIL);
	}

	@RequestMapping("/refresh/{rid}")
	public ModelAndView refreshRsm(@PathVariable Integer rid, HttpServletRequest req, Pager pager) throws Exception {
		ResumeInfo found = resumeService.findById(rid);
		found.setPublishDate(new java.util.Date());
		if (resumeService.updateResumeInfo(found)) {
			ModelAndView modelAndView = new ModelAndView("redirect:/my/rlist/" + pager.getThisPage());
			return modelAndView;
		}
		return new ModelAndView(FAIL);
	}

	@RequestMapping("/open/{rid}")
	public ModelAndView openRsm(@PathVariable Integer rid, HttpServletRequest req, Pager pager) throws Exception {
		ResumeInfo found = resumeService.findById(rid);
		found.setDisFlag(Constants.DIS_FLAG_PUBLIC);
		if (resumeService.updateResumeInfo(found)) {
			ModelAndView modelAndView = new ModelAndView("redirect:/my/rlist/" + pager.getThisPage());
			return modelAndView;
		}
		return new ModelAndView(FAIL);
	}

	@RequestMapping("/hide/{rid}")
	public ModelAndView hideRsm(@PathVariable Integer rid, HttpServletRequest req, Pager pager) throws Exception {
		ResumeInfo found = resumeService.findById(rid);
		found.setDisFlag(Constants.DIS_FLAG_PRIVATE);
		if (resumeService.updateResumeInfo(found)) {
			ModelAndView modelAndView = new ModelAndView("redirect:/my/rlist/" + pager.getThisPage());
			return modelAndView;
		}
		return new ModelAndView(FAIL);
	}

	@RequestMapping("/view/{rid}")
	public ModelAndView viewRsm(@PathVariable Integer rid, HttpServletRequest req) {
		ResumeInfo found = resumeService.findById(rid);
		String placeId = found.getPlaceIdFk();
		Place curCity = placeService.getCityByPlaceId(placeId);
		String displayWorkPlace;
		if (placeId.length() == 4) {
			displayWorkPlace = curCity.getPlaceName() + "-不限地区";
		} else {
			displayWorkPlace = curCity.getPlaceName() + "-" + found.getPlaceName();
		}
		ModelAndView modelAndView = new ModelAndView("usercenter/qiuzhi/myResumeView");
		modelAndView.addObject("resumeInfo", found);
		modelAndView.addObject("displayWorkPlace", displayWorkPlace);
		return modelAndView;
	}

	// =============================简历的修改、删除、刷新、显隐
	// END============================================
	// to添加简历jsp
	@RequestMapping("/addresume")
	public ModelAndView toAddMyResume(HttpServletRequest req) {
		List<Place> cities = placeService.getCityList(req, true);
		AcctInfo acctInfo = (AcctInfo) req.getSession().getAttribute(Constants.LOGIN_SESSION_KEY);
		ModelAndView modelAndView = new ModelAndView("usercenter/qiuzhi/myResumeAdd");
		modelAndView.addObject("resumeInfo", new ResumeInfo());
		modelAndView.addObject("acctInfo", acctInfo);
		modelAndView.addObject("cities", cities);
		return modelAndView;
	}

	// 保存发布简历
	public ModelAndView addMyResume(HttpServletRequest req, ResumeInfo resumeInfo) {
		try {
			resumeInfo.setDisFlag(Constants.DIS_FLAG_PUBLIC);// 公开
			resumeInfo.setPublishDate(new java.util.Date());
			resumeService.addResumeInfo(resumeInfo);
			req.setAttribute("hint", "发布简历成功");
			ModelAndView modelAndView = new ModelAndView(SUCCESS);
		} catch (Exception e) {
			log.error("增加简历信息出错", e);
			e.printStackTrace();
		}
		return new ModelAndView(FAIL);
	}

	// ★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★
	// 我发布的工作列表
	@RequestMapping("/jlist/{pn}")
	public ModelAndView myJobList(@PathVariable Integer pn, HttpServletRequest req) {
		try {
			AcctInfo acctInfo = (AcctInfo) req.getSession().getAttribute(Constants.LOGIN_SESSION_KEY);
			Pager pager = new Pager();
			pager.setThisPage(pn);
			ListPage listPage = jobService.getJobList(pager, acctInfo.getAcctId());
			ModelAndView modelAndView = new ModelAndView("usercenter/zhaopin/myJobList");
			modelAndView.addObject("acctInfo", acctInfo);
			modelAndView.addObject("listPage", listPage);
			modelAndView.addObject("pager", pager);
			return modelAndView;
		} catch (Exception e) {
			log.error("查询简历列表失败", e);
			e.printStackTrace();
		}
		return new ModelAndView(FAIL);
	}

	// to公司信息jsp(没则新增，有则显示)
	@RequestMapping("/cinfo")
	public ModelAndView toCompanyInfo(HttpServletRequest req) {
		try {
			AcctInfo acctInfo = (AcctInfo) req.getSession().getAttribute(Constants.LOGIN_SESSION_KEY);
			CompanyInfo found = jobService.findCompanyInfoByAcctId(acctInfo);
			if (found != null) {
				String remark = found.getRemark();
				if (remark != null) {
					remark = CommonUtil.articleFormat(remark);
				}
				found.setRemark(remark);
				
				ModelAndView modelAndView = new ModelAndView("usercenter/zhaopin/companyInfoView");
				modelAndView.addObject("company", found);
				return modelAndView;
			}
			CompanyInfo newInfo = new CompanyInfo();
			newInfo.setComEmail(acctInfo.getEmail());

			ModelAndView modelAndView = new ModelAndView("usercenter/zhaopin/companyInfoAdd");
			modelAndView.addObject("company", newInfo);
			return modelAndView;
		} catch (Exception e) {
			e.printStackTrace();
			log.error("未知错误", e);
		}
		return new ModelAndView(FAIL);
	}

	// 新增公司信息
	public ModelAndView newCompanyInfo(HttpServletRequest req, CompanyInfo company) {
		try {
			CompanyInfo companyIn = new CompanyInfo();
			jobService.adaptCompanyInfo(companyIn, company);
			jobService.addCompanyInfo(companyIn);
			req.setAttribute("hint", "新增公司资料成功");
			ModelAndView modelAndView = new ModelAndView(SUCCESS);
			return modelAndView;
		} catch (Exception e) {
			log.error("保存公司信息出错", e);
			e.printStackTrace();
		}
		return new ModelAndView(FAIL);
	}

	// to修改公司信息jsp
	public ModelAndView toEditCompanyInfo(HttpServletRequest req) {
		try {
			String cid = req.getParameter("cid");
			CompanyInfo found = jobService.findCompanyInfoById(cid);
			
			String remark = found.getRemark();
			if (remark != null) {
				remark = CommonUtil.articleFormat(remark);
			}
			found.setRemark(remark);
			
			ModelAndView modelAndView = new ModelAndView(SUCCESS);
			modelAndView.addObject("company", found);
			return modelAndView;
		} catch (Exception e) {
			e.printStackTrace();
			log.error("", e);
		}
		return new ModelAndView(FAIL);
	}

	// 修改公司信息
	public ModelAndView editCompanyInfo(HttpServletRequest req, CompanyInfo company) {
		try {
			String cid = req.getParameter("cid");
			CompanyInfo found = jobService.findCompanyInfoById(cid);
			jobService.adaptCompanyInfo(found, company);
			boolean bo = jobService.editCompanyInfo(found);
			if (bo) {
				req.setAttribute("hint", "修改公司资料成功");
				ModelAndView modelAndView = new ModelAndView(SUCCESS);
				return modelAndView;
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("修改公司信息出错", e);
		}
		return new ModelAndView(FAIL);
	}

	// to发布工作jsp
	public ModelAndView toIssueJob(HttpServletRequest req) {
		AcctInfo acctInfo = (AcctInfo) req.getSession().getAttribute(Constants.LOGIN_SESSION_KEY);
		WorkInfo workInfo = new WorkInfo();
		workInfo.setWorkEmail(acctInfo.getEmail());
		CompanyInfo found = jobService.findCompanyInfoByAcctId(acctInfo);
		List<Place> cities = placeService.getCityList(req, true);
		req.setAttribute("cities", cities);
		ModelAndView modelAndView = new ModelAndView(SUCCESS);
		modelAndView.addObject("cities", cities);
		modelAndView.addObject("company", found);
		return modelAndView;
	}

	public ModelAndView issueJob(HttpServletRequest req, WorkInfo workInfo) {
		try {
			workInfo.setDisFlag(Constants.DIS_FLAG_PUBLIC);
			workInfo.setPublishDate(new java.util.Date());
			WorkInfo entity = new WorkInfo();
			jobService.adaptWorkInfo(entity, workInfo);
			jobService.addWorkInfo(entity);
			req.setAttribute("hint", "发布招聘工作成功：\n" + workInfo.getTitle());
			ModelAndView modelAndView = new ModelAndView(SUCCESS);
			return modelAndView;
		} catch (Exception e) {
			e.printStackTrace();
			log.error("发布招聘工作出错", e);
		}
		return new ModelAndView(FAIL);
	}

	// ========================对发布工作的操作
	// BEGIN==============================================================
	@RequestMapping("/toeditjob/{id}")
	public ModelAndView toEditJob(@PathVariable Integer id, HttpServletRequest req) {
		WorkInfo found = jobService.findWorkInfoById(id);
		CompanyInfo company = companyService.findCompanyInfoById(found.getCompanyIdFk());
		List<Place> cities = placeService.getCityList(req, true);
		ModelAndView modelAndView = new ModelAndView(SUCCESS);
		modelAndView.addObject("workInfo", found);
		modelAndView.addObject("company", company);
		modelAndView.addObject("cities", cities);
		return modelAndView;
	}

	public ModelAndView editJob(HttpServletRequest req, WorkInfo workInfo) {
		try {
			Integer wid = Integer.parseInt(req.getParameter("wid"));
			WorkInfo found = jobService.findWorkInfoById(wid);
			jobService.adaptWorkInfo(found, workInfo);
			boolean bo = jobService.updateWorkInfo(found);
			if (bo) {
				req.setAttribute("hint", "修改招聘信息成功");
				ModelAndView modelAndView = new ModelAndView(SUCCESS);
				return modelAndView;
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("修改招聘信息出错", e);
		}
		return new ModelAndView(FAIL);
	}

	public ModelAndView delJob(HttpServletRequest req) throws Exception {
		try {
			Integer wid = Integer.parseInt(req.getParameter("wid"));
			WorkInfo entity = new WorkInfo();
			entity.setWorkId(wid);
			if (jobService.removeWorkInfo(entity)) {
				ModelAndView modelAndView = new ModelAndView(SUCCESS);
				return modelAndView;
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("删除发布工作出错", e);
		}
		return new ModelAndView(FAIL);
	}

	public ModelAndView refreshJob(HttpServletRequest req) throws Exception {
		Integer wid = Integer.parseInt(req.getParameter("wid"));
		WorkInfo found = jobService.findWorkInfoById(wid);
		found.setPublishDate(new java.util.Date());
		if (jobService.updateWorkInfo(found)) {
			ModelAndView modelAndView = new ModelAndView(SUCCESS);
			return modelAndView;
		}
		return new ModelAndView(FAIL);
	}

	public ModelAndView openJob(HttpServletRequest req) throws Exception {
		Integer wid = Integer.parseInt(req.getParameter("wid"));
		WorkInfo found = jobService.findWorkInfoById(wid);
		found.setDisFlag(Constants.DIS_FLAG_PUBLIC);
		if (jobService.updateWorkInfo(found)) {
			ModelAndView modelAndView = new ModelAndView(SUCCESS);
			return modelAndView;
		}
		return new ModelAndView(FAIL);
	}

	public ModelAndView hideJob(HttpServletRequest req) throws Exception {
		Integer wid = Integer.parseInt(req.getParameter("wid"));
		WorkInfo found = jobService.findWorkInfoById(wid);
		found.setDisFlag(Constants.DIS_FLAG_PRIVATE);
		if (jobService.updateWorkInfo(found)) {
			ModelAndView modelAndView = new ModelAndView(SUCCESS);
			return modelAndView;
		}
		return new ModelAndView(FAIL);
	}

	public ModelAndView viewJob(HttpServletRequest req, WorkInfo workInfo) {
		Integer wid = Integer.parseInt(req.getParameter("wid"));
		WorkInfo found = jobService.findWorkInfoById(wid);
		String placeId = found.getPlaceIdFk();
		Place curCity = placeService.getCityByPlaceId(placeId);
		String displayWorkPlace;
		if (placeId.length() == 4) {
			displayWorkPlace = curCity.getPlaceName() + "-不限地区";
		} else {
			displayWorkPlace = curCity.getPlaceName() + "-" + found.getPlaceName();
		}
		CompanyInfo company = companyService.findCompanyInfoById(found.getCompanyIdFk());
		ModelAndView modelAndView = new ModelAndView(SUCCESS);
		modelAndView.addObject("displayWorkPlace", displayWorkPlace);
		modelAndView.addObject("workInfo", workInfo);
		modelAndView.addObject("company", company);
		return modelAndView;
	}

	// ========================对发布工作的操作
	// END==============================================================

}
