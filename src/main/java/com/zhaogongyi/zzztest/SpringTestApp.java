package com.zhaogongyi.zzztest;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zhaogongyi.dao.common.BaseDaoTool;
import com.zhaogongyi.dao.common.DaoUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-mybatis.xml", "classpath:spring-mvc.xml", })
public class SpringTestApp {
	@Resource
	private DaoUtil daoUtil;
	@Resource
	BaseDaoTool baseDaoTool;
	//
	@Test
	public void test1() throws Exception {
		
		baseDaoTool.getSqlSessionTemplate().update("");
	}


}
