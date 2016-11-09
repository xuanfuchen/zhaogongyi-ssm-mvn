package com.zhaogongyi.commons.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;

import com.zhaogongyi.model.AcctInfo;
import com.zhaogongyi.util.Constants;
public class AutoLoginFilter implements Filter {
	
	
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		if (request.getSession().getAttribute(Constants.LOGIN_SESSION_KEY) == null) {
			AcctInfo acctInfo = new AcctInfo();
			acctInfo.setAcctId(1024);
			acctInfo.setAcctName("yonghu");
			acctInfo.setPassword("84670e2c9596235ef1e994bb6e9eadb4");
			acctInfo.setPassword2("123456");
			acctInfo.setEmail("foo@126.com");
			acctInfo.setSalt("84d2b3");
			request.getSession().setAttribute(Constants.LOGIN_SESSION_KEY, acctInfo);
		}
		chain.doFilter(request, response);
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
