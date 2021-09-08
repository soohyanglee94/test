package com.jsp.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.service.NoticeService;

public class NoticeAction implements Action {

	protected NoticeService noticeService;
	
	public void setNoticeService(NoticeService noticeService) {
		this.noticeService=noticeService;
	}
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return null;
	}

}
