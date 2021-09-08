package com.jsp.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.jsp.datasource.OracleMybatisSqlSessionFactory;
import com.jsp.dto.MenuVO;

public class TestMenuDAOImpl {
	private SqlSessionFactory sqlSessionFactory = new OracleMybatisSqlSessionFactory();
	private SqlSession session;
	
	private MenuDAO menuDAO;
	
	@Before
	public void init() {
		session = sqlSessionFactory.openSession(false);
		//auto커밋이 되지 않도록 false
		menuDAO = new MenuDAOImpl();
	}
	
	@Test
	public void testSelectMainMenu() throws SQLException{
		List<MenuVO> menu = menuDAO.selectMainMenu(session);
		Assert.assertNotNull(menu);
		Assert.assertFalse(menu.isEmpty());
	}
	
	@Test
	public void testSelectSubMenu() throws SQLException{
		String mCode = "M000000";
		List<MenuVO> menu = menuDAO.selectSubMenu(session, mCode);
		Assert.assertNotNull(menu);
		
		String mCode2 = "M010100";
		List<MenuVO> menu2 = menuDAO.selectSubMenu(session, mCode2);
		Assert.assertTrue(menu2.isEmpty());
		
	}
	
	@Test
	public void testSelectMenuByMcode() throws SQLException{
		String mCode = "M000000";
		MenuVO menu = menuDAO.selectMenuByMcode(session, mCode);
		Assert.assertNotNull(menu);
		
		MenuVO vo = new MenuVO();
		vo.setMname("HOME");
		Assert.assertEquals(vo.getMname(), menu.getMname());
		
	}
		
	
	@Test
	public void testSelectMenuByMname() throws SQLException{
		String mName = "회원관리";
		MenuVO menu = menuDAO.selectMenuByMname(session, mName);
		Assert.assertNotNull(menu);
		
		MenuVO vo = new MenuVO();
		vo.setMurl("/member/main.do");
		Assert.assertEquals(vo.getMurl(), menu.getMurl());
		
	}
	
	@After
	public void complete() {
		session.rollback();
		session.close();
	}
	
	
}
