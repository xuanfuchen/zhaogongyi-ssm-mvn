package com.zhaogongyi.controller.qiuzhi;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zhaogongyi.model.Place;
import com.zhaogongyi.model.ResumeInfo;
import com.zhaogongyi.model.WorkType;
import com.zhaogongyi.model.vo.QueryCond;
import com.zhaogongyi.model.vo.WorkTypeCountVO;
import com.zhaogongyi.commons.pager.ListPage;
import com.zhaogongyi.commons.pager.Pager;
import com.zhaogongyi.service.common.PlaceService;
import com.zhaogongyi.service.common.WorkTypeService;
import com.zhaogongyi.service.qiuzhi.ResumeService;
import com.zhaogongyi.controller.common.BaseAction;
@Controller
@RequestMapping("/resume")
public class ResumeAction extends BaseAction {
	private static final Log log = LogFactory.getLog(ResumeAction.class);
	@Resource
	private ResumeService resumeService;
	@Resource
	private WorkTypeService workTypeService;
	@Resource
	private PlaceService placeService;


	@RequestMapping("/detail/{id}")
	public ModelAndView toResumeDetail(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("module-qiuzhi/resumeDetail");
		ResumeInfo resumeInfo = resumeService.findById(id);
		modelAndView.addObject("resumeInfo", resumeInfo);
		return modelAndView;
	}

	@RequestMapping("/list/{plid}_{wtid}_{kw}_{p}")
	public ModelAndView toListResumes(@PathVariable String plid, @PathVariable String wtid, @PathVariable String kw, @PathVariable Integer p, HttpServletRequest req) throws UnsupportedEncodingException {
		ModelAndView modelAndView = new ModelAndView("module-qiuzhi/resumeList");
		kw = java.net.URLDecoder.decode(kw, "UTF-8");
		QueryCond q = new QueryCond(plid, wtid, kw, p);
		Pager pager = new Pager(req, p);// 构造分页
		List<WorkTypeCountVO> curWorkTypeList = workTypeService.listWorkTypes(req, wtid, true);
		List<Place> curPlaceList = placeService.getPlacesContainsCity(req, plid, true);
		Place curPlace = placeService.getPlaceByPlaceId(plid);
		WorkType curWorkType = workTypeService.getWorkTypeById(wtid);
		ListPage listPage = resumeService.toListResumes(q, pager);
		
		modelAndView.addObject("q", q);
		modelAndView.addObject("pager", pager);
		modelAndView.addObject("curWorkTypeList", curWorkTypeList);
		modelAndView.addObject("curPlaceList", curPlaceList);
		modelAndView.addObject("curPlace", curPlace);
		modelAndView.addObject("curWorkType", curWorkType);
		modelAndView.addObject("listPage", listPage);
		
		return modelAndView;
	}

	
}
