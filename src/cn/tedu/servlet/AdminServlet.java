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
import cn.tedu.bean.Recruitinfo;
import cn.tedu.service.AdminService;
import cn.tedu.service.ReService;
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet{
	
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		String method = req.getParameter("m");
		System.out.println(method);
		
		switch (method) {
		case "1":
			
			String Uname=req.getParameter("userName");
			String Password=req.getParameter("passWord");
			String School=req.getParameter("schId");
			String Lv1=req.getParameter("roleId");
			int Lv=Integer.parseInt(Lv1);
			String phone=req.getParameter("telephone");	
			Date data=new Date();
			String createtime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(data);
			
			Admin a=new Admin();
			
			a.setCreatetime(createtime);
			HttpSession session=req.getSession();
			Admin ad=(Admin)session.getAttribute("loginUser");
			String crname=ad.getUname();
			a.setCrname(crname);
			a.setLv(Lv);
			a.setPassword(Password);
			a.setSchool(School);
			a.setUname(Uname);
			a.setPhone(phone);
			
			AdminService a1=new AdminService();
			String x=a1.insertadmin(a);
			if(x.equals("注册成功")) {
				req.getRequestDispatcher("UserindexServlet?cateid=1").forward(req, resp);
			}else {
				PrintWriter out=resp.getWriter();
				out.print(x);
				out.close();
			}
			
			break;
			
		case "2":
			
			String i1=req.getParameter("id");
			int id=Integer.parseInt(i1);
			String Uname2=req.getParameter("userName");
			String phone2=req.getParameter("telephone");
			String roleId=req.getParameter("roleId");
			int Lv2=Integer.parseInt(roleId);
			Admin a2=new Admin();
			a2.setId(id);
			a2.setUname(Uname2);
			a2.setPhone(phone2);
			a2.setLv(Lv2);
			
			AdminService as=new AdminService();
			int i=as.updateadmin(a2);
			
			if(i!=0) {
				req.getRequestDispatcher("UserindexServlet?cateid=1").forward(req, resp);
			}else {
				PrintWriter out=resp.getWriter();
				out.print("后台出错");
				out.close();
			}
			
			break;
			
		case "3":
			
			String param=req.getParameter("param");
			AdminService re4=new AdminService();
        	List<Admin> list4=re4.selectname(param);
        	if(list4!=null) {
        		req.setAttribute("list", list4);
        		req.getRequestDispatcher("User/index.jsp").forward(req, resp);
        	}else {
        		PrintWriter out=resp.getWriter();
				out.print("所搜错误！");
				out.close();
        	}
			
//			String param=req.getParameter("param");
//			System.out.println(param);
//			AdminService as1=new AdminService();
//			List<Admin> list=as1.selectname(param);
//			System.out.println(list);
//			if(list!=null) {
//				PrintWriter out = resp.getWriter();
//				out.write(list.toString());
//				out.close();
//			}else {
//				PrintWriter out=resp.getWriter();
//				out.print("查无此人");
//				out.close();
//				}
			
			break;
		case "4":
			
			String id3=req.getParameter("id");
			int adid=Integer.parseInt(id3);
			AdminService ad3=new AdminService();
			String s=ad3.deleteadmin(adid);
			if(s.equals("删除成功")) {
				req.getRequestDispatcher("UserindexServlet?cateid=1").forward(req, resp);
			}else {
				PrintWriter out=resp.getWriter();
				out.print(s);
				out.close();
			}
			
			break;
		}
		
		
		
	}

}
