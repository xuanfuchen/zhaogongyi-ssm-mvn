package com.zhaogongyi.commons.pager;

import javax.servlet.http.HttpServletRequest;

public class Pager {

	private int thisPage = 1; // 当前页

	private int pageSize = 20; // 每页条数

	private int pageCount; // 多少页

	private int total; // 所有条数

	private String sortField; // 按哪个字段排序

	private String sortType; // 顺序还是倒序

	private String excel; // 是否导出excel

	private String tdx; // 点击哪个td

	private String url;// 查询用的action和参数

	public Pager() {

	}

	public Pager(HttpServletRequest req, int thisPage) {
		this.thisPage = thisPage;
		this.url = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() 
		+ req.getRequestURI();
		System.out.println("url为：" + this.url);
	}
	
	public String replacePageNum(int page) {
		int index = url.lastIndexOf("_");
		return url.substring(0, index+1) + page;
	}

	public Pager(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getThisPage() {
		return thisPage;
	}

	public void setThisPage(int thisPage) {
		this.thisPage = thisPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getSortField() {
		return sortField;
	}

	public void setSortField(String sortField) {
		this.sortField = sortField;
	}

	public String getSortType() {
		return sortType;
	}

	public void setSortType(String sortType) {
		this.sortType = sortType;
	}

	public String getExcel() {
		return excel;
	}

	public void setExcel(String excel) {
		this.excel = excel;
	}

	public String getTdx() {
		return tdx;
	}

	public void setTdx(String tdx) {
		this.tdx = tdx;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
