package com.jsp.service;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jsp.command.Criteria;
import com.jsp.dto.MemberVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/spring/context/root-context.xml")
public class TestMemberServiceImpl {
	
	// @Autowired - type으로 불러오기
	// MemberService memberService;
	@Resource(name = "searchMemberService") //아이디네임으로ㅓ 불러오긴
	SearchMemberService memberService;
	
	@Test
	public void testGetList()throws Exception {
		
		Criteria cri = new Criteria();
		
		@SuppressWarnings("unchecked")
		List<MemberVO> memberList = (List<MemberVO>) memberService.getSearchMemberList(cri).get("memberList");
		
		Assert.assertEquals(4, memberList.size());
	}
	
}
