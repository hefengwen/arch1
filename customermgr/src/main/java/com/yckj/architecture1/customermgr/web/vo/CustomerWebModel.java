package com.yckj.architecture1.customermgr.web.vo;

public class CustomerWebModel {
	private String queryJsonStr = "";
	private int nowPage = 1;
	private int pageShow = 0;
	public String getQueryJsonStr() {
		return queryJsonStr;
	}
	public void setQueryJsonStr(String queryJsonStr) {
		this.queryJsonStr = queryJsonStr;
	}
	public int getNowPage() {
		return nowPage;
	}
	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}
	public int getPageShow() {
		return pageShow;
	}
	public void setPageShow(int pageShow) {
		this.pageShow = pageShow;
	}
	@Override
	public String toString() {
		return "CustomerWebModel [queryJsonStr=" + queryJsonStr + ", nowPage=" + nowPage + ", pageShow=" + pageShow
				+ "]";
	}
}
