package Util;

import java.util.List;

public class MyUtils {
	
	public static <T> List<T> getNowPageList(List<T> list, String nowPage, String perPage) {
		if(list.size() > 0) {
			int np = 1; //현재페이지
			int pp = 10; // 페이지당 포스트 숫자
			if(nowPage != null) {
				np = Integer.parseInt(nowPage);
			}
			if(perPage != null) {
				pp = Integer.parseInt(perPage);
			}
			int size = list.size(); //총포스트 숫자
			int firstPost = (np-1)*pp; //페이지의 첫포스트의 순번(list기준)
			int lastPost = (firstPost+pp)>size?(size-1):firstPost+pp;
			//현재페이지에 맞는 리스트로 변환실행
			list = list.subList(firstPost, lastPost);
			return list;
		}
		return list;
	}
}
