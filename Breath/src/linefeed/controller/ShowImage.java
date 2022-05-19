package linefeed.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/showImage.LineFeed")
public class ShowImage extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String url = req.getParameter("url");
		System.out.println(url);
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(url));
		BufferedOutputStream bos = new BufferedOutputStream(resp.getOutputStream());
		
		int c = 0;
		while ((c = bis.read()) != -1) {
				bos.write(c);
		}
		bis.close();
		bos.close();
	}
}
