package com.jsp.action.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.dto.MemberVO;
import com.jsp.service.MemberService;

public class MemberIdCheckAction implements Action {
	
	private MemberService memberService;
	
	public void setMemberService(MemberService memberService) {
		this.memberService=memberService;
	} // reflection 이 찾는것은 set~ 메서드네임이기 때문에 이 부분을 주의하자

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url=null;
		//화면이 없다는 것을 명식적으로 알려줌
		String resultStr = "";
		String id = request.getParameter("id");
		// ajax 주소값으로 넣어줬쥬
		
		MemberVO member = memberService.getMember(id);
		if(member!=null) {
			resultStr="duplicated";
		}
		PrintWriter out = response.getWriter();
		out.print(resultStr);
		out.close();
		
		return url;
	}

}
