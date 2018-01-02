package com.zm.publics.util;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.mysql.jdbc.StringUtils;



public class Page<T> {

	// 下一�?
	private int pageNo;

	// 当前�?
	private int currentPage = 1;

	// 每页个个�?
	private int pageSize = 20;

	// 总条�?
	private int totalCount;

	// 总页�?
	private int pageCount;

	// 记录
	private List<?> results;

	public Page() {

	}

	public Page(HttpServletRequest request) {
		try {
			String page = request.getParameter("page");
			String rows = request.getParameter("rows");
//			if (StringUtils.isNotBlank(page))
				currentPage = Integer.valueOf(page);
//			if (StringUtils.isNotBlank(rows))
				pageSize = Integer.valueOf(rows);
		} catch (Exception e) {
		}
		this.totalCount = 0;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getPageNo() {
		if (pageNo <= 0) {
			return 1;
		} else {
			return pageNo > pageCount ? pageCount : pageNo;
		}
	}

	public List<?> getResults() {
		return results;
	}

	public void setResults(List<?> results) {
		this.results = results;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize <= 0 ? 10 : pageSize;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public void resetPageNo() {
		pageNo = currentPage + 1;
		pageCount = totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1;
	}

}