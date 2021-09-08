package com.jsp.request;

public class Criteria {
	
	private int page = 1;
	private int perPageNum = 10;
	private int startRowNum;
	private int endRowNum;
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		if(page<1)
			page=1;
		this.page = page;
	}
	public void setPage(String page) {
		if(page!=null && !page.isEmpty()) {
			try {
				setPage(Integer.parseInt(page));
			}catch(NumberFormatException e) {
				this.page=1;
			}
		}else {
			this.page = 1;
		}
	}
	//try catch쓰는 이유 
	//스페이스 등 들어가면 터지므로
	public int getPerPageNum() {
		return perPageNum;
	}
	public void setPerPageNum(int perPageNum) {
		if(perPageNum<1) perPageNum=1;
		this.perPageNum = perPageNum;
	}	
	public void setPerPageNum(String perPageNum) {
		if(perPageNum!=null && !perPageNum.isEmpty()) {
			try {
				setPerPageNum(Integer.parseInt(perPageNum));
			}catch(NumberFormatException e){
				this.perPageNum = 10;
			}
		}else {
			this.perPageNum = 10;
		}
	}
	
	
	public int getStartRowNum() {
		this.startRowNum=(this.page-1)*perPageNum;
		return this.startRowNum;
	}
	
	public int getEndRowNum() {
		this.endRowNum = this.startRowNum+this.perPageNum-1;
		return this.endRowNum;
	}
	
//starRowNum 과 endRowNum은 setter 필요가 없음
	
	
}
