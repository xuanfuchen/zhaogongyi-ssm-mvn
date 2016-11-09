package com.zhaogongyi.dao.custom;

import java.util.List;
import java.util.Map;

public interface ResumeInfoMapperCustom {
	List<Map<String,Object>> selectResumesByAcctIdPagination(Map<String,Object> param);
    int selectResumesByAcctIdPaginationTotal(Map<String,Object> param);
    
    List<Map<String,Object>> selectResumePagination(Map<String,Object> param);
    int selectResumePaginationTotal(Map<String,Object> param);
}