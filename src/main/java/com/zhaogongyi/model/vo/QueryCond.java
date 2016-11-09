package com.zhaogongyi.model.vo;

public class QueryCond {
	//为了让URL尽量缩短美观，短命名
	private String plid;// placeId
	private String wtid; // workTypeId
	private String kw = "";// keyword
	private int p;
	
	
	public QueryCond(String plid, String wtid, String kw, int p) {
		super();
		this.plid = plid;
		this.wtid = wtid;
		this.kw = kw;
		this.p = p;
	}
	public QueryCond() {
		super();
	}
	public String getPlid() {
		return plid;
	}
	public void setPlid(String plid) {
		this.plid = plid;
	}
	public String getWtid() {
		return wtid;
	}
	public void setWtid(String wtid) {
		this.wtid = wtid;
	}
	public String getKw() {
		return kw;
	}
	public void setKw(String kw) {
		this.kw = kw;
	}
	public int getP() {
		return p;
	}
	public void setP(int p) {
		this.p = p;
	}
	
}
