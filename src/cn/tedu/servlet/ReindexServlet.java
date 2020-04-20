package cn.tedu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.tedu.bean.Recruitinfo;
import cn.tedu.bean.School;
import cn.tedu.service.ReService;
import cn.tedu.service.SchoolService;

@WebServlet("/ReindexServlet")
public class ReindexServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String mothd=req.getParameter("m");
		switch(mothd) {
        case"1":
			
			ReService re=new ReService();
			List<Recruitinfo> list=re.selectRecruitinfo();
			req.setAttribute("list", list);
			req.getRequestDispatcher("Adver/index.jsp").forward(req, resp);
			
			break;
        case"2":
        	
        	String id=req.getParameter("id");
        	int rid=Integer.parseInt(id);
        	ReService re2=new ReService();
        	Recruitinfo list2=re2.selectid(rid);
        	req.setAttribute("list2", list2);
        	req.getRequestDispatcher("Adver/edit.jsp").forward(req, resp);
        	
        	break;
        case"3":
        	
        	String id2=req.getParameter("id");
        	int rid2=Integer.parseInt(id2);
        	ReService re3=new ReService();
        	Recruitinfo list3=re3.selectid(rid2);
        	req.setAttribute("list3", list3);
        	req.getRequestDispatcher("Adver/show.jsp").forward(req, resp);
        	
        	break;
        case"4":
        	
        	String param=req.getParameter("param");
        	ReService re4=new ReService();
        	List<Recruitinfo> list4=re4.selectlike(param); 
        	if(list4!=null) {
        		req.setAttribute("list", list4);
        		req.getRequestDispatcher("Adver/index.jsp").forward(req, resp);
        	}else {
        		PrintWriter out=resp.getWriter();
				out.print("ËùËÑ´íÎó£¡");
				out.close();
        	}
        	
        	
        	break;
        case"5":
        	
        	SchoolService s1=new SchoolService();
			List<School> lsit=s1.findAllSchoolByPage();
			req.setAttribute("school", lsit);
			req.getRequestDispatcher("Adver/add.jsp").forward(req, resp);
        	
        	break;
		
		}
	}
	

}
