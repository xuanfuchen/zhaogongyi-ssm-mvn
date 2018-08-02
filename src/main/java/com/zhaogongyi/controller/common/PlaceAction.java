package com.zhaogongyi.controller.common;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhaogongyi.model.Place;
import com.zhaogongyi.service.common.PlaceService;
@Controller
@RequestMapping("/place")
public class PlaceAction {
	private static final Log log = LogFactory.getLog(PlaceAction.class);
	@Resource
	private PlaceService placeService;
	
	// ajax请求，随着选择的城市改变地区下拉框
	@RequestMapping("/list/{id}")
	@ResponseBody
	public List<Place> chgWithSelectedCity(@PathVariable String id, HttpServletRequest req, HttpServletResponse resp) throws Exception {
		List<Place> list = placeService.getPlacesContainsCity(req, id, true);
		System.out.println(req.getContextPath());
		System.out.println(req.getQueryString());
		System.out.println(req.getParameter("data"));
		BufferedReader in = new BufferedReader(new InputStreamReader(req.getInputStream(),"UTF-8")); 
		String line = null;   
        StringBuffer content = new StringBuffer();   
		while ((line = in.readLine()) != null) {
            content.append(line);   
        } 
		System.out.println("content-->" + content);
		return list;
	}
	
	
	
	@RequestMapping("/test1")
	@ResponseBody
	public Object test1(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		List<Place> list = placeService.getPlacesContainsCity(req, "4401", true);
		String data = req.getParameter("json_data");
		System.out.println("data-->" + data);
		return list;
	}
}