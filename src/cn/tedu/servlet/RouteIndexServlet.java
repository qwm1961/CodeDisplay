package cn.tedu.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.tedu.bean.Dynamic;
import cn.tedu.bean.Route;
import cn.tedu.service.RouteService;
import cn.tedu.service.WorkService;

@WebServlet("/RouteIndexServlet")
public class RouteIndexServlet extends HttpServlet {

protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		
		String method = req.getParameter("cateid");
		switch (method) {
		case "1":
			String param=req.getParameter("param");
				RouteService a=new RouteService();
				List<Route> ad=a.selectroute(param);
				req.setAttribute("list", ad);
				req.getRequestDispatcher("Process/index.jsp").forward(req, resp);	
			
		break;
}}
}