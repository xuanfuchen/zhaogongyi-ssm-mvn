package com.zhaogongyi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhaogongyi.dao.common.DaoUtil;
import com.zhaogongyi.model.WorkInfo;

@Controller
public class TestController {
	@Resource
	private DaoUtil daoUtil;
	
	@ResponseBody
	@RequestMapping("/test")
	public Object toListJobs(HttpServletRequest req, HttpServletResponse resp) {
		Map<String, Object> param = new HashMap<>();
		param.put("kw", "%%");
		param.put("plid", "440103");
		param.put("wtid", "0301");
		param.put("first", 0);
		param.put("pageSize", 15);
		List l = daoUtil.workInfoMapperCustom.selectJobPagination(param);
		
		int total = daoUtil.workInfoMapperCustom.selectJobPaginationTotal(param);
		
		Map map = new HashMap<>();
		map.put("list", l);
		map.put("total", total);
		
		
		return map;
	}
}
