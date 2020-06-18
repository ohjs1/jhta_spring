package com.jhta.spring11.vo;

import org.springframework.stereotype.Repository;

@Repository
public class Pagning {
	private int pageNum; //페이지 번호
	private int maxPageCount; //전체페이지 갯수
	private int rowBlockCount; //한페이지에 보여질 글의 갯수
	private int pageBlockCount; //한페이지에 보여질 페이지 갯수
	private int startRow; //시작 글번호
	private int endRow; //끝 글번호
	private int startPage; //시작 페이지
	private int endPage; //끝페이지
	private int totalRowCount; //전체 글의 갯수
	
	public Pagning() {}
	/**
	 * 
	 * @param pageNum 페이지 번호
	 * @param totalRowCount 전체 글 수
	 * @param rowBlockCount 페이지당 글 수
	 * @param pageBlockCount 한화면에 보일 페이지수
	 */
	public Pagning(int pageNum, int totalRowCount, int rowBlockCount, int pageBlockCount) {
		
		this.pageNum = pageNum;
		this.totalRowCount = totalRowCount;
		this.rowBlockCount = rowBlockCount;
		this.pageBlockCount = pageBlockCount;
		
		startRow = (pageNum - 1) * pageBlockCount + 1;
		endRow = startRow + pageBlockCount - 1;
		maxPageCount = (int)Math.ceil(totalRowCount/(double)rowBlockCount);
		startPage = (pageNum-1) / rowBlockCount * pageBlockCount + 1;
		endPage = startPage + pageBlockCount - 1;
		
		if(maxPageCount<endPage) {
			endPage = maxPageCount;
		}
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public int getEndRow() {
		return endRow;
	}

	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}

	public int getMaxPageCount() {
		return maxPageCount;
	}

	public void setMaxPageCount(int maxPageCount) {
		this.maxPageCount = maxPageCount;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getTotalRowCount() {
		return totalRowCount;
	}

	public void setTotalRowCount(int totalRowCount) {
		this.totalRowCount = totalRowCount;
	}

	public int getRowBlockCount() {
		return rowBlockCount;
	}

	public void setRowBlockCount(int rowBlockCount) {
		this.rowBlockCount = rowBlockCount;
	}

	public int getPageBlockCount() {
		return pageBlockCount;
	}

	public void setPageBlockCount(int pageBlockCount) {
		this.pageBlockCount = pageBlockCount;
	}
	
	
	
}
