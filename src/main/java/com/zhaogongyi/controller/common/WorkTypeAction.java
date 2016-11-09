package com.zhaogongyi.controller.common;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zhaogongyi.model.Place;
import com.zhaogongyi.model.vo.WorkTypeCountVO;
import com.zhaogongyi.service.common.PlaceService;
import com.zhaogongyi.service.common.WorkTypeService;

@Controller
@RequestMapping("/worktype")
public class WorkTypeAction extends BaseAction {
	private static final Log log = LogFactory.getLog(WorkTypeAction.class);
	@Resource
	private WorkTypeService workTypeService;
	@Resource
	private PlaceService placeService;
	List<WorkTypeCountVO> workTypeCountVoList;
	private List<WorkTypeCountVO> workTypeList;

	@RequestMapping("/list/{id}")
	public ModelAndView toWorkTypePage(@PathVariable String id, HttpServletRequest req) {
		Map<String, List<WorkTypeCountVO>> jobsNumMap = workTypeService.listWorkTypes(req, true);
		req.setAttribute("jzgd_jobs", jobsNumMap.get("jzgd"));
		req.setAttribute("sczz_jobs", jobsNumMap.get("sczz"));
		req.setAttribute("fwhqxs_jobs", jobsNumMap.get("fwhqxs"));

		req.setAttribute("jzgd_wkrs", jobsNumMap.get("jzgd"));// 由于不查数量，可以不区分
		req.setAttribute("sczz_wkrs", jobsNumMap.get("sczz"));
		req.setAttribute("fwhqxs_wkrs", jobsNumMap.get("fwhqxs"));
		Place curPlace = placeService.getPlaceByPlaceId(id);
		List<Place> curPlaceList = placeService.getPlacesContainsCity(req, id, true);
		ModelAndView modelAndView = new ModelAndView("../../commons/jsp/changeCity");
		modelAndView.addObject("curPlace", curPlace);
		modelAndView.addObject("curPlaceList", curPlaceList);
		return modelAndView;
	}

	// 构造选择工种面板
	@RequestMapping("/list")
	public ModelAndView listWorkType(HttpServletRequest req) {
		ModelAndView modelAndView = new ModelAndView("../../commons/jsp/include/workType");
		workTypeList = workTypeService.listWorkType(req, true);
		modelAndView.addObject("workTypeList", workTypeList);
		return modelAndView;
	}


}
