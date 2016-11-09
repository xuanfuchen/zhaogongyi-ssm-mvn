package com.zhaogongyi.service.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhaogongyi.dao.common.DaoUtil;
import com.zhaogongyi.model.WorkType;
import com.zhaogongyi.model.WorkTypeExample;
import com.zhaogongyi.model.vo.WorkTypeCountVO;

@Service
@Transactional
public class WorkTypeService {
	private static final Log log = LogFactory.getLog(WorkTypeService.class);
	@Resource
	private DaoUtil daoUtil;
	private static final String PREFIX_WORK_TYPE = "PREFIX_WORK_TYPE";
	private static final String PREFIX_CHOOSE_WORK_TYPE = "PREFIX_CHOOSE_WORK_TYPE";

	/**
	 * 传入父级别的地域id，例如传入4401或4402表示广州或深圳
	 * 
	 * @param req
	 * @param cityType
	 *            传入4401或4402表示广州或深圳
	 * @param forceUpdate
	 *            是否强制更新ServletContext里的数据
	 * @return
	 */
	public Map<String, List<WorkTypeCountVO>> listWorkTypes(HttpServletRequest req, boolean forceUpdate) {
		if (req.getSession().getServletContext().getAttribute(PREFIX_WORK_TYPE) == null || forceUpdate) {
			//String sql = "select NAME,PARENT_ID,HIERARCHY,ORDER_ID,WORK_TYPE_ID,IS_CHILD from WORK_TYPE order by ORDER_ID asc";
			Map<String, List<WorkTypeCountVO>> map = new HashMap<String, List<WorkTypeCountVO>>();
			List<WorkTypeCountVO> jzgd = new ArrayList<WorkTypeCountVO>();// 建筑工地类
			List<WorkTypeCountVO> sczz = new ArrayList<WorkTypeCountVO>();// 生产/制造类
			List<WorkTypeCountVO> fwhqxs = new ArrayList<WorkTypeCountVO>();// 服务/后勤/销售类
			try {
				WorkTypeExample example = new WorkTypeExample();
				example.setOrderByClause("ORDER_ID asc");
				List<WorkType> workTypeList = daoUtil.workTypeMapper.selectByExample(example);
				for (WorkType wt : workTypeList) {
					WorkTypeCountVO vo = new WorkTypeCountVO();
					vo.setWorkTypeName(wt.getName());
					vo.setPid(wt.getParentId());
					vo.setHierarchy(wt.getHierarchy());
					vo.setOrderId(wt.getOrderId());
					vo.setWorkTypeId(wt.getWorkTypeId());
					vo.setIsChild(wt.getIsChild());
					vo.setCount(null);// 不统计数量
					String tampStr = wt.getWorkTypeId();
					if (tampStr.startsWith("01")) {// 建筑工地类
						jzgd.add(vo);
					} else if (tampStr.startsWith("02")) {// 生产/制造类
						sczz.add(vo);
					} else {// "03"//服务/后勤/销售类
						fwhqxs.add(vo);
					}
				}
				map.put("jzgd", jzgd);
				map.put("sczz", sczz);
				map.put("fwhqxs", fwhqxs);
				req.getSession().getServletContext().setAttribute(PREFIX_WORK_TYPE, map);
			} catch (Exception e) {
				log.error("查询工种列表失败", e);
				e.printStackTrace();
			}
			return map;
		} else {
			return (Map<String, List<WorkTypeCountVO>>) req.getSession().getServletContext().getAttribute(PREFIX_WORK_TYPE);
		}
	}

	/**
	 * 
	 * @param req
	 * @param workTypeId
	 *            会截成长度为2的字符串，例如01、02、03分别表示三个行业
	 * @param forceUpdate
	 * @return
	 */
	public List<WorkTypeCountVO> listWorkTypes(HttpServletRequest req, String workTypeId, boolean forceUpdate) {
		workTypeId = workTypeId.substring(0, 2);// 行业的工种id
		if (req.getSession().getServletContext().getAttribute(PREFIX_WORK_TYPE + workTypeId) == null || forceUpdate) {
			//String sql = "select NAME,PARENT_ID,HIERARCHY,ORDER_ID,WORK_TYPE_ID,IS_CHILD from WORK_TYPE where WORK_TYPE_ID like ? order by ORDER_ID asc";
			List<WorkTypeCountVO> list = new ArrayList<WorkTypeCountVO>();// 建筑工地类
			try {
				WorkTypeExample example = new WorkTypeExample();
				example.createCriteria().andWorkTypeIdLike(workTypeId + "%");
				example.setOrderByClause("ORDER_ID asc");
				List<WorkType> workTypeList = daoUtil.workTypeMapper.selectByExample(example);
				
				for (WorkType wt : workTypeList) {
					WorkTypeCountVO vo = new WorkTypeCountVO();
					vo.setWorkTypeName(wt.getName());
					vo.setPid(wt.getParentId());
					vo.setHierarchy(wt.getHierarchy());
					vo.setOrderId(wt.getOrderId());
					vo.setWorkTypeId(wt.getWorkTypeId());
					vo.setIsChild(wt.getIsChild());
					vo.setCount(null);// 不统计数量
					list.add(vo);
				}
				req.getSession().getServletContext().setAttribute(PREFIX_WORK_TYPE + workTypeId, list);
			} catch (Exception e) {
				log.error("查询工种列表失败", e);
				e.printStackTrace();
			}
			return list;
		} else {
			return (List<WorkTypeCountVO>) req.getSession().getServletContext().getAttribute(PREFIX_WORK_TYPE + workTypeId);
		}
	}

	public List<WorkTypeCountVO> listWorkType(HttpServletRequest req, boolean forceUpdate) {
		if (req.getSession().getServletContext().getAttribute(PREFIX_CHOOSE_WORK_TYPE) == null || forceUpdate) {
			List<WorkTypeCountVO> list2 = new ArrayList<WorkTypeCountVO>();
//			String sql = "select * from work_type";
			try {
				WorkTypeExample example = new WorkTypeExample();
				List<WorkType> list = daoUtil.workTypeMapper.selectByExample(example);
				
				for (int i = 0; list != null && i < list.size(); i++) {
					WorkType tmp = list.get(i);
					WorkTypeCountVO tmp2 = new WorkTypeCountVO();
					tmp2.setWorkTypeName(tmp.getName());
					tmp2.setWorkTypeId(tmp.getWorkTypeId());
					tmp2.setPid(tmp.getParentId());
					tmp2.setIsChild(tmp.getIsChild());
					tmp2.setOrderId(tmp.getOrderId());
					tmp2.setHierarchy(tmp.getHierarchy());
					list2.add(tmp2);
				}
			} catch (Exception e) {
				log.error("选择工种列表", e);
				e.printStackTrace();
			}
			return list2;
		} else {
			return (List<WorkTypeCountVO>) req.getSession().getServletContext().getAttribute(PREFIX_CHOOSE_WORK_TYPE);
		}
	}

	public WorkType getWorkTypeById(String workTypeId) {
		WorkType workType = null;
		try {
//			String sql = "select * from work_type where work_type_id=?";
			
			WorkTypeExample example = new WorkTypeExample();
			example.createCriteria().andWorkTypeIdEqualTo(workTypeId);
			List<WorkType> workTypeList = daoUtil.workTypeMapper.selectByExample(example);
			
			
			workType = workTypeList == null || workTypeList.isEmpty() ? null : workTypeList.get(0);
		} catch (Exception e) {
			log.error("通过workTypeId查WorkType失败", e);
			e.printStackTrace();
		}
		return workType;
	}

}
