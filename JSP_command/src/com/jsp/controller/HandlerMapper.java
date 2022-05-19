package com.jsp.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import com.jsp.action.Action;

public class HandlerMapper {
	// 리소스 번들은 무조건 프로퍼티스 파일을 읽기 때문에 확장자를 주지 않아도 잘 찾아간다. 
	// 프로퍼티스의 단점, url을 리터럴로 주는 것의 단점-> 오타의 소지가 다분해서 Exception 발생활률이 높음
	private static final String path = "com/jsp/properties/url";
	
	private Map<String, Action> commandMap = new HashMap<String, Action>();
	
	public HandlerMapper() throws Exception {
		this(path);
	}
	   
	public HandlerMapper(String path) throws Exception {
		
		ResourceBundle rbHome = ResourceBundle.getBundle(path);
		
		Set<String> actionSetHome = rbHome.keySet();//uri set
		
		Iterator<String> it = actionSetHome.iterator();
		while(it.hasNext()) {
			String command = it.next();//key->url
			String actionClassName = rbHome.getString(command);
			
			Class<?> actionClass = Class.forName(actionClassName);
			Action commandAction = (Action) actionClass.newInstance();//싱글톤이다. 싱글톤 패턴은 아니지만. 싱글톤 패턴을 쓰면 결합도가 매우 높아진다.
	         
			commandMap.put(command, commandAction);
			System.out.println("[HandlerMapper]" + command + ":" + commandAction + " 가 준비되었습니다.");

		}
	}
	public Action getAction(String url){
		Action action = commandMap.get(url);
		return action;
	}
}
