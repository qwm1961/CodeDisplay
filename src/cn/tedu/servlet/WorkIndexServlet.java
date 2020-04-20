package cn.tedu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.tedu.bean.Admin;
import cn.tedu.bean.Dynamic;

import cn.tedu.service.WorkService;




@WebServlet("/WorkIndexServlet")
public class WorkIndexServlet extends HttpServlet {
	@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
	
		String method = req.getParameter("cateid");
		switch (method) {
		case "1":
			
				WorkService a=new WorkService();
				List<Dynamic> ad=a.selectwork();
				req.setAttribute("list", ad);
				req.getRequestDispatcher("Work/index.jsp").forward(req, resp);	
			
		break;
		case "2":
			String id=req.getParameter("id");
			//System.out.println(id);
			int aid=Integer.parseInt(id);
			WorkService a1=new WorkService();
			Dynamic list=a1.selectaid(aid);
			req.setAttribute("list", list);
			req.getRequestDispatcher("Work/edit.jsp").forward(req, resp);

			break;
		case "3":
			String id1=req.getParameter("id");
			int aid1=Integer.parseInt(id1);
			WorkService a2=new WorkService();
			Dynamic list1=a2.selectaid(aid1);
			req.setAttribute("list", list1);
			req.getRequestDispatcher("Work/show.jsp").forward(req, resp);
			break;
}}}
