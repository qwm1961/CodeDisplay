package cn.tedu.servlet;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.tedu.bean.Admin;
import cn.tedu.service.AdminService;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet{
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
				req.setCharacterEncoding("utf-8");
				resp.setContentType("text/html;charset=utf-8");
				
				String username=req.getParameter("userName");
				String password=req.getParameter("passWord");
		
				Admin a=new Admin();
				a.setUname(username);
				a.setPassword(password);
				
				HttpSession session = req.getSession();
				AdminService as=new AdminService();
				
				Admin list=as.loginselect(a, session);
				if(list!=null) {
					
					if(list.getLv()>0) {
						req.setAttribute("name", username);
						req.getRequestDispatcher("index.jsp").forward(req, resp);
					}else {
						req.getRequestDispatcher("WebindexServlet?m=2").forward(req, resp);
					}
					
					
				}else {
					PrintWriter out=resp.getWriter();
					out.print("密码或者用户名错误！");
					out.close();
					}
			
		
		
		
		
	}

}
