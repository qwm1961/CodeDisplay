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
import cn.tedu.bean.School;
import cn.tedu.service.AdminService;
import cn.tedu.service.SchoolService;


@WebServlet("/UserindexServlet")
public class UserindexServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String method = req.getParameter("cateid");
		HttpSession sess=req.getSession();
		Admin adm=(Admin)sess.getAttribute("loginUser");
		switch (method) {
		case "1":
			
			if(adm.getLv()==5) {
				AdminService a=new AdminService();
				List<Admin> ad=a.selectadmin();
				
				req.setAttribute("list", ad);
				req.getRequestDispatcher("User/index.jsp").forward(req, resp);	
			}else {
				PrintWriter out=resp.getWriter();
				out.print("权限不够");
				out.close();
			}
			
			break;
		case "2":
			
			String id=req.getParameter("id");
			int aid=Integer.parseInt(id);
			AdminService a1=new AdminService();
			Admin list=a1.selectaid(aid);
			req.setAttribute("list", list);
			req.getRequestDispatcher("User/edit.jsp").forward(req, resp);
			
			break;
		case "3":
			
			String id1=req.getParameter("id");
			int aid1=Integer.parseInt(id1);
			AdminService a2=new AdminService();
			Admin list1=a2.selectaid(aid1);
			req.setAttribute("list", list1);
			req.getRequestDispatcher("User/show.jsp").forward(req, resp);
			
			break;
		case "4":
			
			if(adm.getLv()>=4) {
				AdminService ad2=new AdminService();
				List<Admin> list2=ad2.selectadmin();
				req.setAttribute("list2", list2);
				req.getRequestDispatcher("Role/index.jsp").forward(req, resp);
			}else {
				PrintWriter out=resp.getWriter();
				out.print("权限不够");
				out.close();
			}
			
			break;
		case "5":
			
			String id2=req.getParameter("id");
			req.setAttribute("id", id2);
			req.getRequestDispatcher("Role/edit.jsp").forward(req, resp);
			
			break;
		case "6":
			
			HttpSession session = req.getSession();
			session.removeAttribute("loginUser");
			resp.sendRedirect("login.jsp");
			
			break;
		case"7":
			
			SchoolService s1=new SchoolService();
			List<School> lsit=s1.findAllSchoolByPage();
			req.setAttribute("school", lsit);
			req.getRequestDispatcher("User/add.jsp").forward(req, resp);
			break;
		}
		
	}

}
