package cn.tedu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
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


@WebServlet("/WorkServlet")
public class WorkServlet extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		String method = req.getParameter("m");
		//System.out.println(method);
		
		switch (method) {
		case "1":
			
			String Title=req.getParameter("Title");
			String Dinfomation=req.getParameter("Dinfomation");
			String Dhistory=req.getParameter("Dhistory");
			
			Date data=new Date();
			String dcreatetime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(data);
			HttpSession session=req.getSession();
			Admin ad=(Admin)session.getAttribute("loginUser");
			String crname=ad.getUname();
			
			Dynamic a=new Dynamic();
			a.setDcreateTime(dcreatetime);
			a.setDname(crname);
			a.setTitle(Title);
			a.setDhistory(Dhistory);
			a.setDinfomation(Dinfomation);
			//System.out.println(a);
			WorkService a1=new WorkService();
			String x=a1.insertwork(a);
			//System.out.println(x);
			if(x.equals("发布成功")) {
				req.getRequestDispatcher("WorkIndexServlet?cateid=1").forward(req, resp);
			}else {
				PrintWriter out=resp.getWriter();
				out.print(x);
				out.close();
			}
			
			break;
			
		case "2":
			
			String i1=req.getParameter("id");
			int id=Integer.parseInt(i1);
			String Title2=req.getParameter("title");
			String Dinfomation2=req.getParameter("dinfomation");
			String Dhistory2=req.getParameter("dhistory");
//			System.out.println(Dinfomation2);
//			System.out.println(Dhistory2);
			Dynamic a2=new Dynamic();
			a2.setId(id);
			a2.setDhistory(Dhistory2);
			a2.setDinfomation(Dinfomation2);
			a2.setTitle(Title2);
			
			
			WorkService as=new WorkService();
			int i=as.updateadmin(a2);
//			System.out.println(i);
			if(i!=0) {
				req.getRequestDispatcher("WorkIndexServlet?cateid=1").forward(req, resp);
			}else {
				PrintWriter out=resp.getWriter();
				out.print("后台出错");
				out.close();
			}
			break;
           case "4":
			
			String id3=req.getParameter("id");
			int adid=Integer.parseInt(id3);
			WorkService ad3=new WorkService();
			String s=ad3.deletedynamic(adid);
			if(s.equals("删除成功")) {
				req.getRequestDispatcher("WorkIndexServlet?cateid=1").forward(req, resp);
			}else {
				PrintWriter out=resp.getWriter();
				out.print(s);
				out.close();
			}
			
			break;
           case "3":
   			
   			String param=req.getParameter("param");
   			//System.out.println(param);
   			WorkService as1=new WorkService();
   			List<Dynamic> list=as1.selectname(param);
   			//System.out.println(list);
   			if(list!=null) {
   				req.setAttribute("list",list );
   				req.getRequestDispatcher("Work/index.jsp").forward(req, resp);
   			}else {
   				PrintWriter out=resp.getWriter();
   				out.print("查不到");
   				out.close();
   				}
   			
   			break;
			
		}
		
}
}