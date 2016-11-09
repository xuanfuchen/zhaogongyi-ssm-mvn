package com.zhaogongyi.service.common;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhaogongyi.dao.common.DaoUtil;
import com.zhaogongyi.model.Place;
import com.zhaogongyi.model.PlaceExample;

@Service
@Transactional
public class PlaceService {
	private static final Log log = LogFactory.getLog(PlaceService.class);
	@Resource
	private DaoUtil daoUtil;
	
	private static final String PREFIX_PLACE_CONTAINS_CITY = "PREFIX_PLACE_CONTAINS_CITY";
	private static final String PREFIX_PLACE_NO_CITY = "PREFIX_PLACE_NO_CITY";
	private static final String PREFIX_ALL_CITES = "PREFIX_ALL_CITES";

	public List<Place> getCityList(HttpServletRequest req, boolean forceUpdate) {
		if (req.getSession().getServletContext().getAttribute(PREFIX_ALL_CITES) == null || forceUpdate) {
//			String sql = "select * from place where is_child=0";
			List<Place> listPlace = null;
			try {
				PlaceExample example = new PlaceExample();
				example.createCriteria().andIsChildEqualTo((byte)0);
				listPlace = daoUtil.placeMapper.selectByExample(example );
				
				
			} catch (Exception e) {
				log.error("查询所有城市列表出错", e);
				e.printStackTrace();
			}
			return listPlace;
		} else {
			return (List<Place>) req.getSession().getServletContext().getAttribute(PREFIX_ALL_CITES);
		}
	}

	/**
	 * 查询地区列表，包括城市
	 * 
	 * @param req
	 * @param placeId
	 * @param forceUpdate
	 *            是否强制更新
	 * @return
	 */
	public List<Place> getPlacesContainsCity(HttpServletRequest req, String placeId, boolean forceUpdate) {
		if (req.getSession().getServletContext().getAttribute(PREFIX_PLACE_CONTAINS_CITY + placeId) == null || forceUpdate) {
			String t = placeId.substring(0, 4);
//			String sql = "select * from place where place_id like ? order by place_id asc";
			List<Place> listPlace = null;
			try {
				PlaceExample example = new PlaceExample();
				example.createCriteria().andPlaceIdLike(t + "%");
				example.setOrderByClause("place_id asc");
				listPlace = daoUtil.placeMapper.selectByExample(example );
				
			} catch (Exception e) {
				log.error("查询地区出错", e);
				e.printStackTrace();
			}
			return listPlace;
		} else {
			return (List<Place>) req.getSession().getServletContext().getAttribute(PREFIX_PLACE_CONTAINS_CITY + placeId);
		}
	}

	/**
	 * 查询地区列表，不包括城市
	 * 
	 * @param req
	 * @param placeId
	 * @param forceUpdate
	 *            是否强制更新
	 * @return
	 */
	public List<Place> getPlacesNoCity(HttpServletRequest req, String placeId, boolean forceUpdate) {
		if (req.getSession().getServletContext().getAttribute(PREFIX_PLACE_NO_CITY + placeId) == null || forceUpdate) {
			String t = placeId.substring(0, 4);
//			String sql = "select * from place where place_id like ? and is_child!=0 order by place_id asc";
			List<Place> listPlace = null;
			try {
				PlaceExample example = new PlaceExample();
				example.createCriteria().andPlaceIdLike(t + "%").andIsChildNotEqualTo((byte)0);
				example.setOrderByClause("place_id asc");
				listPlace = daoUtil.placeMapper.selectByExample(example );
				
			} catch (Exception e) {
				log.error("查询地区出错", e);
				e.printStackTrace();
			}
			return listPlace;
		} else {
			return (List<Place>) req.getSession().getServletContext().getAttribute(PREFIX_PLACE_NO_CITY + placeId);
		}
	}

	/**
	 * 不管传入的是城市还是地区的id，返回的都是城市
	 * 
	 * @param placeId
	 * @return
	 */
	public Place getCityByPlaceId(String placeId) {
		String t = placeId.substring(0, 4);
//		String sql = "select * from place where place_id=?";
		Place p = null;
		try {
			p = daoUtil.placeMapper.selectByPrimaryKey(t);
		} catch (Exception e) {
			log.error("查询地区出错", e);
			e.printStackTrace();
		}
		return p;
	}

	/**
	 * 通过传入的城市或地区返回查询的城市或地区
	 * 
	 * @param placeId
	 * @return
	 */
	public Place getPlaceByPlaceId(String placeId) {
//		String sql = "select * from place where place_id=?";
		Place p = null;
		try {
			p = daoUtil.placeMapper.selectByPrimaryKey(placeId);
		} catch (Exception e) {
			log.error("查询地区出错", e);
			e.printStackTrace();
		}
		return p;
	}

}
