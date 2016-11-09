package com.zhaogongyi.controller.common;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.Writer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zhaogongyi.model.AcctInfo;
import com.zhaogongyi.service.common.RegisterService;
import com.zhaogongyi.util.Constants;
@Controller
@RequestMapping("/reg")
public class RegisterAction extends BaseAction{
	private static final Log log = LogFactory.getLog(RegisterAction.class);
	
	@Resource
	private RegisterService registerService;
	
	/*
	 * 到登录界面
	 */
	@RequestMapping("/login")
	public ModelAndView mylogin() {
		ModelAndView modelAndView = new ModelAndView("register/login");
		return modelAndView;
	}
	
	@RequestMapping("/logout")
	public void logout(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		HttpSession s = req.getSession();
		s.removeAttribute(Constants.LOGIN_SESSION_KEY);
		s.invalidate();
		s = null;
		resp.sendRedirect(req.getContextPath());
	}
	
	/**
	 * 到达注册页面
	 */
	@RequestMapping("/register")
	public ModelAndView toRegPage(){
		ModelAndView modelAndView = new ModelAndView("register/register");
		return modelAndView;
	}
	
	/**
	 * 点击注册
	 * @return
	 */
	@RequestMapping("/registerUser")
	public ModelAndView register(AcctInfo acctInfo) {
		// 增加用户
		registerService.addUser(acctInfo);
		ModelAndView modelAndView = new ModelAndView(SUCCESS_HOME);
		modelAndView.addObject("hint", "注册用户成功!");
		modelAndView.addObject("time", 5000);
		modelAndView.addObject("url", "/");
		return modelAndView;
	}
	
	/**
	 * 判断帐号、邮箱等是否唯一
	 * @throws Exception 
	 */
	@ResponseBody
	@RequestMapping("/isUnique")
	public Object isUnique(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String type = java.net.URLDecoder.decode(req.getParameter("type"), "UTF-8");
		String value = java.net.URLDecoder.decode(req.getParameter("value"), "UTF-8");
		if (registerService.isUnique(type, value)) {
			return "true";//唯一
		} else {
			return "false";//唯一
		}
	}
	
	/**
	 * 使用用户名、邮箱和密码登录
	 * @return
	 */
	@RequestMapping("/trylogin")
	public void login(AcctInfo acctInfo, HttpServletRequest req, HttpServletResponse resp) {
		AcctInfo example = new AcctInfo();
		example.setAcctName(acctInfo.getAcctName());
		example.setEmail(acctInfo.getEmail());
		example.setPassword(acctInfo.getPassword());
		Object retObj = registerService.findAcctInfoByPwd(example);
		PrintWriter writer = null;
		try {
			writer = resp.getWriter();
		} catch (IOException e) {
			log.error("登录获取PrintWriter失败", e);
			e.printStackTrace();
		}
		if (retObj.toString().equals("-1")) {
			writer.print("NO_ACCT");
			writer.flush();
			writer.close();
			return;
		} else if (retObj.toString().equals("-2")) {
			writer.print("WRONG_PWD");
			writer.flush();
			writer.close();
			return;
		}
		
		AcctInfo foundAcct = (AcctInfo) retObj;
		if (foundAcct != null) {
			acctInfo = foundAcct;
			req.getSession().setAttribute(Constants.LOGIN_SESSION_KEY, acctInfo);
			writer.print("SUCCESS");
			writer.flush();
			writer.close();
			return;
		} 
		writer.print("UNKNOWN_ERROR");
		writer.flush();
		writer.close();
	}
	
	@RequestMapping("/validpwd")
	public void validatePwd(AcctInfo acct, HttpServletResponse resp) throws Exception {
		AcctInfo acctInfo = new AcctInfo();
		acctInfo.setAcctName(acct.getAcctName());
		acctInfo.setPassword(acct.getPassword());
		Object retObj = registerService.findAcctInfoByPwd(acctInfo);
		PrintWriter out = resp.getWriter();
		if (retObj != null && retObj instanceof AcctInfo) {
			out.print("SUCCESS");
			out.flush();
			out.close();
		} else {
			out.print("FAIL");
			out.flush();
			out.close();
		}
	}
	
}
