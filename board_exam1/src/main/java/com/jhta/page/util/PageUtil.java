package com.jhta.page.util;

public class PageUtil {
	private int pageNum; //������ ��ȣ
	private int startRow; //���� ��
	private int endRow; // ����
	private int totalRow; //��ü �ۼ�
	private int startPage; //���� ������
	private int endPage; //��������
	private int totalPage; //��ü������ ��
	
	private int rowBlockCount; // ���������� ������ ���� ��
	private int pageBlockCount; // ���������� ������ ������ ��
	
	public PageUtil() {}
	
	public PageUtil(int pageNum, int totalRow, int rowBlockCount, int pageBlockCount) {
		this.pageNum = pageNum;
		this.totalRow = totalRow;
		this.rowBlockCount = rowBlockCount;
		this.pageBlockCount = pageBlockCount;
		
		//������
		startRow = (pageNum - 1) * rowBlockCount + 1;
		//����
		endRow = startRow + rowBlockCount - 1;
		//���� ������
		startPage = (pageNum -1) / pageBlockCount * pageBlockCount + 1;
		//��������
		endPage = startPage + pageBlockCount - 1;
		//��ü������ ��
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
