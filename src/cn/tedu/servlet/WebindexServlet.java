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
import cn.tedu.bean.Needs;
import cn.tedu.bean.Recruitinfo;
import cn.tedu.bean.Route;
import cn.tedu.service.WebService;
@WebServlet("/WebindexServlet")
public class WebindexServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		String mothd=req.getParameter("m");
		switch(mothd) {
		case"1":
			
			HttpSession session=req.getSession();
			Admin ad=(Admin)session.getAttribute("loginUser");
			if(ad!=null) {
				if(ad.getLv()>0) {
					String name=ad.getUname();
					req.setAttribute("name", name);
					req.getRequestDispatcher("index.jsp").forward(req, resp);
				}else {
					PrintWriter out=resp.getWriter();
					out.print("不是管理员！");
					out.close();
				}
			}else {
				PrintWriter out=resp.getWriter();
				out.print("请重新登录！");
				out.close();
			}
			
			break;
		case"2":
			
			WebService web=new WebService();
			List<Recruitinfo> list=web.selectRecruitinfo();
			List<Needs> list3=web.selectNeeds();
			req.setAttribute("list", list);
			req.setAttribute("list3", list3);
			req.getRequestDispatcher("main.jsp").forward(req, resp);
			
			break;
		case"3":
			
			WebService web2=new WebService();
			List<Recruitinfo> list2=web2.selectRecruitinfo();
			req.setAttribute("list2", list2);
			req.getRequestDispatcher("index/adverindex.jsp").forward(req, resp);
			
			break;
		case"4":
			
			String id=req.getParameter("id");
			int rid=Integer.parseInt(id);
			WebService web3=new WebService();
			Recruitinfo re=web3.Recruitinfoselectid(rid);
			//System.out.println(re);
			req.setAttribute("list", re);
			req.getRequestDispatcher("index/advershow.jsp").forward(req, resp);
			
			
			break;
		case"5":
			
			WebService web4=new WebService();
			List<Route> list4=web4.selectRoute();
			req.setAttribute("list2", list4);
			req.getRequestDispatcher("index/processindex.jsp").forward(req, resp);
			
			break;
		case"6":
			
			String id2=req.getParameter("id");
			int rid2=Integer.parseInt(id2);
			WebService web5=new WebService();
			Route re2=web5.selectid(rid2);
			System.out.println(re2);
			req.setAttribute("list", re2);
			req.getRequestDispatcher("index/processshow.jsp").forward(req, resp);
			
			break;
		case"7":
			
			WebService web6=new WebService();
			List<Dynamic> list5=web6.selectDynamic();
			req.setAttribute("list2", list5);
			req.getRequestDispatcher("index/workindex.jsp").forward(req, resp);
			break;
			
		case"8":
			
			String id1=req.getParameter("id");
			int rid1=Integer.parseInt(id1);
			WebService web7=new WebService();
			Dynamic re1=web7.selectid1(rid1);
			//System.out.println(re);
			req.setAttribute("list", re1);
			req.getRequestDispatcher("index/workshow.jsp").forward(req, resp);
			
			break;
		}
	}

}
