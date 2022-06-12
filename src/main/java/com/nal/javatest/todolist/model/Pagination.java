package com.nal.javatest.todolist.model;

public class Pagination {
	
	/**
	 * currentPage : Current page, default value = 1
	 */
	private int currentPage = 1;

    /**
     * pageSize : The number of pages, default value = 10
     */
    private int pageSize = 10;

	public Pagination(int currentPage, int pageSize) {
		this.currentPage = currentPage;
		this.pageSize = pageSize;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

}
