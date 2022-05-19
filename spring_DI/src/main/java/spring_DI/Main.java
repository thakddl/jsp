package spring_DI;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.jsp.dto.MemberVO;
import com.jsp.service.MemberService;

public class Main {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		ApplicationContext ctx = new GenericXmlApplicationContext("classpath:com/spring/context/root-context.xml");

		MemberService memberService = ctx.getBean("memberService", MemberService.class);
		try {

			MemberVO member = memberService.getMember("mimi");

			System.out.println(member.getAddress());

		} catch (Exception e) {

			e.printStackTrace();

		}
		
	}

}
