package com.jsp.action.common;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.action.Action;
import com.jsp.exception.InvalidPasswordException;
import com.jsp.exception.NotFoundIdException;
import com.jsp.service.MemberService;

public class LoginAction implements Action {
	
	private MemberService memberService;
	
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response)throws Exception {
		String url="redirect:index.do";
		//입력
		String id = request.getParameter("id");
	    String pwd = request.getParameter("pwd");
	    
	    //처리
	    try {
	    	
	    	memberService.login(id, pwd);
	    	
	    	HttpSession session = request.getSession();
	    	session.setAttribute("loginUser", memberService.getMember(id));
	    	session.setMaxInactiveInterval(6*60);
	    	// 6분을 유지하겠다. 초단위 
	    	
	    }catch(SQLException e) {
	    	e.printStackTrace();
	    	throw e;
	    }catch(NotFoundIdException|InvalidPasswordException e) {
	    	request.setAttribute("message", e.getMessage());
	    	
	    	url="common/loginFail";
	    }

	    return url;
		
	}

}
