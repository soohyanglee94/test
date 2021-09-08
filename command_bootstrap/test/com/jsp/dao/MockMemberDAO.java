/*package com.jsp.dao;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;

import com.jsp.dto.MemberVO;

public class MockMemberDAO implements MemberDAO {

	@Override
	public MemberVO selectMemberById(SqlSession session, String id) throws SQLException {
		
		MemberVO member = null;
		
		if(id.equals("mimi")) {
			member = new MemberVO();
			member.setId("mimi");
			member.setPwd("mimi");
			member.setName("mimi");
		}
		
		return member;
	}

}
*/