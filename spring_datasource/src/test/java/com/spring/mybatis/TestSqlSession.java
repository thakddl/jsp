package com.spring.mybatis;

import java.sql.SQLException;
import java.util.Collection;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/spring/context/root-context.xml")
public class TestSqlSession {
	
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	private SqlSession session;

	@Before
	public void init() throws SQLException {
		Assert.assertNotNull(sqlSessionFactory);
	}

	@After
	public void destroy() throws SQLException {
		
	}
	
	@Test
	public void testSqlSessionFactory() throws SQLException {
		Collection<String> mapNames = (Collection<String>)session.getConfiguration().getMappedStatementNames();
		
		Assert.assertTrue(mapNames.contains("Member-mapper.selectSearchMemberList"));
	}

}
