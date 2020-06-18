package com.jhta.spring11.vo;

import org.springframework.stereotype.Repository;

@Repository
public class Pagning {
	private int pageNum; //������ ��ȣ
	private int maxPageCount; //��ü������ ����
	private int rowBlockCount; //���������� ������ ���� ����
	private int pageBlockCount; //���������� ������ ������ ����
	private int startRow; //���� �۹�ȣ
	private int endRow; //�� �۹�ȣ
	private int startPage; //���� ������
	private int endPage; //��������
	private int totalRowCount; //��ü ���� ����
	
	public Pagning() {}
	/**
	 * 
	 * @param pageNum ������ ��ȣ
	 * @param totalRowCount ��ü �� ��
	 * @param rowBlockCount �������� �� ��
	 * @param pageBlockCount ��ȭ�鿡 ���� ��������
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
