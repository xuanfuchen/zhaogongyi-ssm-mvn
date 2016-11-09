package com.zhaogongyi.service.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhaogongyi.dao.common.DaoUtil;
import com.zhaogongyi.model.AcctInfo;
import com.zhaogongyi.util.Constants;
import com.zhaogongyi.util.md5.MD5Util;
@Service
@Transactional
public class RegisterService {
	private static final Log log = LogFactory.getLog(RegisterService.class); 
	@Resource
	private DaoUtil daoUtil;
	
	
	/**
	 * 验证唯一性
	 * @param hql
	 * @return
	 * @throws Exception
	 */
	public boolean isUnique(String type, String value) throws Exception {
		List<AcctInfo> resultList = null;
		if (type != null && type.equals("acct")) {
			Map<String, Object> param = new HashMap<>();
			param.put("acctName", value);
			resultList = daoUtil.acctInfoMapperCustom.selectAcctInfoByCond(param );
		} else {
			Map<String, Object> param = new HashMap<>();
			param.put("email", value);
			resultList = daoUtil.acctInfoMapperCustom.selectAcctInfoByCond(param );
		}
		if (resultList == null || resultList.isEmpty()) {
			return true;//唯一
		} 
		return false;
	}
	
	/**
	 * 注册
	 * @param acctInfo
	 * @return
	 */
	public void addUser(AcctInfo acctInfo) {
		try {
			AcctInfo acct = new AcctInfo();
			acct.setAcctName(acctInfo.getAcctName().trim());// acctName需要trim
			acct.setEmail(acctInfo.getEmail());
			acct.setRegDatetime(new java.util.Date());
			String randomStr = MD5Util.getRandomStr();
			acct.setSalt(randomStr);
			acct.setPassword(MD5Util.getMd5Passwd(acctInfo.getPassword().trim(), randomStr));// password需要trim
			acct.setPassword2(acctInfo.getPassword().trim());// 明文密码
			acct.setAcctType(Constants.ACCT_TYPE_NORMAL);
			daoUtil.acctInfoMapper.insert(acct);
		} catch (Exception e) {
			log.error("添加用户失败", e);
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 登录
	 * @param acctInfo
	 * @return   -1无此用户   -2有此用户但密码错误  成功直接返回AcctInfo对象
	 */
	public Object findAcctInfoByPwd(AcctInfo acctInfo) {
		List<AcctInfo> list = null;
		try {
			Map<String, Object> param = new HashMap<>();
			param.put("acctName", acctInfo.getAcctName());
			param.put("email", acctInfo.getEmail());
			list = daoUtil.acctInfoMapperCustom.selectAcctInfoByCond(param );
		} catch (Exception e) {
			log.error("登录查询AcctInfo异常", e);
			e.printStackTrace();
		}
		AcctInfo found = null;
		if (list != null && list.size() > 0) {
			found = list.get(0);
		} else {
			return "-1";//无此用户
		}
		
		if (found != null) {
			String salt = found.getSalt();
			String password = acctInfo.getPassword();
			if (MD5Util.getMd5Passwd(password, salt).equals(found.getPassword())) {
				return found;
			} else {
				return "-2";//有此用户但密码错误
			}
		} else {
			return null;
		}
	}
	
}





















