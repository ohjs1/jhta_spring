package com.jhta.page.util;

public class PageUtil {
	private int pageNum; //페이지 번호
	private int startRow; //시작 행
	private int endRow; // 끝행
	private int totalRow; //전체 글수
	private int startPage; //시작 페이지
	private int endPage; //끝페이지
	private int totalPage; //전체페이지 수
	
	private int rowBlockCount; // 한페이지에 보여질 글의 수
	private int pageBlockCount; // 한페이지에 보여질 페이지 수
	
	public PageUtil() {}
	
	public PageUtil(int pageNum, int totalRow, int rowBlockCount, int pageBlockCount) {
		this.pageNum = pageNum;
		this.totalRow = totalRow;
		this.rowBlockCount = rowBlockCount;
		this.pageBlockCount = pageBlockCount;
		
		//시작행
		startRow = (pageNum - 1) * rowBlockCount + 1;
		//끝행
		endRow = startRow + rowBlockCount - 1;
		//시작 페이지
		startPage = (pageNum -1) / pageBlockCount * pageBlockCount + 1;
		//끝페이지
		endPage = startPage + pageBlockCount - 1;
		//전체페이지 수
		totalPage = (int)Math.ceil(totalRow / (double)rowBlockCount);
		if(totalPage < endPage) {
			endPage = totalPage;
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

	public int getTotalRow() {
		return totalRow;
	}

	public void setTotalRow(int totalRow) {
		this.totalRow = totalRow;
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

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
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
