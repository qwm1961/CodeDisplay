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
import cn.tedu.bean.Route;

import cn.tedu.service.RouteService;
import cn.tedu.service.WorkService;

@WebServlet("/RouteServlet")
public class RouteServlet extends HttpServlet{
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String method = req.getParameter("m");
		switch (method) {
		case "1":
			
			String Rname=req.getParameter("Rname");

			Date data=new Date();
			
			String createtime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(data);
			Route a=new Route();
			a.setRname(Rname);
			a.setCreateTime(createtime);
			//创建者
			HttpSession session=req.getSession();
			Admin ad=(Admin)session.getAttribute("loginUser");
			String crname=ad.getUname();
			a.setCrname(crname);
			//创建者
			RouteService a1=new RouteService();
			String x=a1.insertroute(a);
			if(x.equals("增加成功")) {
				req.getRequestDispatcher("RouteIndexServlet?cateid=1").forward(req, resp);
			}else {
				PrintWriter out=resp.getWriter();
				out.print(x);
				out.close();
			}
			break;
case "2":
			
			String id3=req.getParameter("id");
			int adid=Integer.parseInt(id3);
			RouteService ad3=new RouteService();
			String s=ad3.deleteroute(adid);
			if(s.equals("删除成功")) {
				req.getRequestDispatcher("RouteIndexServlet?cateid=1").forward(req, resp);
			}else {
				PrintWriter out=resp.getWriter();
				out.print(s);
				out.close();
			}
			
			break;
case "3":
		
		String param=req.getParameter("param");
		//System.out.println(param);
		RouteService as1=new RouteService();
		List<Route> list=as1.selectee(param);
		//System.out.println(list);
		if(list!=null) {
			req.setAttribute("list",list );
			req.getRequestDispatcher("Process/index.jsp").forward(req, resp);
		}else {
			PrintWriter out=resp.getWriter();
			out.print("查不到");
			out.close();
			}
		
		break;
	


}}
}