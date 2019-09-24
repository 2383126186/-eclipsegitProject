package com.entity;

import java.util.List;

//包类
public class Page {
	private int pageSzie = 4;//页面大小
	
	private int pageCount;//总页数
	
	private long rows;//总记录数
	
	private List<?> data;//数据

	public int getPageSzie() {
		return pageSzie;
	}

	public void setPageSzie(int pageSzie) {
		this.pageSzie = pageSzie;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public long getRows() {
		return rows;
	}

	public void setRows(long rows) {
		this.rows = rows;
	}

	public List<?> getData() {
		return data;
	}

	public void setData(List<?> data) {
		this.data = data;
	}

	public Page(int pageSzie, int pageCount, long rows, List<?> data) {
		super();
		this.pageSzie = pageSzie;
		this.pageCount = pageCount;
		this.rows = rows;
		this.data = data;
	}

	public Page() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Page [pageSzie=" + pageSzie + ", pageCount=" + pageCount + ", rows=" + rows
				+ ", data=" + data + "]";
	}






	
}
