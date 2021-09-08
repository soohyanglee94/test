package com.jsp.dao;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.jsp.dao.MemberDAO;
import com.jsp.dao.MemberDAOImpl;
import com.jsp.datasource.OracleMybatisSqlSessionFactory;
import com.jsp.dto.MemberVO;

public class TestMemberDAOImpl {

	private SqlSessionFactory sqlSessionFactory = new OracleMybatisSqlSessionFactory();
	private SqlSession session;
	
	private MemberDAO memberDAO;
	
	// 제한자는 public return타입은 void parameter없음으로 설정한다
	
	@Before
	public void init() {
		session = sqlSessionFactory.openSession(false);
		//auto커밋이 되지 않도록 false
		memberDAO = new MemberDAOImpl();
	}
	
	@Test
	public void testSelecMemberById() throws SQLException{
		String testID = "mimi";
		MemberVO member = memberDAO.selectMemberById(session, testID);
		Assert.assertEquals(testID, member.getId());
		
	}
	
	
	
	@After
	public void complete() {
		session.rollback();
		session.close();
	}
	
}
