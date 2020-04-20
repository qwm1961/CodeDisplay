package cn.tedu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.tedu.bean.Page;
import cn.tedu.bean.School;
import cn.tedu.service.SchoolService;

@WebServlet("/ListSchoolServlet")
public class ListSchoolServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String index = req.getParameter("index");
		// 创建页码对象
		Page p = new Page();
				
		if(index != null) {
			p.setIndex(Integer.parseInt(index));
		}
		
		// 分页查询所有学校
		SchoolService scService2 = new SchoolService();
		List<School> list = scService2.findAllSchoolByPage();
		
		// 查询总共有多少数据
		List<School> total = scService2.findAllSchoolByPage();
		p.setTotalRows(total.size());
		
		
		req.setAttribute("page", p);
		req.setAttribute("list", list);
		req.getRequestDispatcher("School/index.jsp").forward(req, resp);
	}
	
}
