package login.controller;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import login.service.ILoginService;
import login.service.LoginServiceImpl;
import member.vo.JoinMemberVO;


 @WebServlet("/newPass.do")
public class MailServlet extends HttpServlet{
 
	 @Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 	// 랜덤 비밀번호 생성
		 	String newPass = ""; 
			
			// 소문자 a-z 랜덤 알파벳 생성
		    for (int i = 1; i <= 4; i++) {
		      char ch = (char) ((Math.random() * 26) + 97);
		      newPass += ch;
		    }
			// 숫자 0-9 랜덤 생성
		    for (int i = 1; i <= 4; i++) {
			  char ch = (char) ((Math.random() * 9) + 48);
			  newPass += ch;
			}
		    
		    // 파라미터정보 가져오기
		    String memId = req.getParameter("memId");
		    
		    JoinMemberVO mv = new JoinMemberVO();
		    
		    mv.setMemId(memId);
		    
		    // 서비스 객체 생성
		    ILoginService loginService = LoginServiceImpl.getInstance();
		    
			
			String alert = "";
			if(loginService.checkMember(memId) == 1) {
				
				// getMail 메서드로 메일주소 가져오기
				String email = loginService.getMail(memId);
		    	mv.setMemMail(email);
		        
		    	
		        Properties p = System.getProperties();
		        p.put("mail.smtp.starttls.enable", "true");     // gmail은 true 고정
		        p.put("mail.smtp.host", "smtp.naver.com");      // smtp 서버 주소
		        p.put("mail.smtp.auth","true");                 // gmail은 true 고정
		        p.put("mail.smtp.port", "587");                 // 네이버 포트
		        p.put("mail.smtp.port", "587");                 // 네이버 포트
		           
		        Authenticator auth = new MyAuthentication();
		        //session 생성 및  MimeMessage생성
		        Session session = Session.getDefaultInstance(p, auth);
		        MimeMessage msg = new MimeMessage(session);
		         
		        try{
		            //편지보낸시간
		            msg.setSentDate(new Date());
		            InternetAddress from = new InternetAddress() ;
		            from = new InternetAddress("codingpeople@naver.com"); //발신자 아이디
		            // 이메일 발신자
		            msg.setFrom(from);
		            // 이메일 수신자
		            InternetAddress to = new InternetAddress(""+ email +"");
		            msg.setRecipient(Message.RecipientType.TO, to);
		            // 이메일 제목
		            msg.setSubject("CodingPeople 비밀번호 찾기", "UTF-8");
		            // 이메일 내용
		            msg.setText(""+ newPass +"", "UTF-8");
		            // 이메일 헤더
		            msg.setHeader("content-Type", "text/html");
		            //메일보내기
		            javax.mail.Transport.send(msg, msg.getAllRecipients());
		             
		        }catch (AddressException addr_e) {
		            addr_e.printStackTrace();
		        }catch (MessagingException msg_e) {
		            msg_e.printStackTrace();
		        }catch (Exception msg_e) {
		            msg_e.printStackTrace();
		        }
		        
		        // 새로운 비밀번호 암호화
		        String memPass = SHA256.encodeSha256(newPass);
		        mv.setMemPass(memPass);
		        
		        // 암호화한 비밀번호를 새 비밀번호로 업데이트
		        loginService.updatePass(mv);
				
				alert = "yes";
			} else {
				alert = "no";
			}
		    
			req.setAttribute("alert", alert);
			// 비밀번호찾기 화면으로 되돌아가기
			req.getRequestDispatcher("/newPass.jsp").forward(req, resp);
		    
	        
		}
        
        
        
}
 
class MyAuthentication extends Authenticator {
      
    PasswordAuthentication pa;
    public MyAuthentication(){
         
        String id = "codingpeople@naver.com";  //네이버 이메일 아이디
        String pw = "javajava12";        //네이버 비밀번호
 
        // ID와 비밀번호를 입력한다.
        pa = new PasswordAuthentication(id, pw);
    }
 
    // 시스템에서 사용하는 인증정보
    public PasswordAuthentication getPasswordAuthentication() {
        return pa;
    }
} 
  
