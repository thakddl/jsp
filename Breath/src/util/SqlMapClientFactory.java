package util;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

/**
 * SqlMapClient 객체를 제공하는 팩토리 클래스
 * @author 김요셉
 */
public class SqlMapClientFactory {
	private static SqlMapClient smc;
	
	private SqlMapClientFactory() {}
	
	public static SqlMapClient getInstance() {
		if (smc == null) {
			
			try {
			// xml 문서 읽어오기
			// 설정파일 인코딩 정보 설정
			Charset charSet = Charset.forName("UTF-8");
			Resources.setCharset(charSet);
			
			// 설정파일 연결
			Reader rd = Resources.getResourceAsReader("SqlMapConfig.xml");
			
			// 읽어온 Reader객체를 이용하여 smc 객체 생성
			smc = SqlMapClientBuilder.buildSqlMapClient(rd);
			
			rd.close();
			
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return smc;
	}
}
