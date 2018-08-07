package com.zhaogongyi.controller.zhaopin;
		
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zhaogongyi.commons.pager.ListPage;
import com.zhaogongyi.commons.pager.Pager;
import com.zhaogongyi.controller.common.BaseAction;
import com.zhaogongyi.model.CompanyInfo;
import com.zhaogongyi.model.Place;
import com.zhaogongyi.model.WorkInfo;
import com.zhaogongyi.model.WorkType;
import com.zhaogongyi.model.vo.CommentInfoVO;
import com.zhaogongyi.model.vo.QueryCond;
import com.zhaogongyi.model.vo.WorkTypeCountVO;
import com.zhaogongyi.service.common.CommentService;
import com.zhaogongyi.service.common.PlaceService;
import com.zhaogongyi.service.common.WorkTypeService;
import com.zhaogongyi.service.zhaopin.CompanyService;
import com.zhaogongyi.service.zhaopin.JobService;
import com.zhaogongyi.util.CommonUtil;
		
@Controller
@RequestMapping("/job")
public class JobAction extends BaseAction {
	private static final Log log = LogFactory.getLog(JobAction.class);
	@Resource
	private JobService jobService;
	@Resource
	private WorkTypeService workTypeService;
	@Resource
	private PlaceService placeService;
	@Resource
	private CompanyService companyService;
	@Resource
	private CommentService commentService;
		
		
	@RequestMapping("/detail/{id}")
	public ModelAndView toJobDetail(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("module-zhaopin/jobDetail");
		WorkInfo jobDetail = jobService.findWorkInfoById(id);
		List<CommentInfoVO> commentInfoList = commentService.getComment(id);
		
		
		String dutyReq = jobDetail.getDutyReq();
		if (dutyReq != null) {
			dutyReq = CommonUtil.articleFormat(dutyReq);
		}
		jobDetail.setDutyReq(dutyReq);// 格式化
		
		
		CompanyInfo companyInfo = companyService.findCompanyInfoById(jobDetail.getCompanyIdFk());
		
		
		String remark = companyInfo.getRemark();
		if (remark != null) {
			remark = CommonUtil.articleFormat(remark);
		}
		companyInfo.setRemark(remark);// 格式化
		
		List<WorkInfo> relatedJobs = jobService.findWorkInfoByCompanyId(jobDetail.getCompanyIdFk());
		
		modelAndView.addObject("workInfo", jobDetail);
		modelAndView.addObject("company", companyInfo);
		modelAndView.addObject("workInfoList", relatedJobs);
		modelAndView.addObject("commentInfoList", commentInfoList);
		// 把評論信息查出來，放到modelAdndVIew里，然后前端页面jsp进行展示
		
		return modelAndView;
	}	
		
	@RequestMapping("/list/{plid}_{wtid}_{kw}_{p}")
	public ModelAndView toListJobs(@PathVariable String plid, @PathVariable String wtid, @PathVariable String kw, @PathVariable Integer p, HttpServletRequest req) throws UnsupportedEncodingException {
		ModelAndView modelAndView = new ModelAndView("module-zhaopin/jobList");
		kw = java.net.URLDecoder.decode(kw, "UTF-8");
		
		QueryCond q = new QueryCond(plid, wtid, kw, p);
		Pager pager = new Pager(req, q.getP());// 构造分页
		ListPage listPage = jobService.listMyJobs(q, pager);
		List<WorkTypeCountVO> curWorkTypeList = workTypeService.listWorkTypes(req, q.getWtid(), true);
		List<Place> curPlaceList = placeService.getPlacesContainsCity(req, q.getPlid(), true);
		Place curPlace = placeService.getPlaceByPlaceId(q.getPlid());
		WorkType curWorkType = workTypeService.getWorkTypeById(q.getWtid());
		
		modelAndView.addObject("pager", pager);
		modelAndView.addObject("listPage", listPage);
		modelAndView.addObject("curWorkTypeList", curWorkTypeList);
		modelAndView.addObject("curPlaceList", curPlaceList);
		modelAndView.addObject("curPlace", curPlace);
		modelAndView.addObject("curWorkType", curWorkType);
		modelAndView.addObject("q", q);
		
		return modelAndView;
	}	
		
}		
		