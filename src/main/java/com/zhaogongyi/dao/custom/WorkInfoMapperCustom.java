package com.zhaogongyi.dao.custom;

import java.util.List;
import java.util.Map;

public interface WorkInfoMapperCustom {
    List<Map<String,Object>> selectJobPagination(Map<String,Object> param);
    int selectJobPaginationTotal(Map<String,Object> param);

    List<Map<String,Object>> selectJobsByAcctIdPagination(Map<String,Object> param);
    int selectJobsByAcctIdPaginationTotal(Map<String,Object> param);
}