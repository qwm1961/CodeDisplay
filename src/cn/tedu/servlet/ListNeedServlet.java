package cn.tedu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.tedu.bean.Needs;
import cn.tedu.bean.Page;
import cn.tedu.bean.School;
import cn.tedu.service.NeedsService;
import cn.tedu.service.SchoolService;

@WebServlet("/ListNeedServlet")
public class ListNeedServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		String m=req.getParameter("m");
		switch(m) {
		case"1":
			/**
			 * 首页分页列表展示
			 */
			String index = req.getParameter("index");
			Page p = new Page();
			
			if (index != null) {
				p.setIndex(Integer.parseInt(index));
			}
			// 分页查询所有学校
			NeedsService ns = new NeedsService();
			List<Needs> list = ns.selectAllNeedByPage(p);
			
			// 查询总共有多少数据
			List<Needs> total =  ns.selectAllNeedByPage(p);
			p.setTotalRows(total.size());
			
			/**
			 * 需求查询学校
			 */
			SchoolService schService2 = new SchoolService();
			List<School> list3 = schService2.selectNedSchool();
			
			req.setAttribute("page", p);
			req.setAttribute("list", list);
			req.setAttribute("list2", list3);
			req.getRequestDispatcher("Need/index.jsp").forward(req, resp);
			
			break;
			
		case"2":
			/**
			 * 查询学校
			 */
			SchoolService schService = new SchoolService();
			List<School> list2 = schService.selectNedSchool();
			//System.out.println(list2);
			req.setAttribute("list", list2);
			req.getRequestDispatcher("Need/add.jsp").forward(req, resp);
			
			break;
			
		case"3":
			String nid = req.getParameter("id");
			int id = Integer.parseInt(nid);
			
			NeedsService schService3 = new NeedsService();
			Needs list4 = schService3.selectNedById(id);
			
			SchoolService schService4 = new SchoolService();
			List<School> list5 = schService4.selectNedSchool();
			
			req.setAttribute("list", list4);
			req.setAttribute("list2", list5);
			req.getRequestDispatcher("Need/edit.jsp").forward(req, resp);
			
			break;
			
		case"4":
			
		}
	}
	
}
