package com.zhaogongyi.dao.custom;

import java.util.List;
import java.util.Map;

import com.zhaogongyi.model.AcctInfo;

public interface AcctInfoMapperCustom {
	List<AcctInfo> selectAcctInfoByCond(Map<String,Object> param);
}