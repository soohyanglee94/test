package com.jsp.datasource;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.jsp.datasource.OracleMybatisSqlSessionFactory;
import com.jsp.dto.MemberVO;
import com.jsp.dto.MenuVO;

public class TestOracleMybatisSqlSessionFactory {

	private SqlSessionFactory sqlSessionFactory = new OracleMybatisSqlSessionFactory();
	private SqlSession session;
	
	@Before
	public void init() {
		session = sqlSessionFactory.openSession();
	}
	
	@Test
	public void testNotNullSession() {
		Assert.assertNotNull(session);
	}
	
	@Test
	public void testNotNullConnection() {
		Assert.assertNotNull(session.getConnection());
	}
	
	@Test
	public void testSelectMemberById() throws SQLException {
	   String testID = "mimi";
	   
	   MemberVO member = session.selectOne("Member-Mapper.selectMemberById", testID);
	   
	   Assert.assertEquals(testID, member.getId());
	}

	@Test
	public void selectMainMenu() throws SQLException {
		
		List<MenuVO> menu = session.selectList("Member-Mapper.selectMainMenu");
		
		Assert.assertNotNull(menu);
	}

	@Test
	public void selectSubMenu() throws SQLException {
		
		List<MenuVO> menu = session.selectList("Member-Mapper.selectSubMenu");
		
		Assert.assertNotNull(menu);
	}

	@Test
	public void selectMenuByMcode() throws SQLException {
		
		MenuVO menu = session.selectOne("Member-Mapper.selectMenuByMcode");
		
		Assert.assertNotNull(menu);
	}

	@Test
	public void selectMenuByMname() throws SQLException {
		
		MenuVO menu = session.selectOne("Member-Mapper.selectMenuByMname");
		
		Assert.assertNotNull(menu);
	}
	   
	   
	
	
	@After
	public void complete() {
		session.close();
	}

}
