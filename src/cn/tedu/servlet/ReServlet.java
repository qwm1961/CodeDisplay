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
import cn.tedu.service.ReService;

@WebServlet("/ReServlet")
public class ReServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		String mothd=req.getParameter("re");
		switch(mothd) {
		case "1":
			
			String title=req.getParameter("title");
			String schId=req.getParameter("schId");
			String rinfomation=req.getParameter("Rinfomation");
			
			Date data=new Date();
			String createtime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(data);
			HttpSession session=req.getSession();
			Admin ad=(Admin)session.getAttribute("loginUser");
			String rrname=ad.getUname();
			
			Recruitinfo rec=new Recruitinfo();
			rec.setRcreateTime(createtime);
			rec.setRinfomation(rinfomation);
			rec.setRname(rrname);
			rec.setRschool(schId);
			rec.setTitle(title);
			
			ReService res=new ReService();
			String result=res.insertRecruitinfo(rec);
			if(result.equals("添加成功")) {
				req.getRequestDispatcher("ReindexServlet?m=1").forward(req, resp);
			}else {
				PrintWriter out=resp.getWriter();
				out.print(result);
				out.close();
			}
			
			break;
		case "2":
			
			String id=req.getParameter("id");
			int rid=Integer.parseInt(id);
			String title2=req.getParameter("title");
			String shcid=req.getParameter("shcid");
			String infomation=req.getParameter("infomation");
			
			Date data2=new Date();
			String createtime2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(data2);
			HttpSession session2=req.getSession();
			Admin ad2=(Admin)session2.getAttribute("loginUser");
			String rrname2=ad2.getUname();
			
			Recruitinfo rec2=new Recruitinfo();
			rec2.setId(rid);
			rec2.setRcreateTime(createtime2);
			rec2.setRinfomation(infomation);
			rec2.setRname(rrname2);
			rec2.setRschool(shcid);
			rec2.setTitle(title2);
			
			ReService res2=new ReService();
			String result2=res2.updateRecruitinfo(rec2);
			if(result2.equals("修改成功")) {
				req.getRequestDispatcher("ReindexServlet?m=1").forward(req, resp);
			}else {
				PrintWriter out=resp.getWriter();
				out.print(result2);
				out.close();
			}
			
			break;
		case"3":
			
			String id2=req.getParameter("id");
			int rid2=Integer.parseInt(id2);
			System.out.println(rid2);
			ReService res3=new ReService();
			String result3=res3.deleteRecruitinfo(rid2);
			if(result3.equals("删除成功")) {
				req.getRequestDispatcher("ReindexServlet?m=1").forward(req, resp);
			}else {
				PrintWriter out=resp.getWriter();
				out.print(result3);
				out.close();
			}
			
			break;
		}
	}

}
