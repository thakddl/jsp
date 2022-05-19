package com.jsp.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class TestListener
 *
 */
@WebListener
public class TestListener implements ServletContextListener {// 야가 어플리케이션(변수명인거임) 타입은 ServletContext이다

    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }

    public void contextInitialized(ServletContextEvent event)  {//Context 생성 시 발생하는 아이 ServletContextEvent는 컨택스트를 가지고 올수있다.
    	System.out.println("TestListener loading !!!!!!");
        
    	String message = event.getServletContext().getInitParameter("message");
        
    	System.out.println(message);

    }
	
}
