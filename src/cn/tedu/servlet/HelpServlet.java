package cn.tedu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.tedu.bean.Baoming;
import cn.tedu.service.BaoService;

@WebServlet("/HelpServlet")
public class HelpServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String mothd=req.getParameter("m");
		switch(mothd) {
		
		case"1":
			
			BaoService b=new BaoService();
			List<Baoming> list=b.selectbao();
			req.setAttribute("list", list);
			req.getRequestDispatcher("helpteacher/index.jsp").forward(req, resp);
			
			break;
		case"2":
			
			String param=req.getParameter("param");
			BaoService re4=new BaoService();
        	List<Baoming> list4=re4.selectname(param);
        	if(list4!=null) {
        		req.setAttribute("list", list4);
        		req.getRequestDispatcher("helpteacher/index.jsp").forward(req, resp);
        	}else {
        		PrintWriter out=resp.getWriter();
				out.print("所搜错误！");
				out.close();
        	}
        	
			break;
		case"3":
			String name=req.getParameter("name");
			String title=req.getParameter("title");
			String school=req.getParameter("school");
			String phone=req.getParameter("phone");
			String qq=req.getParameter("qq");
				Baoming bao=new Baoming();
				bao.setClassname(title);
				bao.setName(name);
				bao.setSchool(school);
				bao.setPhone(phone);
				bao.setQq(qq);
				
				BaoService b1=new BaoService();
				String result=b1.insertBao(bao);
				if(result.equals("报名成功")) {
					req.getRequestDispatcher("WebindexServlet?m=3").forward(req, resp);
				}else {
					PrintWriter out=resp.getWriter();
					out.print(result);
					out.close();
				}	
			break;
			
		}
	}

}
